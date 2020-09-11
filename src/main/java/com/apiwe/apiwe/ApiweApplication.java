package com.apiwe.apiwe;

import com.apiwe.apiwe.repository.DeviceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiweApplication{

    public static void main( String[] args ){
        SpringApplication.run (ApiweApplication.class, args);
        DeviceRepository.cargaLista();
    }

}
