package org.example.park.report;

import org.example.park.Park;
import org.example.park.vehicle.Car;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;


public class ReportOperations{
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

    public static void reportFCTemplate(Map<String, Long> countryCT){
        List<String> countryCarCT = countryCT.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue() )
                        .collect(Collectors.toList());
//        System.out.println("________________________________\n" +
//                           " Report of foreign country cars \n" +
//                           for (String s : countryCarCT) +
//                           "_______________________________\n")
        countryCarCT.forEach(System.out::println);
    }



    public static Map<String, Long> carsCountry(ArrayList<Car> cars){
        Map<String, Long> countryCT = cars.stream()
                .collect(Collectors.groupingBy(Car::getCountry, Collectors.counting()));
        return  countryCT;
    }

    public static void fCarsNow(List<Car> cars, Car car){
        List<Car> fCarsList =  cars.stream()
                .filter(fcars -> !car.getCountry().equalsIgnoreCase("romania"))
                .collect(Collectors.toList());
    }

    public static List<Car> addCountry(List<Car> cars, String startWithThisString, String country){
        return cars.stream()
                .filter(c -> c.getRegistationNo().startsWith(startWithThisString))
                .map(c -> c=new Car(c.getRegistationNo(), country))
                //.peek(car -> System.out.println())
                .collect(Collectors.toList());

    }

//    generare raport doar cu masini cu nr straine       stream java 8 filter
//
//    filtrarea masinilor care au stat minim 3 ore in parcare
//
//    suma masini suma bani
//
//    xxxxx adaugarea unui nou camp de nationalitate in Car
//    atunci cand parcurg lista cu stream adaug in campul respectiv tara de provenienta operatiue map




}
