package pl.edu.amu.wmi.s474155;

import java.util.Map;
import java.util.Scanner;


public class HotelMain {
    public static String checkSLength(){
        Scanner scanCust = new Scanner(System.in);

        while (true) {
            try {
                String sexTest = scanCust.nextLine();
                if (sexTest.equals("f") || sexTest.equals("m")) {
                    return sexTest;
                }else{
                    throw new LengthException();
                }

            } catch (LengthException ex) {
                System.out.println("Gender length must be 1 letter: 'f' for 'female' and 'm' for 'male'");
            }

        }
    }

    public static void main (String[] args) throws Exception{
        int loop = 1;
        int forIsCompany11 = 1;
        int forClient12 = 1;
        int forRoom2 = 1;
        int forBooking3 = 1;

        Hotel hotel = new Hotel();
        while(loop != 0) {
            System.out.println("Enter what you want to do:");

            System.out.println("1. Add new client.");
            System.out.println("2. Add new room.");
            System.out.println("3. Add new booking.");

            System.out.println("4. Delete client");
            System.out.println("5. Delete room");
            System.out.println("6. Delete booking");
            System.out.println("7. Delete everything like EVERYTHING");

            System.out.println("8. Print out client");//7
            System.out.println("9. Print out company clients");
            System.out.println("10. Print out rooms");
            System.out.println("11. Print out bookings");

            System.out.println("12. Print out everything");

            System.out.println("13. Statistic: Print out average price for a room");
            System.out.println("14. Statisitc: Print out how many female and male clients in the hotel");

            System.out.println("15. Write everything to a file");
            System.out.println("16. Read everything from a file");

            System.out.println("17. Exit.");
            System.out.println("18. !!!!11!!1!!!!   TOP SECRET  !!!!!1!11!!!11!");
            Scanner scanAnswer = new Scanner(System.in);
            int answer = scanAnswer.nextInt();
            switch (answer) {
                case 1:
                    Scanner scanCust = new Scanner(System.in);

                    System.out.println("Enter client's ID: ");
                    int clientId = scanCust.nextInt();
                    scanCust.nextLine();

                    System.out.println("Enter client's surname: ");
                    String surname = scanCust.nextLine();

                    System.out.println("Enter client's name: ");
                    String name = scanCust.nextLine();

                    System.out.println("Enter client's sex: ");

                    String sex = checkSLength();

                    Scanner isCompany = new Scanner(System.in);
                    System.out.println("Is this client from a company?\n 1. yes\n 2. no");
                    int answIsCompany = isCompany.nextInt();
                    switch (answIsCompany){
                        case 1:
                            boolean receipt;
                            System.out.println("Does the client needs a receipt?\n 1. yes\n 2. no");
                            answIsCompany = isCompany.nextInt();

                            receipt = (answIsCompany == 1); /*if(answIsCompany == 1) receipt = true;
                                                            else receipt = false;*/
                            if(receipt) {
                                System.out.println("Enter receipt's id: ");
                                int recId = isCompany.nextInt();
                                CompanyClient customer = new CompanyClient(clientId, surname, name, sex, receipt, recId);
                                hotel.getCompanyClients().put(forIsCompany11, customer);
                            }else {
                                CompanyClient customer = new CompanyClient(clientId, surname, name, sex, receipt);
                                hotel.getCompanyClients().put(forIsCompany11, customer);
                            }

                           // System.out.println("Enter receipt's id: ");
                           // int recId = isCompany.nextInt();
                            //hotel.getCompanyClients().put(forIsCompany11, customer);

                            forIsCompany11 = forIsCompany11 + 1;
                            break;
                        case 2:

                            Client client = new Client(clientId, surname, name, sex);
                            hotel.getClients().put(forClient12, client);
                            forClient12 += 1;
                            break;
                    }
                    break;
                case 2:
                    Scanner scanRoom = new Scanner(System.in);

                    System.out.println("Enter room's number: ");
                    int roomNumber = scanRoom.nextInt();

                    System.out.println("Enter room's capacity: ");
                    int capacity = scanRoom.nextInt();

                    System.out.println("Enter room's price: ");
                    int price = scanRoom.nextInt();
                    Room room = new Room(roomNumber, capacity, price);
                    hotel.getRooms().put(forRoom2, room);
                    forRoom2 += 1;
                    
                    break;
                case 3:
                    Scanner scanBook = new Scanner(System.in);

                    System.out.println("Enter check-in date: ");
                    String checkInDateTime = scanBook.nextLine();

                    System.out.println("Enter check-out date: ");
                    String checkOutDateTime = scanBook.nextLine();

                    System.out.println("Enter booking type: ");
                    String bookingType = scanBook.nextLine();

                    Scanner scanCustForBook = new Scanner(System.in);

                    System.out.println("Enter client's ID: ");
                    int clientIdForBook = scanCustForBook.nextInt();
                    scanCustForBook.nextLine();

                    System.out.println("Enter client's surname: ");
                    String surnameForBook = scanCustForBook.nextLine();

                    System.out.println("Enter client's name: ");
                    String nameForBook = scanCustForBook.nextLine();

                    System.out.println("Enter client's sex: ");

                    String sexForBook = checkSLength();

                    Scanner isCompanyForBook = new Scanner(System.in);
                    System.out.println("Is this client from a company?\n 1. yes\n 2. no");
                    int answIsCompanyForBook = isCompanyForBook.nextInt();

                    switch (answIsCompanyForBook){
                        case 1:
                            boolean receipt;
                            System.out.println("Does the client needs a receipt?\n 1. yes\n 2. no");
                            answIsCompanyForBook = isCompanyForBook.nextInt();

                            receipt = (answIsCompanyForBook == 1); /*if(answIsCompany == 1) receipt = true;
                                                                     else receipt = false;*/

                            if (receipt){
                                System.out.println("Enter receipt's id: ");
                                int recId = isCompanyForBook.nextInt();
                                Booking bookingAndCompClient = new Booking(checkInDateTime, checkOutDateTime, bookingType, clientIdForBook, surnameForBook, nameForBook, sexForBook, receipt, recId, hotel, forIsCompany11);
                                hotel.getBookings().put(forIsCompany11, bookingAndCompClient);
                            } else {
                                Booking bookingAndCompClient = new Booking(checkInDateTime, checkOutDateTime, bookingType, clientIdForBook, surnameForBook, nameForBook, sexForBook, receipt, hotel, forIsCompany11);
                                hotel.getBookings().put(forIsCompany11, bookingAndCompClient);
                            }
                            //hotel.getBookings().put(forIsCompany11, bookingAndCompClient);
                            forBooking3++;
                            forIsCompany11++;
                            break;
                        case 2:
                            Booking bookingAndClient = new Booking(checkInDateTime, checkOutDateTime, bookingType, clientIdForBook, surnameForBook, nameForBook, sexForBook, hotel, forClient12);
                            hotel.getBookings().put(forBooking3, bookingAndClient);
                            forBooking3++;
                            forClient12++;
                            break;
                    }

                    break;

                case 4:
                    Scanner answDelCli = new Scanner(System.in);
                    System.out.println("You want to delete:\n1. ordinary client\n2. company client");
                    int whichCli = answDelCli.nextInt();
                    switch (whichCli){
                        case 1:
                            System.out.println("Which client you want to delete?:");
                            int delClient = answDelCli.nextInt();
                            hotel.getClients().remove(delClient);
                            break;
                        case 2:
                            System.out.println("Which client you want to delete?:");
                            int delCompClient = answDelCli.nextInt();
                            hotel.getCompanyClients().remove(delCompClient);
                            break;
                    }
                    break;

                case 5:
                    Scanner answDelRoom = new Scanner(System.in);
                    System.out.println("Which room you want to delete?:");
                    int delRoom = answDelRoom.nextInt();
                    hotel.getRooms().remove(delRoom);
                    break;

                case 6:
                    Scanner answDelBook = new Scanner(System.in);
                    System.out.println("Which booking you want to delete?:");
                    int delBook = answDelBook.nextInt();
                    hotel.getBookings().remove(delBook);
                    break;

                case 7:
                    hotel.getClients().clear();
                    hotel.getCompanyClients().clear();
                    hotel.getRooms().clear();
                    hotel.getBookings().clear();
                    break;
                case 8:
                    hotel.PrintClient(hotel);
                    break;

                case 9:
                    hotel.PrintCompClient(hotel);
                    break;

                case 10:
                    hotel.PrintRoom(hotel);
                    break;
                case 11:
                    hotel.PrintBooking(hotel);
                    break;

                case 12:
                    hotel.PrintEverything(hotel);
                    break;
                case 13:
                    float sumPrice = 0;
                    int count = 0;
                    for(Map.Entry<Integer, Room> entry:hotel.getRooms().entrySet()){
                        sumPrice += entry.getValue().getPrice();
                        count++;
                    }
                    float aver = sumPrice / count;
                    System.out.println("Average price for a room: " + aver );
                    break;


                case 14:
                    int sumFem = 0;
                    int sumMale = 0;
                    for (Map.Entry<Integer, Client> entry:hotel.getClients().entrySet()){
                        if (entry.getValue().getSex().equals("f")) sumFem++;
                        else sumMale++;
                    }
                    for (Map.Entry<Integer, CompanyClient> entry:hotel.getCompanyClients().entrySet()){
                        if (entry.getValue().getSex().equals("f")) sumFem++;
                        else sumMale++;
                    }
                    System.out.println("Amount of females: " + sumFem);
                    System.out.println("Amount of males: "+ sumMale);
                    break;

                case 15:
                    DataWriter write = new DataWriter();
                    write.dataWriter(hotel);
                    break;

                case 16:
                    DataReader reader = new DataReader();
                    reader.dataReader(hotel);
                    break;
                case 17:
                    System.out.println("It was hard but i made it");
                    loop = 0;
                    break;

                case 18:
                    Scanner answ = new Scanner(System.in);
                    System.out.println("Do you really wanna see it??\n1. yes\n2. no");
                    Thread.sleep(1500);
                    int answerTop = answ.nextInt();
                    if (answerTop == 1) {
                        Thread.sleep(1000);
                        System.out.println("You may regret it\n1. I'm ready\n2. Holy sh*t, I give up");
                        answerTop = answ.nextInt();
                        if (answerTop == 1){
                            HeeHeeThread heehee = new HeeHeeThread();
                            heehee.start();
                        }else break;
                    }else break;
                    Thread.sleep(11000);
            }
        }
    }
}
