package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.park.Park;
import org.example.park.vehicle.Car;

import java.util.Scanner;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        Park baneasaP = new Park();
        Scanner sc = new Scanner(System.in);
        int startStop = 0;
        String carRN;
        // opt 0 - Get previos state - deserialization
        // opt 1 - Save current state - serialization
        System.out.println("1 - Add \n" +
                "            2 - Pay cash \n" +
                "            3 - Pay card \n" +
                "            4 - Report of the day \n" +
                "            5 - Save report to bd \n" +
                "            6 - EXIT \n" +
                "            7 - List \n");

        while(startStop != 1){
            String option = sc.nextLine();
            int intoption = Integer.valueOf(option);
            switch(intoption){
                case 1: //Adding car to the parking
                    logger.info("Please enter car registration number: ");
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

                case 5: //save report
                    break;

                case 6: System.out.println("Shuting down.");
                    startStop=1;
                    break;

                case 7: //Show all parked cars.
                    //BaneasaP.showParkedCars();
                    baneasaP.showPc();
                    break;
            }
        }



    }





}

