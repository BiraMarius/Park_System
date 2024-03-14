package org.example.park.vehicle;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Vehiclee implements Serializable {
    private static int counter;
    private static int lastid;
    private int id;
    private String registationNo;
    private String country;
    private LocalDateTime parkingTime;
    private LocalDateTime unParkingTime;
    private String payment;


    public Vehiclee(String registationNo) {
        this.registationNo = registationNo;
        ++counter;
        id=lastid;
        lastid++;

    }

    public Vehiclee(String registationNo, LocalDateTime parkingTime){
        this.registationNo = registationNo;
        this.parkingTime = parkingTime;
    }

    public abstract void park();

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Vehiclee.counter = counter;
    }

    public static int getLastid() {
        return lastid;
    }

    public static void setLastid(int lastid) {
        Vehiclee.lastid = lastid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistationNo() {
        return registationNo;
    }

    public void setRegistationNo(String registationNo) {
        this.registationNo = registationNo;
    }

    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(LocalDateTime parkingTime) {
        this.parkingTime = parkingTime;
    }

    public LocalDateTime getUnParkingTime() {
        return unParkingTime;
    }

    public void setUnParkingTime(LocalDateTime unParkingTime) {
        this.unParkingTime = unParkingTime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
