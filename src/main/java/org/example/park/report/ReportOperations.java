package org.example.park.report;

import org.example.park.vehicle.Car;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.example.park.operations.util.Constants.FILE_NAME;
import static org.example.park.operations.util.Constants.ROOT_PATH;

public class ReportOperations implements IReportOperations {
    public static Report searchReportByDate(List<Report> reports, String date){
            for(int i=0; i<reports.size(); i++){
                if(reports.get(i).getDate().equals(date)){
                      return reports.get(i);
                }
            }
            return createNewReport(reports, date);
    }

    public static Report createNewReport(List<Report> reports, String date){
        Report report = new Report(date);
        reports.add(report);
        return report;
    }

    public static Report searchReportYesterday(List<Report> reports){
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime yesterdayDateTime = currentDateTime.minus(1, ChronoUnit.DAYS);
        return searchReportByDate(reports, timeFormatter(yesterdayDateTime));
    }

    public static void saveInDataBase(Report report){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reportDatabase.txt", true))) {
            writer.write("\n");
            System.out.println( "---------------------------------------\n"+
                                "              REPORT               \n"+
                                "Date of the report: "+report.getDate()+"\n"+
                                "Cars that entered: "+report.getCarsIn()+"\n"+
                                "Cars that leaved: "+report.getCarsOut()+"\n"+
                                "Cars left: "+carsLeft(report)+"\n"+
                                "Income: "+report.getIncome()+"\n"+
                                "---------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        public static void serializare(List <Car> cars){
//            closeSerialization(cars, ROOT_PATH + "\\" + FILE_NAME);
//        }
//
//        public static List<Car> deserializare(){
//            return initDeserialization( ROOT_PATH + "\\" + FILE_NAME);
//            //cleanFile();
//        }
//
//
//        public static List<Car> initDeserialization( String fileName) {
//            try(FileInputStream inputStream = new FileInputStream(fileName);
//                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream );) {
//                return  (ArrayList) objectInputStream.readObject();
//            }catch (FileNotFoundException e) {
//                System.out.println("File not found: " + fileName);
//                // Handle this exception as needed, e.g., log or inform the user
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//
//        private static void closeSerialization(List<Car> cars, String filename){
//            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream((filename)))){
//                out.writeObject(cars);
//                System.out.println("Objects written to file successfully.");
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }


    }

    public static void addCarsToCt(Report report){
        report.setCarsIn(report.getCarsIn()+1);
    }

    public static void removedCarsToCt(Report report){
        report.setCarsOut(report.getCarsOut()+1);
    }

    public static int carsLeft(Report report){
        int carsLeft = report.getCarsIn()-report.getCarsOut();
        report.setCarsLeft(carsLeft);
        return carsLeft;
    }

    public static long calculateIncome(Report report, int price){
        report.setIncome(report.getIncome()+price);
        return report.getIncome();
    }

    public static String timeFormatter(LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedTime = time.format(formatter);
        return formattedTime;
    }

    public static void printReport(Report report){
        System.out.println("---------------------------------------\n"+
                           "              REPORT               \n"+
                           "Date of the report: "+report.getDate()+"\n"+
                           "Cars that entered: "+report.getCarsIn()+"\n"+
                           "Cars that leaved: "+report.getCarsOut()+"\n"+
                           "Cars left: "+carsLeft(report)+"\n"+
                           "Income: "+report.getIncome()+"\n"+
                           "---------------------------------------");
    }

    //Adauga serializarea noua aici

}
