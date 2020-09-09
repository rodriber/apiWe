package com.apiwe.apiwe.service;

import com.apiwe.apiwe.data.DeviceEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DevicesService{

    public ResponseEntity<DeviceEntity> getAllDevice (){

        Timestamp ts1 = Timestamp.valueOf("2020-09-09 09:01:15");
        DeviceEntity dd = new DeviceEntity (1,"FF:FF:FF:FF:FF:FF", ts1);

        return new ResponseEntity<> (dd, HttpStatus.OK);
    }
}
