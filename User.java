
public class User {
   private long userId;
   private String name;
   private long contactNumber;
   
   
  public long getUserId() {
	  return userId;}
  
  public String getName() {
	  return name;}
  
  public long getContactNumber() {
	  return contactNumber;}
  
  public void setUserId(long userId) {
	  this.userId=userId;}
  
  public void setName(String name) {
	  this.name=name;}
  
  public void setContactNumber(long contactNumber) {
	  this.contactNumber=contactNumber;}
  
  
   public User() {}
   
   // Constructor
   public User(long userId,String name, long contactNumber) {
	   this.userId=userId;
	   this.name=name;
	   this.contactNumber=contactNumber;}}