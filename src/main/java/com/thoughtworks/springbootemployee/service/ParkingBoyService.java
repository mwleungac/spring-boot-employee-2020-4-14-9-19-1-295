package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.model.ParkingBoy;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.repository.ParkingBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingBoyService {

    @Autowired
    private ParkingBoyRepository parkingBoyRepository;

    public List<ParkingBoy> getAll() {
        return parkingBoyRepository.findAll();
    }

    public ParkingBoy addParkingBoy(ParkingBoy parkingBoy) {
        return parkingBoyRepository.save(parkingBoy);
    }

    public ParkingBoy updateParkingBoy(int parkingBoyId, ParkingBoy parkingBoy) {
        parkingBoyRepository.findById(parkingBoyId).orElse(null);
        parkingBoyRepository.save(parkingBoy);
        return parkingBoy;
    }

    public void deleteParkingBoy(int parkingBoyId) {
        parkingBoyRepository.deleteById(parkingBoyId);
    }
}
