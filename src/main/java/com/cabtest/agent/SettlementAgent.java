package com.cabtest.agent;

import com.cabtest.ConfigurationBuilder;
import com.cabtest.bean.ReceiverType;
import com.cabtest.bean.TimeSlot;
import com.cabtest.model.Assignment;
import com.cabtest.model.Billing;
import com.cabtest.model.Settlement;
import com.cabtest.model.SettlementAggregate;
import com.cabtest.service.AssignmentService;
import com.cabtest.service.BookingRegisterService;
import com.cabtest.service.DistanceMatrixService;
import com.cabtest.service.DriverAvailabilityService;
import com.cabtest.service.DriverRegisterService;
import com.cabtest.service.SettlementService;
import com.cabtest.service.VehicleRegisterService;
import com.cabtest.util.SettlementUtil;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

public class SettlementAgent implements Runnable {
    private BlockingDeque<Billing> billingQueue;
    private DriverRegisterService driverRegisterService;
    private DriverAvailabilityService driverAvailabilityService;
    private BookingRegisterService bookingRegisterService;
    private VehicleRegisterService vehicleRegisterService;
    private AssignmentService assignmentService;
    private DistanceMatrixService distanceMatrixService;
    private SettlementService settlementService;
    private TimeSlot maxArriveTime = new TimeSlot(4);

    @Override
    public void run() {
        while (true) {
            System.out.println("running task 1 ");
            try {
                System.out.println("running task 2");
                Billing billing = billingQueue.take();
                System.out.println("running task 3");
                if (billing != null) {
                    performSettlement(billing);
                }
                if (isMonthlySettlement()) {
                    performMonthlySettlement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void performMonthlySettlement() {
        List<Settlement> settlements = settlementService.getEntriesToSettle(Calendar.getInstance().getTime());
        Map<Integer, SettlementAggregate> settlementAggregates = new HashMap<>();

        for (Settlement settlement : settlements) {
            if (settlementAggregates.get(settlement.getDriver().getDriverId()) != null) {
                SettlementAggregate driverSettlement = settlementAggregates.get(settlement.getDriver().getDriverId());
                driverSettlement.setAmount(driverSettlement.getAmount() + settlement.getDriverCharge());
                if (driverSettlement.getFromDate().getTime() > settlement.getDate().getTime()) {
                    driverSettlement.setFromDate(settlement.getDate());
                }
                driverSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                settlementAggregates.put(settlement.getDriver().getDriverId(), driverSettlement);
            } else {
                SettlementAggregate driverSettlement = new SettlementAggregate();
                driverSettlement.setReceiverId(settlement.getDriver().getDriverId());
                driverSettlement.setAmount(settlement.getDriverCharge());
                driverSettlement.setFromDate(settlement.getDate());
                driverSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                driverSettlement.setReceiverType(ReceiverType.DRIVER.name());
                settlementAggregates.put(settlement.getDriver().getDriverId(), driverSettlement);
            }

            if (settlementAggregates.get(settlement.getVehicle().getVehicleId()) != null) {
                SettlementAggregate vehicleSettlement = settlementAggregates.get(settlement.getVehicle().getVehicleId());
                vehicleSettlement.setAmount(vehicleSettlement.getAmount() + settlement.getVehicleCharge());
                if (vehicleSettlement.getFromDate().getTime() > settlement.getDate().getTime()) {
                    vehicleSettlement.setFromDate(settlement.getDate());
                }
                vehicleSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                settlementAggregates.put(settlement.getVehicle().getVehicleId(), vehicleSettlement);
            } else {
                SettlementAggregate vehicleSettlement = new SettlementAggregate();
                vehicleSettlement.setReceiverId(settlement.getVehicle().getVehicleId());
                vehicleSettlement.setAmount(settlement.getVehicleCharge());
                vehicleSettlement.setFromDate(settlement.getDate());
                vehicleSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                vehicleSettlement.setReceiverType(ReceiverType.VEHICLE.name());
                settlementAggregates.put(settlement.getVehicle().getVehicleId(), vehicleSettlement);
            }

            if (settlementAggregates.get(ConfigurationBuilder.getCabServiceIdentifier()) != null) {
                SettlementAggregate serviceSettlement = settlementAggregates.get(ConfigurationBuilder.getCabServiceIdentifier());
                serviceSettlement.setAmount(serviceSettlement.getAmount() + settlement.getServiceCharge());
                if (serviceSettlement.getFromDate().getTime() > settlement.getDate().getTime()) {
                    serviceSettlement.setFromDate(settlement.getDate());
                }
                serviceSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                settlementAggregates.put(ConfigurationBuilder.getCabServiceIdentifier(), serviceSettlement);
            } else {
                SettlementAggregate serviceSettlement = new SettlementAggregate();
                serviceSettlement.setReceiverId(ConfigurationBuilder.getCabServiceIdentifier());
                serviceSettlement.setAmount(settlement.getServiceCharge());
                serviceSettlement.setFromDate(settlement.getDate());
                serviceSettlement.setToDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                serviceSettlement.setReceiverType(ReceiverType.SERVICE.name());
                settlementAggregates.put(ConfigurationBuilder.getCabServiceIdentifier(), serviceSettlement);
            }

            settlement.setIsProcessed(true);
            settlementService.update(settlement);
        }
    }

    private boolean isMonthlySettlement() {
        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DAY_OF_MONTH);
        return date == ConfigurationBuilder.getMonthlySettlementDate();
    }

    private void performSettlement(Billing billing) {
        Assignment assignment = billing.getAssignment();
        double amount = billing.getAmount();
        Settlement settlement = new Settlement();
        settlement.setVehicle(assignment.getVehicle());
        settlement.setDriver(assignment.getDriver());
        settlement.setDriverCharge(SettlementUtil.getDriverCharge(amount));
        settlement.setVehicleCharge(SettlementUtil.getVehicleCharge(amount));
        settlement.setServiceCharge(SettlementUtil.getServiceCharge(amount));
    }

    public void setBillingQueue(BlockingDeque<Billing> billingQueue) {
        this.billingQueue = billingQueue;
    }
}
