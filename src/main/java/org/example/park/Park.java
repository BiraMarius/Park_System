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
    private List<Car> cars = new ArrayList<>();
    private List<Report> reports = new LinkedList<>();

    public void enter(Car car){
        super.enterIntoParking(cars, reports, car);
        test(car);
    }

    public void pay(String registrationNumber, String payment){
        super.paymentWithRegistrationNo(cars,reports,registrationNumber, payment);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void showPc(){
        showParkedCars(cars);
    }

    public void showReport(){
        printReport(searchReportByDate(reports,String.valueOf(timeFormatter(LocalDateTime.now()))));
    }

    public void test(Car car){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Marius\\Desktop\\Homework\\src\\Database",true));
            out.writeUTF("\n");
            out.writeObject(car);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public void getdb(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Marius\\Desktop\\Homework\\src\\Database",true));
            ObjectInputStream in = new ObjectInputStream();
            out.writeUTF("\n");
            out.writeObject(car);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}
