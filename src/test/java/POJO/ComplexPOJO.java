package POJO;

public class ComplexPOJO {
	
	
	//Serialization and deserialization with pojo class
	// pojo class is plain old java object in this class variable and getter and setter present and object als
	//a class definition that is not tied to any Java framework so any Java program can use it. A POJO has no particular naming convention for properties and methods, or any other special restrictions.
	
	//serialization: is a process of converting java object into body(payload)
	
	//deserialization: is a process of converting response body back to java object
	
	//variable should be private and method should be public
	//to create getter and setter alt+shift+s
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	//private String courses;
	private courses courses;//it take data from child class course so to create object we use class name
	
	private String linkedIn;

	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public POJO.courses getCourses() {
		return courses;
	}
	public void setCourses(POJO.courses courses) {
		this.courses = courses;
	}
	
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedln(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}
