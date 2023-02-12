package pl.edu.amu.wmi.s474155;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Hotel implements Serializable {
    private Map<Integer, Client> clients = new HashMap<>();
    private Map<Integer, CompanyClient> companyClients= new HashMap<>();
    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();

    public Map<Integer, Client> getClients() { return clients; }
    public Map<Integer, CompanyClient> getCompanyClients() {
        return companyClients;
    }
    public Map<Integer, Room> getRooms() {
        return rooms;
    }
    public Map<Integer, Booking> getBookings() {
        return bookings;
    }

    public void PrintClient(Hotel hotel){
        System.out.println("Clients\nindex\tid\tname\tsurname");
        for (Map.Entry<Integer, Client> entry:hotel.getClients().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getClientId() + "\t" + entry.getValue().getName() + "\t" + entry.getValue().getSurname());
        }
    }

    public void PrintCompClient(Hotel hotel){
        System.out.println("Company Clients\nindex\tid\tname\tsurname");
        for (Map.Entry<Integer, CompanyClient> entry:hotel.getCompanyClients().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getClientId() + "\t" + entry.getValue().getName() + "\t" + entry.getValue().getSurname());
        }
    }

    public void PrintRoom(Hotel hotel){
        System.out.println("Rooms\nindex\tnumber\tcapacity\tprice");
        for(Map.Entry<Integer, Room> entry:hotel.getRooms().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getRoomNumber() + "\t" + entry.getValue().getCapacity()+"\t"+ entry.getValue().getPrice());
        }
    }

    public void PrintBooking(Hotel hotel){
        System.out.println("Bookings\nindex\tcheck-in date\tcheck-out\ttype");
        for(Map.Entry<Integer, Booking> entry:hotel.getBookings().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getCheckInDateTime() + "\t" + entry.getValue().getCheckOutDateTime() + "\t" + entry.getValue().getBookingType());
        }
    }

    public void PrintEverything(Hotel hotel) {
        PrintClient(hotel);
        PrintCompClient(hotel);
        PrintRoom(hotel);
        PrintBooking(hotel);

    }

}
