package com.example.ldc.controller;


import com.example.ldc.service.VehicleService;
import com.example.ldc.vehicle.addVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveCar(@RequestBody addVehicleRequest request) {
        vehicleService.saveVehicle(request);
    }
}
