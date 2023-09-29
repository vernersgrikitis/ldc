package com.example.ldc.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveClient(@RequestBody SaveClientRequest request) {
        clientService.saveClient(request);
        throw new ResponseStatusException(HttpStatus.CREATED,
                "Client with email " + request.email() + " is created successfully! ");
    }

    @GetMapping("/{email}/data")
    @ResponseBody
    public GetClientResponse getClient(@PathVariable("email") String email) {
        return clientService.getClient(email);
    }
}
