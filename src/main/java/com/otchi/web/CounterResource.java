package com.otchi.web;

import com.otchi.domain.ClientsAddressesContainer;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MJR2 on 3/9/2017.
 */

@RestController("/")
public class CounterResource {

    private final ClientsAddressesContainer clientsAddressesContainer = new ClientsAddressesContainer();

    @RequestMapping(value = "/newclient", method = RequestMethod.GET)
    public Integer addNewClient(HttpServletRequest request){
        String clientAddress = request.getRemoteAddr();
        clientsAddressesContainer.addClient(clientAddress);
        return clientsAddressesContainer.getCounter();
    }

}
