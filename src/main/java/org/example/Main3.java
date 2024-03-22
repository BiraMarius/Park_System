package org.example;

import org.example.park.vehicle.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList();
        cars.add(new Car("b801yan"));
        cars.add(new Car("b802yaz"));
        cars.add(new Car("b803yah"));
        cars.add(new Car("s801yan"));
        cars.add(new Car("s802yaz"));


        List<Car> cars2 = cars.stream()
                .filter(c -> c.getRegistationNo().startsWith("b"))
                .map(c -> c=new Car(c.getRegistationNo(), "RO"))
                .collect(Collectors.toList());

        for(Car car : cars2){
            System.out.println("Masina cu numar strain");
            System.out.println(car.getRegistationNo() + " is from: "+ car.getCountry());
        }
    }
}
