package org.example.park.vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Car extends Vehiclee {
    public Car(String registationNo) {
        super(registationNo);
    }

    @Override
    public void park(){
        System.out.println("##################  TICKET  #####################\n" +
                           "Registration number plate:  "+getRegistationNo()+"\n"+
                           "Parking details:  "+parkingTimeF()+"\n"+
                           "Ticket NO: "+getId()+"\n"+
                           "#################################################"+"\n");
    }

    public String parkingTimeF(){
        LocalDateTime parkingTime = getParkingTime();
        return timeFormatter(parkingTime);
    }

    public String unParkingTimeF(){
        LocalDateTime unParkingTime = LocalDateTime.now();
        return timeFormatter(unParkingTime);
    }

    public String timeFormatter(LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedTime = time.format(formatter);
        return formattedTime;
    }

    public void details(){
        System.out.println("############    DETAILS   ###########");
        System.out.println(getId());
        System.out.println(getRegistationNo());
        System.out.println((parkingTimeF()));
        //System.out.println(unParkingTimeF());
        System.out.println("#####################################");
    }

    @Override
    public String toString() {
        return this.getId() + this.getRegistationNo();
    }

}
