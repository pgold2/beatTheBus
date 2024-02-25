package hackathon24;

public class BusStop {

        public static String busStopNumber;
        public static String busStopLocation;

        public BusStop(String busStopNumber, String busStopLocation){
            this.busStopNumber = busStopNumber;
            this.busStopLocation = busStopLocation;

        }

        //setters
        public void setBusStopNumber(){
            this.busStopNumber = busStopNumber;
        }

        public void setLocation(){
            this.busStopLocation = busStopLocation;
        }



        //getters

        public static String getBusStopNumber() {
            return busStopNumber;
        }

        public static String getBusStopLocation() {
            return busStopLocation;
        }
    }


