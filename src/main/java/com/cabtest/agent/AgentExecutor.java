package com.cabtest.agent;

import com.cabtest.model.Billing;
import com.cabtest.model.Booking;
import com.cabtest.service.BillingRegisterService;
import com.cabtest.service.BookingRegisterService;
import org.springframework.core.task.TaskExecutor;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class AgentExecutor {

    private TaskExecutor taskExecutor;
    private AssignmentAgent assignmentAgent;
    private SettlementAgent settlementAgent;
    private BookingRegisterService bookingRegisterService;
    private BillingRegisterService billingRegisterService;
    private BlockingDeque<Booking> bookingQueue;
    private BlockingDeque<Billing> billingQueue;

    public AgentExecutor(TaskExecutor taskExecutor, AssignmentAgent assignmentAgent, SettlementAgent settlementAgent,
                         BookingRegisterService bookingRegisterService, BillingRegisterService billingRegisterService) {
        this.taskExecutor = taskExecutor;
        this.assignmentAgent = assignmentAgent;
        this.settlementAgent = settlementAgent;
        this.bookingRegisterService = bookingRegisterService;
        this.billingRegisterService = billingRegisterService;

        List<Booking> bookings = bookingRegisterService.getUnassignedBookingList();
        bookingQueue = new LinkedBlockingDeque<>(bookings);

        List<Billing> billings = billingRegisterService.getUnprocessedBillingEntries();
        billingQueue = new LinkedBlockingDeque<>(billings);

        assignmentAgent.setBookingQueue(bookingQueue);
        settlementAgent.setBillingQueue(billingQueue);

        taskExecutor.execute(assignmentAgent);
    }

    public AssignmentAgent getAssignmentAgent() {
        return assignmentAgent;
    }

    public SettlementAgent getSettlementAgent() {
        return settlementAgent;
    }

}

