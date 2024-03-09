package org.example.park.operations;

import org.example.park.vehicle.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.park.operations.util.Constants.FILE_NAME;
import static org.example.park.operations.util.Constants.ROOT_PATH;


public class GeneralOperations {
    public static void serializare(List <Car> cars){
        closeSerialization(cars, ROOT_PATH + "\\" + FILE_NAME);
    }

    public static List<Car> deserializare(){
        return initDeserialization( ROOT_PATH + "\\" + FILE_NAME);
        //cleanFile();
    }


    public static List<Car> initDeserialization( String fileName) {
        try(FileInputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream );) {
             return  (ArrayList) objectInputStream.readObject();
        }catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            // Handle this exception as needed, e.g., log or inform the user
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        finally {
//            objectInputStream.close();
//            inputStream .close();
//        }
        return null;
    }


    private static void closeSerialization(List<Car> cars, String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream((filename)))){
            out.writeObject(cars);
            System.out.println("Objects written to file successfully.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    private static void cleanFile(){
//        try {
//            FileWriter fr = getFileWriter();
//            fr.write("");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
