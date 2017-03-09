package com.otchi.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by MJR2 on 3/9/2017.
 */
@RunWith(SpringRunner.class)
public class ClientsAddressesContainerTest {

    @Test
    public void testAddClient(){
        ClientsAddressesContainer clientsAddressesContainer = new ClientsAddressesContainer();
        Integer previousValue = clientsAddressesContainer.getCounter();
        clientsAddressesContainer.addClient("127.0.0.8");
        previousValue++;
        Assert.assertEquals(clientsAddressesContainer.getCounter(), previousValue);
    }
}