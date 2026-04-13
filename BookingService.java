import java.io.*;
import java.util.ArrayList;
public class BookingService {
	// The BookingService class controls the System's dynamics and operations
    // Uses Arraylists to store all users,rooms,and bookings  
	
	ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    
    private long nextBookingId=1;
    
    // To generate a unique booking ID with every booking
    public long generateBookingId() {
	   return nextBookingId++;}
    
    public int calculateNumberOfNights (int checkInDate,int checkOutDate){
    	return checkOutDate-checkInDate;}
    
    public int calculateTotalPrice (int numberOfNights,int price){
	   return numberOfNights*price;}
  
   
 public void showRooms() {
	for ( Room room : rooms) {
		System.out.println();
		System.out.println("Category: " + room.getCategory());
		System.out.println(room.getRoomId() + " | " + room.getPrice() + "$| Availability : " + room.getIsAvailable());}}
	    
 
 public void searchRooms(String category, int maxprice) {
	 boolean found = false;
	 for ( Room room : rooms) {
	 if(room.getCategory().equalsIgnoreCase(category) && maxprice>=room.getPrice()) {
		 System.out.println();
		  if(room.getIsAvailable().equalsIgnoreCase("Available")) {
			  System.out.println("Availabe rooms: ");
			  System.out.println();
			  System.out.println("Room ID: "+room.getRoomId()+" | Room Price: "+ room.getPrice() + "$ | Category: "+ room.getCategory() );}
		  else if(room.getIsAvailable().equalsIgnoreCase("Booked")) {
			  System.out.println("Booked Rooms: ");
			  System.out.println(room.getRoomId()+" | "+ room.getPrice() + "$ | Category: "+ room.getCategory() );}
		  else if(room.getIsAvailable().equalsIgnoreCase("Under Maintenance")) {
			  System.out.println("Under Maintenance Rooms: ");
			  System.out.println("Room ID: "+room.getRoomId()+" | Room Price: "+ room.getPrice() + "$ | Category: "+ room.getCategory()+ " | Will be Available in "+room.getMaintenanceDuration()+ " days");}
		 found = true;}}
		 
     if (!found) { System.out.println(" No such rooms are found! ");}}
 
 

 public void bookRoom(User user,long roomId,int checkInDate, int checkOutDate ) {
	 
	 if( checkOutDate<=checkInDate)
	 {System.out.println("Invalid dates! \nTry to book again and enter valid dates"); 
	  return;}
	 
	    for(Room room : rooms) {
	    	
		 if (room.getRoomId() == roomId) {
				
				 if(room.getIsAvailable().equals("Booked")) {
					 System.out.println("Room Already Booked!"); return;}
				 
				 int numberOfNights= calculateNumberOfNights (checkInDate,checkOutDate);
				 int totalPrice= calculateTotalPrice(numberOfNights,room.getPrice());
			 
				 if(room.getIsAvailable().equals("Available")) 
				 // The room is no more available, it becomes booked
				 {room.setIsAvailable("Booked") ;}
				 if(room.getIsAvailable().equals("Under Maintenance")) { System.out.println("Room is under maintenance! \n Maintenance ends in" +room.getMaintenanceDuration()+ " days");
				 return;}
				 
			 Booking b = new Booking();
			 b.setUser(user) ;
			 b.setRoom(room) ;
			 b.setStatus("Confirmed")  ;
			 b.setCheckInDate(checkInDate);
			 b.setCheckOutDate(checkOutDate);
			 long bookingId = generateBookingId();
			 b.setBookingId(bookingId);
		     b.setNumberOfNights(numberOfNights);
			 b.setTotalPrice(totalPrice);
			 bookings.add(b);
			 saveBookingToFile(b);
			 
			 System.out.println("Total Price: "+ totalPrice +"$");
			 System.out.println("Processing Payment...");
			 System.out.println("Payment Successful");
			 System.out.println("Booking ID: "+ bookingId);
			 System.out.println("Room Booked!");}
			 
		      return;}
			  

	    System.out.println("Room Not Found!");}
	    
 public void showAvailableRooms() {
	 
	 for(Room room :rooms) {
		 if(room.getIsAvailable().equals("Available")) {System.out.println("Room ID: " + room.getRoomId()+" \tPrice: "+room.getPrice()+"$");}}}
 
 
 public void showAllBookings() {
	 for (Booking booking : bookings) { 
		 System.out.println("Booking ID: " + booking.getBookingId());
		 System.out.println("User: " + booking.getUser().getName());
		 System.out.println("Room: " + booking.getRoom().getRoomId());
		 System.out.println("Nights: " + booking.getNumberOfNights());
		 System.out.println("Total: " + booking.getTotalPrice());
		 System.out.println("Status: " + booking.getStatus());}}
	 
public void viewBookingsByUser(long userId) {
	  boolean found = false;
	  int receipt=0;
	for(Booking booking : bookings) {
	 if (booking.getUser().getUserId() == userId) {
		 System.out.println("Booking ID: " + booking.getBookingId());
		 System.out.println("Room: " + booking.getRoom().getRoomId());
		 System.out.println("Duration of Stay: " +booking.getCheckInDate()+ " --> "+booking.getCheckOutDate()+" of this month");
		 System.out.println("Status: " + booking.getStatus());
		 System.out.println("Booking Price: " + booking.getTotalPrice() +"$");
		 System.out.println("--------------------");
		 found = true;
		 // Accumulates total payment for all bookings 
		 receipt += booking.getTotalPrice();}}
	 
	if(!found) {System.out.println("No Bookings found for this user.");}
	  else {System.out.println("Receipt: " + receipt +"$");}}

	 
	 
public void cancelBooking(long bookingId) {
	 for (Booking booking : bookings) { if (booking.getBookingId() == bookingId) {
		 // No booking so the room becomes available again
		 booking.getRoom().setIsAvailable("Available");
		 booking.setStatus("Cancelled");
		 System.out.println("Booking Cancelled!");
		 saveBookingToFile(booking);
		 return;}}
		 
     System.out.print("Booking ID not Found!");}

  // File I/O
 public void saveBookingToFile(Booking booking) {
	 try (PrintWriter writer = new PrintWriter(new FileWriter("bookings.txt",true));){
		 writer.println(booking.getBookingId()+ "," + booking.getUser().getName()+","+
	    		 booking.getRoom().getRoomId()+ "," + booking.getNumberOfNights()+ "," +booking.getTotalPrice()+ "," +booking.getStatus());
	 writer.close();} catch(IOException e) {System.out.println("Error saving booking to file");}}}
 









