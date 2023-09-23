package com.example.ldc.vehicle;


import com.example.ldc.clients.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    private final ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveCar(@RequestBody AddVehicleRequest request) {
        clientService.saveVehicle(request);
    }

}
