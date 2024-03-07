package org.example.park.operations;

import org.example.park.report.Report;
import org.example.park.vehicle.Car;

import java.util.List;

public interface IParkOperations {
    void enterIntoParking(List<Car> cars, List<Report> reports, Car carAdded);
    void exitParkingByIndex(List <Car> cars, List<Report> reports, int indexOfRemovedCar);
    void exitParkingByObject(List <Car> cars, List<Report> reports, Car carAdded);
    void paymentWithRegistrationNo(List<Car> cars, List<Report> reports, String registrationNo, String payment);
    void paymentWithObject(List<Car> cars, List<Report> reports, Car car, String payment);
}
