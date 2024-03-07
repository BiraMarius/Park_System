package org.example.park.operations;

import org.example.park.vehicle.Car;

import java.io.*;
import java.util.List;

public class GeneralOperations {


    public static List<Car> initDeserialization(List<Car> cars, String fileName){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            cars = (List<Car>) in.readObject();
            System.out.println("Objects read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static void closeSerialization(List<Car> cars, String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream((filename)))){
            out.writeObject(cars);
            System.out.println("Objects written to file successfully.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
