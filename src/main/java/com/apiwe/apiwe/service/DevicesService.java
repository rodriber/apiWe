package com.apiwe.apiwe.service;

import com.apiwe.apiwe.model.DeviceEntity;
import com.apiwe.apiwe.model.IsValidMAC;
import com.apiwe.apiwe.repository.DeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevicesService{

    DeviceRepository deviceRepo = new DeviceRepository();

    // Find and return List of all device
    public ResponseEntity<List<DeviceEntity>> getAllDevice(){
        //Return Status_code: 200 OK, and List of Device Json
        return new ResponseEntity<> (deviceRepo.getListDevice(), HttpStatus.OK);
    }

    // Find and return a device by ID
    public ResponseEntity<DeviceEntity> getIdDevice(Long id){
        //Find and return a device or null is not exists
        DeviceEntity device = deviceRepo.getIdDevice(id);
        //Valid if device exists
        if(device != null){
            //Response Status_code: 200 OK, and Device found
            return new ResponseEntity<> (device, HttpStatus.OK);
        }else
        //Response Status_code: 204 No Content, Device not  found
        return new ResponseEntity<> (null, HttpStatus.NO_CONTENT);
    }

    // Find and return a device by MACaddress
    public ResponseEntity<DeviceEntity> getMacDevice(String p_mac){
        //Validate MACaddress format
        if(IsValidMAC.isValidMACAddress(p_mac)){
            //Get device by MaC
            DeviceEntity device = deviceRepo.getMacDevice(p_mac);
            //if device exist
            if(device != null){
                //Response Status_code: 200 OK, and Device found
                return new ResponseEntity<> (device, HttpStatus.OK);
            }else
                //Response Status code: 204 No Content, Device not  found
                return new ResponseEntity<> (null, HttpStatus.NO_CONTENT);
        }else
            //Response Status code: 400 Bad Request, wrong MAC format
            return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
    }

    // Insert a device in BD if not exists
    public ResponseEntity<String> insetDevice(DeviceEntity nuevo){
        //Validate MACaddress format
        if(IsValidMAC.isValidMACAddress(nuevo.getMac())) {
            //Response Status_code: 200 OK, and insert a Device in DBB
            return new ResponseEntity<>(deviceRepo.addDevice(nuevo), HttpStatus.OK);
        }else
            //Response Status code: 400 Bad Request, wrong MAC format
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    // Delete a device by ID
    public ResponseEntity<String> deleteDevice(DeviceEntity baja){
        if(deviceRepo.getIdDevice(baja.getId()) != null){
            //Response Status_code: 200 OK, delete device from DBB
            return new ResponseEntity<> (deviceRepo.delDevice(baja), HttpStatus.OK);
        }else
            //Response Status_code: 204 No Content, Device not  found
            return new ResponseEntity<> (null, HttpStatus.NO_CONTENT);
    }
}
