import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
      BookingService service = new BookingService();
       User user = new User(1,"Guest",123456789);
      service.rooms.add(new Room(100,"Standard",100,"Available",0));
      service.rooms.add(new Room(101,"Deluxe",200,"Booked",0));
      service.rooms.add(new Room(102,"Suite",300,"Under Maintenance",3));
        // Use while(true) to always display the main menu 
      while(true) {
    	  System.out.println();
    	  System.out.println("=== Welcome to the Hotel ===");
    	  System.out.println("1. Show Rooms");
    	  System.out.println("2. Search Rooms");
    	  System.out.println("3. Book Room");
    	  System.out.println("4. View Bookings");
    	  System.out.println("5. Cancel Booking");
    	  System.out.println("6. Exit");
    	  System.out.println();
    	  System.out.print("Choose an option: ");
    	  int choice = scan.nextInt();
    	  System.out.println();
    	  if (choice==1) {service.showRooms();}
    	  else if (choice ==2) {
    		 System.out.print("Enter Category: ");
    	     String category = scan.next();
    	     System.out.print("Enter Maximum Price: ");
    	     int maxprice =scan.nextInt();
    	     service.searchRooms(category, maxprice);}
    	  else if (choice==3) { service.showAvailableRooms();
    	    System.out.println();
    	    System.out.print("Enter Room ID: ");
    	    long roomId = scan.nextLong();
    	    System.out.print("Check in (Day 1-31): ");
    	    int checkInDate = scan.nextInt();
            System.out.print("Check out (Day 1-31): ");
    	    int checkOutDate = scan.nextInt();
    	    System.out.println();
    	    service.bookRoom(user, roomId, checkInDate, checkOutDate); }
    	  
    	  else if (choice==4) {System.out.print("Enter User ID: ");
	      long userId= scan.nextLong(); 
	      System.out.println("Hello "+ user.getName()+", Check out your Bookings:");
	      System.out.println("--------------------");
	      service.viewBookingsByUser(userId); }
    	  else if (choice==5) { System.out.print("Booking ID: ");
	      long bookingId= scan.nextLong();
	      service.cancelBooking(bookingId);}
    	  else if(choice==6) { break;}}}}
      
      
      
