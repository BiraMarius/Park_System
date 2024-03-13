package org.example;

import org.example.park.Park;
import org.example.park.operations.GeneralOperations;
import org.example.park.operations.util.FileUtil;
import org.example.park.report.Report;
import org.example.park.report.ReportUtil;
import org.example.park.vehicle.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {
//        List<Car> cars = new ArrayList();
//        List<Car> newcars = new ArrayList();
//        //Car car = new Car("b800yam");
//        cars.add(new Car("b801yan"));
//        cars.add(new Car("b802yaz"));
//        cars.add(new Car("b803yah"));
//        //FileUtil.writeToFile(cars);
//        GeneralOperations.serializare(cars);
//        List<Car> cars2 = GeneralOperations.deserializare();
//        for (Car car : cars2){
//            System.out.println("Output= " + car.toString());
//        }


//        Calculate the sum of all elements in a list of integers.
//                Find the maximum element in a list of doubles.
//        Filter out all even numbers from a list of integers.
//        Count the number of occurrences of a specific element in a list of strings.
//        Convert a list of strings to uppercase.
//                Find the average length of strings in a list of strings.
//        Remove all duplicate elements from a list of integers.
//                Sort a list of strings in alphabetical order.
//                Check if all elements in a list of integers are positive.
//                Merge two l

//        List<Integer> newlist = new ArrayList();
//        newlist.add(1);
//        newlist.add(2);
//        newlist.add(3);
//
//
//        newlist.stream().map(nr -> nr.intValue() )
//                .mapToInt(Integer::intValue)
//                        .sum();
//
//        newlist.stream().mapToInt(nr -> nr.intValue()).sum();
//        int suma = newlist.stream().mapToInt(Integer::intValue).sum();
//        System.out.println("Suma>" +suma);
//
//        newlist.stream()
//                .filter(nr -> nr%2==0)
//                .collect(Collectors.toList());

        List<Car> cars = new ArrayList();
        cars.add(new Car("b801yan"));
        cars.add(new Car("b802yaz"));
        cars.add(new Car("b803yah"));

    }
}

//TODO > Try with resources read!
//