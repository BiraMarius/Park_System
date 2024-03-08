package org.example.park.operations;

import org.example.park.vehicle.Car;

import java.io.*;
import java.util.List;

public class GeneralOperations {
//    public static List<Car> initDeserialization(List<Car> cars, String fileName){
//        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
//            cars = (List<Car>) in.readObject();
//            System.out.println("Objects read from file successfully.");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return cars;
//    }

    public static List<Car> initDeserialization(List<Car> cars, String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            // Check if the file is not empty before attempting to read
            if (in.available() > 0) {
                cars = (List<Car>) in.readObject();
                System.out.println("Objects read from file successfully.");
            } else {
                System.out.println("File is empty. No objects to deserialize.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            // Handle this exception as needed, e.g., log or inform the user
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static List<Car> initDeserialization(List<Car> cars, String fileName) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("filename.txt"));
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
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
