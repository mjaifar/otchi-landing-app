package com.otchi.web;

import com.otchi.domain.ClientsAddressesContainer;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MJR2 on 3/9/2017.
 */

@RestController("/")
public class CounterResource {

    private final ClientsAddressesContainer clientsAddressesContainer = new ClientsAddressesContainer();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/newclient", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody  String addNewClient(HttpServletRequest request){
        String clientAddress = request.getRemoteAddr();
        clientsAddressesContainer.addClient(clientAddress);
        String counterAsJson = "{\"counter\":" + clientsAddressesContainer.getCounter() + "}";
        return counterAsJson;
    }

}
