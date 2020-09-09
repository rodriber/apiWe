package com.apiwe.apiwe.data;

import java.sql.Timestamp;

public class DeviceEntity{
    private int ID;
    private String mac;
    private Timestamp time;

    public DeviceEntity(){
    }

    public int getID(){
        return ID;
    }

    public void setID( int ID ){
        this.ID = ID;
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

    public DeviceEntity( int ID, String mac, Timestamp time ){
        this.ID = ID;
        this.mac = mac;
        this.time = time;
    }

    @Override
    public String toString(){
        return "DeviceEntity{" +
                "ID=" + ID +
                ", mac='" + mac + '\'' +
                ", time=" + time +
                '}';
    }
}
