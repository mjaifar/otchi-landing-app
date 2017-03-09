package com.otchi.domain;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MJR2 on 3/9/2017.
 */
public class ClientsAddressesContainer {

    private final static String FILE_NAME = "clients-addresses.txt";
    private final static Logger logger = Logger.getRootLogger();
    private Set<String> clientsAddresses;

    public ClientsAddressesContainer(){

        clientsAddresses = new HashSet<>();
        if(!Files.exists(Paths.get(FILE_NAME))){
            File file = new File(FILE_NAME);
        }
        load();
    }

    private void load(){
        try{
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientsAddresses = (Set<String>) ois.readObject();
        }catch(IOException ex){
            logger.error("unable to read counter from file: " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            logger.error("unable to de-serialize clients addresses");
        }

    }

    private void save(){
        try{
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(clientsAddresses);
        oos.close();
        } catch (IOException e) {
            logger.error("unable to write counter in  file: " + FILE_NAME);
        }
    }

    public void addClient(String address){
        clientsAddresses.add(address);
        save();
    }

    public Integer getCounter() {
        return clientsAddresses.size();
    }
}
