
public class Booking {
   private long bookingId;
   private User user;
   private Room room;
   private int checkInDate;
   private int checkOutDate;
   private int totalPrice;
   private String status;
   private int numberOfNights;
   
   public long getBookingId() {
		  return bookingId;}
   
   public User getUser() {
		  return user;}
   
   public Room getRoom() {
		  return room;}
   
   public int getCheckInDate() {
		  return checkInDate;}
   
   public int getCheckOutDate() {
		  return checkOutDate;}
   
   public int getNumberOfNights() {
		  return numberOfNights;}
   
   public int getTotalPrice() {
		  return totalPrice;}
   
   public String getStatus() {
		  return status;}
   
   public void setBookingId(long bookingId) {
		  this.bookingId=bookingId;}
   
   public void setUser(User user) {
	   this.user=user;}
   
   public void setRoom(Room room) {
		  this.room=room;}
   
   public void setCheckInDate(int checkInDate) {
		  this.checkInDate= checkInDate;}
   
   public void setCheckOutDate(int checkOutDate) {
		 this.checkOutDate=checkOutDate;}
   
   public void setTotalPrice(int totalPrice) {
		  this.totalPrice=totalPrice;}
   
   public void setStatus(String status) {
		  this.status=status;}
   
   public void setNumberOfNights(int numberOfNights) {
		  this.numberOfNights=numberOfNights;}
   
   
   public Booking() {}
   
   // Constructor
   public Booking(long bookingId, User user, Room room, int checkInDate, int checkOutDate,int totalPrice, int numberOfNights) {
	   this.bookingId=bookingId;
	   this.user= user;
	   this.room=room;
	   this.checkInDate=checkInDate;
	   this.checkOutDate=checkOutDate;
       this.totalPrice= totalPrice;
       this.numberOfNights= numberOfNights;}}
