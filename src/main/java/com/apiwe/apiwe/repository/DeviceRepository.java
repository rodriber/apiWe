package com.apiwe.apiwe.repository;

import com.apiwe.apiwe.data.DeviceEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepository{

    static List<DeviceEntity> listD = new ArrayList<> ();
    private static final Timestamp ts1 = Timestamp.valueOf("2020-09-09 09:01:00");
    private static final DeviceEntity d1 = new DeviceEntity (1,"FF:FF:FF:FF:FF:FF", ts1);
    private static final Timestamp ts2 = Timestamp.valueOf("2020-09-09 09:05:00");
    private static final DeviceEntity d2 = new DeviceEntity (2,"A0:00:00:00:00:01", ts2);
    private static final Timestamp ts3 = Timestamp.valueOf("2020-09-09 09:11:00");
    private static final DeviceEntity d3 = new DeviceEntity (3,"A1:B2:C3:D4:E5:F6", ts3);

    public static void cargaLista(){
        listD.add(d1);
        listD.add(d2);
        listD.add(d3);
    }

    public List<DeviceEntity> getListDevice(){
        return listD;
    }
    public DeviceEntity getIdDevice(Long p_id){
        return listD.stream()
                .filter(devi -> p_id.equals(devi.getId()))
                .findAny()
                .orElse(null);
    }

    public DeviceEntity getMacDevice(String p_mac){
        return listD.stream()
                .filter(devi -> p_mac.equals(devi.getMac()))
                .findAny()
                .orElse(null);
    }

    public String addDevice(DeviceEntity in){
        listD.add(in);
        return "Insert device";
    }

    public String delDevice(DeviceEntity in){

        listD.removeIf(i -> i.getId() == (in.getId()));
        return "Deleted device";
    }
}
