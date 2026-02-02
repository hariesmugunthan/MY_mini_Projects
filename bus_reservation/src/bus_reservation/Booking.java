package bus_reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Booking {

    private int busNo;
   private String name;
    private Date date;
    Scanner o=new Scanner(System.in);

    public Booking() {
        System.out.println("enter your Name:");
        name=o.nextLine();
        System.out.println("enter the bus number:");
        busNo=o.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = o.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for(Bus bus:buses) {
            if(bus.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }

        int booked = 0;
        for(Booking b:bookings) {
            if(b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }

        return booked<capacity?true:false;

    }

}
