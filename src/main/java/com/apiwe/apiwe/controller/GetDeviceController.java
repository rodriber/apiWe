package com.apiwe.apiwe.controller;

import com.apiwe.apiwe.data.DeviceEntity;
import com.apiwe.apiwe.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDeviceController{

    @Autowired
    DevicesService devServ;

    @GetMapping("/getDevices")
    public ResponseEntity<DeviceEntity> getDevices (){
        return devServ.getAllDevice ();
    }
}
