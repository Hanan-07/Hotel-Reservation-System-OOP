
public class Room {
   private long roomId;
   private String category;
   private int price;
   private String isAvailable;
   private int maintenanceDuration;
   
   public long getRoomId() {
		  return roomId;}
   
   public String getCategory() {
		  return category;}
   
   public int getPrice() {
		  return price;}
   
   public String getIsAvailable() {
		  return isAvailable;}
   
   public int getMaintenanceDuration() {
	   return maintenanceDuration;}
   
   public void setIsAvailable(String isAvailable) {
	   this.isAvailable=isAvailable;}
   
   // Constructor
   public Room (long roomId, String category, int price , String isAvailable, int maintenanceDuration){
	   this.roomId= roomId;
	   this.category= category;
	   this.price= price;
	   this.isAvailable= isAvailable;
	   this.maintenanceDuration= maintenanceDuration;}}
