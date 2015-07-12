package com.cabtest.service;

import com.cabtest.dao.GenericDAO;
import com.cabtest.dao.VehicleDAO;
import com.cabtest.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleRegisterServiceImpl extends GenericPersistenceServiceImpl<Vehicle, Integer>
        implements VehicleRegisterService {

    private VehicleDAO vehicleDAO;


    public VehicleRegisterServiceImpl() {
        super();
    }


    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    @SuppressWarnings("unchecked")
    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        super.setGenericDAO((GenericDAO) vehicleDAO);
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public Vehicle getAvailableVehicle(String vehicleType) {
      return null;
    }
}

