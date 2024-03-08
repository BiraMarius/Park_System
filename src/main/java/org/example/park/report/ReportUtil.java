package org.example.park.report;

import org.example.park.vehicle.Car;

import java.io.*;
import java.util.List;

public class ReportUtil {
    public static List<Report> initDeserialization(List<Report> reports, String fileName){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            reports = (List<Report>) in.readObject();
            System.out.println("Reports read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public static void closeSerialization(List<Report> reports, String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream((filename)))){
            out.writeObject(reports);
            System.out.println("Reports written to file successfully.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
