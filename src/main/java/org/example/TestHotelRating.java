package org.example;

import java.util.Scanner;

public class TestHotelRating {

    static void main() {


        Scanner input = new Scanner(System.in);



        char runAgaian = 'y';


        while (runAgaian == 'y' || runAgaian == 'Y'){
            System.out.println("HOTEL RATING SYSTEM");

            System.out.println("==================================");


            System.out.println("Enter number of years: ");

            int numberOfYears = input.nextInt();


            System.out.println("Enter number of hotels");

            int numberOfHotels = input.nextInt();



            while (numberOfYears <= 0 || numberOfHotels <= 0){

                System.out.println("Number of years and hotels must be greater than zero");


                System.out.println("Enter number of years: ");

                numberOfYears = input.nextInt();

                System.out.println("Enter number of hotels: ");
                numberOfHotels = input.nextInt();
            }


            HotelRating hotel = new HotelRating(numberOfHotels, numberOfYears);


            System.out.println();

            System.out.println("Five stars hotel indices: ");

            int[] fiveStarHotels = hotel.fiveStarsHotels();


            if(fiveStarHotels.length == 0){
                System.out.println("None");
            }else {

                for(int i = 0; i < fiveStarHotels.length; i++){
                    System.out.println(fiveStarHotels[i]);

                    if(i < fiveStarHotels.length - 1){
                        System.out.println(", ");
                    }
                }
            }

            System.out.println();

            hotel.averageRatings();

            hotel.fourOrMoreStars();

            System.out.println("Any Five Stars hotel? " + hotel.anyFiveStars());


            System.out.println("Best hotel index: " + hotel.bestHotels());


            System.out.println("Worst hotel index: " + hotel.worstHotel());


            System.out.println();


            hotel.printChart();


            System.out.println("Would you like to run the program again (y/n)?");


            runAgaian = input.next().charAt(0);

            System.out.println();

        }


        System.out.println("Thank you for using the Hotel Rating System");



        input.close();


    }
}
