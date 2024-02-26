package hackathon24;

import java.util.Random;

public class Occupancy {
    public static void main (String args[]){


        int maxBusPassengers = 60;
        boolean hasRoom = true;
        int occupancy = getRandomNumber();

        System.out.println("**Incoming Bus Request From Stop Ahead**");
        if (occupancy < 60 )
        {
            hasRoom = true;
            System.out.println("Bus Stop Accepted. Adding Stop to Route");

        }
        else {
            hasRoom = false;
            System.out.println("Bus Full, Passing Request to Next Bus");
        }
        System.out.println();
    }



    private static int getRandomNumber() {
        Random randomGenerator = new Random();

        // Generate random integers in the range 0 to 60
        int randomNumber = randomGenerator.nextInt(61);

        return randomNumber;
    }

}


//need it to move along the route
//need input from user
//need feedback