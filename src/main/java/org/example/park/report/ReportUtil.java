package org.example.park.report;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.example.park.operations.util.Constants.*;

public class ReportUtil {
    public static void serializare(LinkedList<Report> reports) {
        closeSerialization(reports, ROOT_PATH + "\\" + FILE_NAME_Reports);
    }

    public static LinkedList<Report> deserializare(LinkedList<Report> reports) {
        return initDeserialization(reports,ROOT_PATH + "\\" + FILE_NAME_Reports);
    }

    public static LinkedList initDeserialization(LinkedList<Report> reports, String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (LinkedList) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reports;
    }


    private static void closeSerialization(LinkedList<Report> reports, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream((filename)))) {
            out.writeObject(reports);
            System.out.println("Objects written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanFile(String filename){
        try {
            FileWriter fr = getFileWriter(filename);
            fr.write("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static FileWriter getFileWriter(String filename) throws IOException {
        return new FileWriter(ROOT_PATH+"\\"+filename);
    }



}
