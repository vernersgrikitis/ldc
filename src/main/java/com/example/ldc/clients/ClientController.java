package com.example.ldc.clients;


import com.example.ldc.owner.Owner;
import com.example.ldc.owner.OwnerRequest;
import com.example.ldc.vehicle.AddVehicleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicle")
@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveCar(@RequestBody AddVehicleRequest request) {
        clientService.getVehicleRequest(request);
    }

    @GetMapping("/get-owner")
    public Owner getOwnerById(@RequestBody OwnerRequest request) {
        return clientService.getOwnerById(request);
    }


}
