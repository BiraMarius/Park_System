package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.park.Park;
import org.example.park.operations.util.FileUtil;
import org.example.park.report.Report;
import org.example.park.report.ReportUtil;
import org.example.park.vehicle.Car;

import java.util.Scanner;

import static org.example.park.report.ReportOperations.saveInDataBase;
import static org.example.park.report.ReportOperations.searchReportYesterday;


public class Main {
    //private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Park baneasaP = new Park();
        FileUtil.deserializare(Park.getCars());
        ReportUtil.initDeserialization(Park.getReports(), "recycledReport.txt");
        saveInDataBase(searchReportYesterday(Park.getReports()));
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
                    FileUtil.serializare(Park.getCars());

                case 7: // Get state of parking from file
                    FileUtil.deserializare(Park.getCars());

                case 8: // Closing app option
                    System.out.println("Shuting down.");
                    FileUtil.serializare(Park.getCars());
                    ReportUtil.closeSerialization(Park.getReports(), "recycledReport.txt");
                    exit=true;
                    break;

            }
        }



    }





}

