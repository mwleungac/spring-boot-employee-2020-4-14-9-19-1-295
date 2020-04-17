package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.model.ParkingBoy;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import com.thoughtworks.springbootemployee.service.ParkingBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingBoys")
public class ParkingBoyController {

    @Autowired
    private ParkingBoyService parkingBoyService;

    @GetMapping
    public List<ParkingBoy> getParkingBoys(){
        return parkingBoyService.getAll();
    }

    @PostMapping
    public ParkingBoy addParkingBoy(@RequestBody ParkingBoy parkingBoy){
        return parkingBoyService.addParkingBoy(parkingBoy);
    }

}
