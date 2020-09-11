package com.apiwe.apiwe.service;

import com.apiwe.apiwe.data.DeviceEntity;
import com.apiwe.apiwe.repository.DeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevicesService{

    DeviceRepository deviceRepo = new DeviceRepository();

    public ResponseEntity<List<DeviceEntity>> getAllDevice(){

        return new ResponseEntity<> (deviceRepo.getListDevice(), HttpStatus.OK);
    }
    public ResponseEntity<DeviceEntity> getIdDevice(int id){
        DeviceEntity device = deviceRepo.getIdDevice(id);
        if(device != null){
            return new ResponseEntity<> (device, HttpStatus.OK);
        }else
        return new ResponseEntity<> (null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<DeviceEntity> getMacDevice(String p_mac){
        DeviceEntity device = deviceRepo.getMacDevice(p_mac);
        if(device != null){
            return new ResponseEntity<> (device, HttpStatus.OK);
        }else
            return new ResponseEntity<> (null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> insetDevice(DeviceEntity nuevo){
        return new ResponseEntity<> (deviceRepo.addDevice(nuevo), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDevice(DeviceEntity baja){
        return new ResponseEntity<> (deviceRepo.delDevice(baja), HttpStatus.OK);
    }
}
