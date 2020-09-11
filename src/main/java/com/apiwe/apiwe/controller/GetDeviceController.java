package com.apiwe.apiwe.controller;

import com.apiwe.apiwe.model.DeviceEntity;
import com.apiwe.apiwe.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
public class GetDeviceController{

    @Autowired
    DevicesService devServ;

    //Endpoint show all device
    @GetMapping("/getDevices")
    public ResponseEntity<List<DeviceEntity>> getDevices(){
        return devServ.getAllDevice();
    }

    //Endpoint show device by ID
    @Validated
    @GetMapping("/getIdDevices/{p_id}")
    public ResponseEntity<DeviceEntity> getIdDevices(@PathVariable @Size(min = 2, max = 16) Long p_id){

        return devServ.getIdDevice(p_id);
    }

    //Endpoint show device by MACaddress
    @GetMapping("/getMacDevices/{p_mac}")
    public ResponseEntity<DeviceEntity> getIdDevices(@PathVariable String p_mac){

        return devServ.getMacDevice(p_mac);
    }

    //EndPoint insert device
    @PostMapping("/insDevice")
    public ResponseEntity<String> insertDevices(@RequestBody DeviceEntity dev)
    {
        return devServ.insetDevice(dev);
    }

    //EndPoint delete device
    @DeleteMapping("/delDevice")
    public ResponseEntity<String> deleteDevices(@RequestBody DeviceEntity dev)
    {
        return devServ.deleteDevice(dev);
    }
}
