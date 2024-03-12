package org.example.park;

import org.example.park.operations.ParkOperations;
import org.example.park.report.Report;
import org.example.park.vehicle.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.example.park.operations.util.ParkOperationsUtil.showParkedCars;
import static org.example.park.report.ReportOperations.*;


public class Park extends ParkOperations {
    private static List<Car> cars = new ArrayList<>();
    private static LinkedList<Report> reports = new LinkedList<>();

    public void enter(Car car){
        super.enterIntoParking(cars, reports, car);
    }

    public void pay(String registrationNumber, String payment){
        super.paymentWithRegistrationNo(cars,reports,registrationNumber, payment);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static LinkedList<Report> getReports() {
        return reports;
    }

    public void showPc(){
        showParkedCars(cars);
    }

    public void showReport(){
        printReport(searchReportByDate(reports,String.valueOf(timeFormatter(LocalDateTime.now()))));
    }

    public static void setCars(List<Car> cars) {
        Park.cars = cars;
    }

    public static void setReports(LinkedList<Report> reports) {
        Park.reports = reports;
    }
}
