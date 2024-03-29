package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.park.Park;
import org.example.park.operations.GeneralOperations;
import org.example.park.operations.util.FileUtil;
import org.example.park.report.Report;
import org.example.park.report.ReportOperations;
import org.example.park.report.ReportUtil;
import org.example.park.vehicle.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.example.park.operations.util.Constants.FILE_NAME;
import static org.example.park.operations.util.Constants.FILE_NAME_Reports;
import static org.example.park.report.ReportOperations.saveInDataBase;
import static org.example.park.report.ReportOperations.searchReportYesterday;


public class Main {
    //private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Park baneasaP = new Park();
        Park.setCars(GeneralOperations.deserializare(Park.getCars()));
        Park.setReports(ReportUtil.deserializare(Park.getReports()));
        ReportOperations.completeReport(Park.getReports());
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String carRN;
        System.out.println("          App navigation controls \n" +
                "            1 - Add car to parking \n" +
                "            2 - Pay cash \n" +
                "            3 - Pay card \n" +
                "            4 - Generate report of the day \n" +
                "            5 - Show cars parked \n" +
                "            6 - Save current state of parking \n" +
                "            7 - Get state of parking from file \n   " +
                "            8 - Close aplication \n  ");

        while(exit == false){
            String option = sc.nextLine();
            int intoption = Integer.valueOf(option);
            switch(intoption){
                case 1: //Adding car to the parking
                    System.out.println("Please enter car registration number: ");
                    //logger.info("Please enter car registration number: ");
                    carRN = sc.nextLine();
                    baneasaP.enter(new Car(carRN));
                    break;

                case 2: //Cash payment
                    System.out.println("Please enter car registration number for payment: ");
                    carRN = sc.nextLine();
                    baneasaP.pay(carRN,"CASH");
                    break;

                case 3: //Card payment
                    System.out.println("Please enter car registration number for payment: ");
                    carRN = sc.nextLine();
                    baneasaP.pay(carRN,"CARD");
                    break;

                case 4: //Show report of the day
                    System.out.println("Report for today till this time.");
                    baneasaP.showReport();
                    break;

                case 5: //Show all parked cars.
                    baneasaP.showPc();
                    break;

                case 6: // Save current state of parking
                    ReportUtil.cleanFile(FILE_NAME);
                    GeneralOperations.serializare(Park.getCars());

                case 7: // Get state of parking from file
                    Park.setCars(GeneralOperations.deserializare(Park.getCars()));

                case 8: // Closing app option
                    ReportUtil.cleanFile(FILE_NAME_Reports);
                    ReportUtil.cleanFile(FILE_NAME);
                    System.out.println("Shuting down.");
                    GeneralOperations.serializare(Park.getCars());
                    ReportUtil.serializare(Park.getReports());
                    exit=true;
                    break;

            }
        }



    }





}

