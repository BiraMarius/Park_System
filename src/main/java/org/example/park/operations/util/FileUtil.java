package org.example.park.operations.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.example.park.vehicle.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    private static Logger logger = LogManager.getLogger(FileUtil.class);
    private static final String ROOT_PATH="C:\\Users\\Marius\\IdeaProjects\\meditatii1\\Park_System\\src\\main\\resources";
    private static final String FILE_NAME="filename.txt";
    public static void writeToFile(List<Car> cars) throws IOException{
        createOrSearchFile();
        FileWriter fr = getFileWriter();
        for(Car car : cars){
            String carString = car.toString();
            fr.write(carString+"\n");
        }
        fr.close();
    }



    private static FileWriter getFileWriter() throws IOException {
        return new FileWriter(ROOT_PATH+"\\"+FILE_NAME);
    }

    private static void createOrSearchFile() throws IOException {
        //Create file or search file
        File myObj = new File(ROOT_PATH + "\\" + FILE_NAME);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }
}
