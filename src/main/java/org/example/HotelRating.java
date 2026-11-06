package org.example;

import java.util.Random;

public class HotelRating {

    private int[][] ratings;


    public HotelRating(int numberOfHotels, int numberOfYears) {

        ratings = new int[numberOfHotels][numberOfYears];


        Random random = new Random();


        for(int i = 0; i < numberOfHotels; i++){

            for(int j = 0; j < numberOfYears; j++){

                ratings[i][j] = random.nextInt(5) + 1;
            }
        }
    }




    public int[] fiveStarsHotels(){

        int count = 0;

        // loop to count the hotels that earned 5 stars
        for(int i = 0; i < ratings.length; i++){

            for(int j = 0; j < ratings[i].length; j++){

                if(ratings[i][j] == 5){
                    count++;
                    break;
                }
            }
        }


        int[] hotels = new int[count];

        int idx = 0;

        // store the hotel indices
        for(int i = 0; i < ratings.length; i++){

            for(int j = 0; j < ratings[i].length; j++){

                if(ratings[i][j] == 5){
                    hotels[idx] = i;

                    idx++;
                    break;
                }
            }
        }

        return hotels;
    }


    public void averageRatings(){

        System.out.println("Average Ratings are: ");


        for(int i = 0; i < ratings.length; i++){

            double total = 0;

            for(int j = 0; j < ratings[i].length; j++){

                total += ratings[i][j];
            }

            double avg = total / ratings[i].length;


            System.out.printf("Hotel %d: %.2f%n", i, avg);
        }
    }


    public void fourOrMoreStars(){

        System.out.println("Four or more stars hotels indices: ");

        boolean first = true;

        for(int i = 0; i < ratings.length; i++){

            for(int j = 0; j < ratings[i].length; j++){


                if(ratings[i][j] >= 4){
                    if(!first){
                        System.out.println(", ");
                    }

                    System.out.println(i);

                    first = false;
                    break;
                }
            }
        }

        System.out.println();
    }


    // A, B, C, D, E
    // A -- 4
    // B -- 2
    // C -- 0
    // D -- 1
    // E -- 0


    public boolean anyFiveStars(){

        for(int i = 0; i < ratings.length; i++){

            for (int j = 0; j < ratings[i].length; j++){


                if(ratings[i][j] == 5){

                    return true;
                }
            }
        }

        return false;
    }



    public int bestHotels(){

        int bestIdx = 0;

        double highestAvg = 0;

        for(int i = 0; i < ratings.length; i++){

            double total = 0;


            for(int j = 0; j < ratings[i].length; j++){

                total += ratings[i][j];
            }

            double avg = total / ratings[i].length;

            if(avg > highestAvg){

                highestAvg = avg;

                bestIdx = i;
            }
        }

        return bestIdx;
    }


    public int worstHotel(){

        int worstIdx = 0;

        double lowestAvg = 6;


        for(int i = 0; i < ratings.length; i++){
            double total = 0;


            for(int j = 0; j < ratings[i].length; j++){

                total += ratings[i][j];
            }

            double avg = total / ratings[i].length;

            if(avg < lowestAvg){
                lowestAvg = avg;

                worstIdx = i;
            }
        }

        return worstIdx;
    }



    public void printChart(){

        System.out.println("Ratings Chart:");


        System.out.println();

        System.out.printf("%-12s", "");


        for(int j = 0; j < ratings[0].length; j++){


            System.out.printf("%-12s", "Year" + (j + 1));
        }

        System.out.println();

        for(int j = 0; j < ratings[0].length + 1; j++){

            System.out.println("------------------------");
        }

        System.out.println();

        for(int i = 0; i < ratings.length; i++){

            System.out.printf("%-12s", "Hotel " + i + ":");



            for(int j = 0; j < ratings[i].length; j++){

                String stars = "";

                for(int k = 0; k < ratings[i][j]; k++){
                    stars += "*";
                }

                System.out.printf("%-12s", stars);

            }

            System.out.println();
        }

        System.out.println();
    }

}
