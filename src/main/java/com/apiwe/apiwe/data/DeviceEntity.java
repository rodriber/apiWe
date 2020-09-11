package com.apiwe.apiwe.data;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class DeviceEntity{
    @Size(min = 1, max = 16)
    private long id;
    private String mac;
    private Timestamp time;

    public DeviceEntity(){
    }

    public long getId(){
        return id;
    }

    public void setId( long ID ){
        this.id = ID;
    }

    public String getMac(){
        return mac;
    }

    public void setMac( String mac ){
        this.mac = mac;
    }

    public Timestamp getTime(){
        return time;
    }

    public void setTime( Timestamp time ){
        this.time = time;
    }

    public DeviceEntity( long id, String mac, Timestamp time ){
        this.id = id;
        this.mac = mac;
        this.time = time;
    }

    @Override
    public String toString(){
        return "DeviceEntity{" +
                "ID=" + id +
                ", mac='" + mac + '\'' +
                ", time=" + time +
                '}';
    }
}
