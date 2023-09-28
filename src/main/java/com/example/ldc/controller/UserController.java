package com.example.ldc.controller;

import com.example.ldc.client.*;
import com.example.ldc.requests.SaveClientRequest;
import com.example.ldc.requests.VehicleRegistrationRequest;
import com.example.ldc.vehicle.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final ClientService clientService;
    private final VehicleService vehicleService;

    public UserController(ClientService clientService, VehicleService vehicleService) {
        this.clientService = clientService;
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/save-client", method = RequestMethod.POST)
    public void saveClient(@RequestBody SaveClientRequest request) {
        String message = "Client with email " + request.email() + " is created successfully! ";

        clientService.saveClient(request);
        throw new ResponseStatusException(HttpStatus.CREATED, message
        );
    }

    @GetMapping("/{email}/data")
    @ResponseBody
    public GetClientResponse getClient(@PathVariable("email") String email) {
        return clientService.getClient(email);
    }



    @RequestMapping(value = "/save-vehicle", method = RequestMethod.POST)
    public void saveVehicle(@RequestBody VehicleRegistrationRequest request) {
        String message = "Vehicle "
                + request.manufacturer() + " " + request.model() + " with VIN Number "
                + request.vinNumber() + " registered successfully! ";

        vehicleService.saveVehicle(request);
        throw new ResponseStatusException(HttpStatus.CREATED, message);
    }
}
