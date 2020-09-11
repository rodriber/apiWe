package com.apiwe.apiwe.data;

import java.sql.Timestamp;


public class DeviceEntity{
    private int id;
    private String mac;
    private Timestamp time;

    public DeviceEntity(){
    }

    public int getId(){
        return id;
    }

    public void setId( int ID ){
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

    public DeviceEntity( int id, String mac, Timestamp time ){
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
