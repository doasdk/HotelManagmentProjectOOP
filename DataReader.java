package pl.edu.amu.wmi.s474155;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class DataReader {
    public void dataReader(Hotel hotel) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("K:\\uam\\programowanie obiektowe\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        hotel = (Hotel) objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        System.out.println("Clients\nindex\tid\tname\tsurname");
        for (Map.Entry<Integer, Client> entry:hotel.getClients().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getClientId() + "\t" + entry.getValue().getName() + "\t" + entry.getValue().getSurname());
        }

        System.out.println("Company Clients\nindex\tid\tname\tsurname");
        for (Map.Entry<Integer, CompanyClient> entry:hotel.getCompanyClients().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getClientId() + "\t" + entry.getValue().getName() + "\t" + entry.getValue().getSurname());
        }

        System.out.println("Rooms\nindex\tnumber\tcapacity\tprice");
        for(Map.Entry<Integer, Room> entry:hotel.getRooms().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getRoomNumber() + "\t" + entry.getValue().getCapacity()+"\t"+ entry.getValue().getPrice());
        }

        System.out.println("Bookings\nindex\tcheck-in date\tcheck-out\ttype");
        for(Map.Entry<Integer, Booking> entry:hotel.getBookings().entrySet()){
            System.out.println(entry.getKey() + " -\t" + entry.getValue().getCheckInDateTime() + "\t" + entry.getValue().getCheckOutDateTime() + "\t" + entry.getValue().getBookingType());
        }

    }
}
