package com.apiwe.apiwe.controller;

import com.apiwe.apiwe.repository.DeviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetDeviceControllerTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDevices() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/getDevices")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
              //  .andExpect(content().string(equalTo("Devices!")));
    }

    @Test
    public void getIdDevices() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/getIdDevices/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getIdDevices1() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.get("/getIdDevices/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
             //   .andExpect((ResultMatcher) jsonPath("mac", is("FF:FF:FF:FF:FF:FF")));
    }

    @Test
    void getMacDevicesOK() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.get("/getMacDevices/FF:FF:FF:FF:FF:FF")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getMacDevicesNOK() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.get("/getMacDevices/FF:FF:FF:FF:FF:FZ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getMacDevicesNull() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.get("/getMacDevices/FF:FF:FF:FF:FF:F3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void insertDevicesOK() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/insDevice").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("    {\n" +
                        "        \"mac\": \"F2:F2:FF:FF:FF:FF\",\n" +
                        "        \"time\": \"2020-09-10T12:01:00.000+00:00\",\n" +
                        "        \"id\": 5\n" +
                        "    }"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Insert device")));
    }

    @Test
    public void insertDevicesNOK() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/insDevice").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("    {\n" +
                        "        \"mac\": \"F2:F2:FF:FF:FF:FH\",\n" +
                        "        \"time\": \"2020-09-10T12:01:00.000+00:00\",\n" +
                        "        \"id\": 5\n" +
                        "    }"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteDevicesOK() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.delete("/delDevice")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("    {\n" +
                        "        \"id\": 3\n" +
                        "    }"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Deleted device")));
    }

    @Test
    void deleteDevicesNOK() throws Exception{
        DeviceRepository.cargaLista();
        mvc.perform(MockMvcRequestBuilders.delete("/delDevice")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("    {\n" +
                        "        \"id\": 4\n" +
                        "    }"))
                .andExpect(status().isNoContent());
    }
}