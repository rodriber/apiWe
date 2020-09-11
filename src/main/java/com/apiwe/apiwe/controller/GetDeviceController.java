package com.apiwe.apiwe.controller;

import com.apiwe.apiwe.data.DeviceEntity;
import com.apiwe.apiwe.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetDeviceController{

    @Autowired
    DevicesService devServ;

    @GetMapping("/getDevices")
    public ResponseEntity<List<DeviceEntity>> getDevices(){
        return devServ.getAllDevice();
    }

    @GetMapping("/getIdDevices/{p_id}")
    public ResponseEntity<DeviceEntity> getIdDevices(@PathVariable Integer p_id){

        return devServ.getIdDevice(p_id);
    }

    @GetMapping("/getMacDevices/{p_mac}")
    public ResponseEntity<DeviceEntity> getIdDevices(@PathVariable String p_mac){

        return devServ.getMacDevice(p_mac);
    }

    @PostMapping("/insDevice")
    public ResponseEntity<String> insertDevices(@RequestBody DeviceEntity dev)
    {
        return devServ.insetDevice(dev);
    }

    @DeleteMapping("/delDevice")
    public ResponseEntity<String> deleteDevices(@RequestBody DeviceEntity dev)
    {
        return devServ.deleteDevice(dev);
    }
}
