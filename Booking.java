package pl.edu.amu.wmi.s474155;

import java.io.Serializable;

public class Booking implements Serializable {
    private String checkInDateTime;
    private String checkOutDateTime;
    private String bookingType;


    public Booking(String checkInDateTime, String checkOutDateTime, String bookingType, int clientId, String surname, String name, String sex, Hotel hotel, int forClient12){
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.bookingType = bookingType;
        Client customer = new Client(clientId, surname, name, sex);
        hotel.getClients().put(forClient12, customer);
    }

    public Booking(String checkInDateTime, String checkOutDateTime, String bookingType, int clientId, String surname, String name, String sex, boolean receipt, int recId, Hotel hotel, int forIsCompany11){
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.bookingType = bookingType;
        CompanyClient compClient = new CompanyClient(clientId, surname, name, sex, receipt, recId);
        hotel.getCompanyClients().put(forIsCompany11, compClient);
    }
    public Booking(String checkInDateTime, String checkOutDateTime, String bookingType, int clientId, String surname, String name, String sex, boolean receipt, Hotel hotel, int forIsCompany11){
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.bookingType = bookingType;
        CompanyClient compClient = new CompanyClient(clientId, surname, name, sex, receipt, 0);
        hotel.getCompanyClients().put(forIsCompany11, compClient);
    }


    public void setCheckInDateTime(String checkInDateTime){
        this.checkInDateTime = checkInDateTime;
    }
    public String getCheckInDateTime(){
        return checkInDateTime;
    }

    public void setCheckOutDateTime(String checkOutDateTime){
        this.checkOutDateTime = checkOutDateTime;
    }
    public String getCheckOutDateTime(){
        return checkOutDateTime;
    }

    public void setBookingType(String bookingType){
        this.bookingType = bookingType;
    }
    public String getBookingType(){
        return bookingType;
    }

}
