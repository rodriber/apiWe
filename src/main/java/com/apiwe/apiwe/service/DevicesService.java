package com.apiwe.apiwe.service;

import com.apiwe.apiwe.data.DeviceEntity;
import com.apiwe.apiwe.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevicesService{

    DeviceRepository deviceRepo = new DeviceRepository();

    public ResponseEntity<List<DeviceEntity>> getAllDevice(){

        return new ResponseEntity<> (deviceRepo.listDevice(), HttpStatus.OK);
    }

    public ResponseEntity<String> insetDevice(DeviceEntity nuevo){
        return new ResponseEntity<> (deviceRepo.addDevice(nuevo), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDevice(DeviceEntity baja){
        return new ResponseEntity<> (deviceRepo.delDevice(baja), HttpStatus.OK);
    }

}
