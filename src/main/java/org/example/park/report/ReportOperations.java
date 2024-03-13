package org.example.park.report;

import org.example.park.Park;
import org.example.park.vehicle.Car;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
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

    public static void saveInDataBase(Report report, List<Car> cars){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("generatedCompleteReports.txt", true))) {
            writer.write("\n");
            writer.write(   "---------------------------------------\n"+
                                "              REPORT               \n"+
                                "Date of the report: "+report.getDate()+"\n"+
                                "Cars that entered: "+report.getCarsIn()+"\n"+
                                "Cars that leaved: "+report.getCarsOut()+"\n"+
                                "Cars left: "+cars.size()+"\n"+
                                "Income: "+report.getIncome()+"\n"+
                                "---------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void completeReport(LinkedList<Report> reports){
        if(reports.getLast().getDate() != timeFormatter(LocalDateTime.now())){
            saveInDataBase(searchReportYesterday(Park.getReports()),Park.getCars());
        }
    }

    public static Report reportFCars(List<Car> cars){

    }

    private static List<Car> carsCountry(){
        List<Car> carsCList = new ArrayList();

    }

    public static void FCarsNow(List<Car> cars, Car car){
        List<Car> fCarsList = (List<Car>) cars.stream().filter(fcars -> car.getCountry().equalsIgnoreCase("romania"));
        for(Car car2 : fCarsList){
            System.out.println("nr de inmatriculare");
        }
    }

    public static void addCountry(List<Car> cars, String string, String country){
        cars.stream().filter(c -> c.getRegistationNo().startsWith(string)).map(c -> { c.setCountry(country);return c.getRegistationNo() + " Is from: "+c.getCountry();});
    }




}
