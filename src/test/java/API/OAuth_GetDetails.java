package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import POJO.ComplexPOJO;
import POJO.api;
import POJO.courses;
import POJO.webAutomation;

public class OAuth_GetDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=	given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

        .formParams("grant_type", "client_credentials")

        .formParams("scope", "trust")
        .when().log().all().post("/oauthapi/oauth2/resourceOwner/token").asString();
	
	System.out.println(response);
	
	JsonPath js= new JsonPath(response);
	String accessToken= js.getString("access_token");
	System.out.println(accessToken);
	
//	
//	String Details= given().queryParam("access_token", accessToken).log().all()
//	 .get("/oauthapi/getCourseDetails").asString();
//	
//	System.out.println(Details);
	
	
	//By use of pojo class
	
	ComplexPOJO gc=given().queryParam("access_token", accessToken).log().all()
	 .when().get("/oauthapi/getCourseDetails").as(ComplexPOJO.class);// to convert into deserialization we have to convert into java object and to convert we need supportive class that class is ComplexPOJO
	//this means convert that json into java object by taking help of ComplexPOJO class. this is deserialization
	
	System.out.println(gc.getExpertise());
	System.out.println(gc.getInstructor());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	//to find price dynamically not fixed
    List<api> course= gc.getCourses().getApi();
    for(int i=0;i<course.size();i++) {
    	if(course.get(i).getCourseTitle().equalsIgnoreCase("SoapUI webservices testing")) {
    		System.out.println(gc.getCourses().getApi().get(i).getPrice());
    	}
    }
    
    
    
    
    
    
    //comparing details dynamically 
    
    
    
    
    String[] details= {"Selenium Webdriver Java","Cypress","Protractor"};
    
    ArrayList<String> a= new ArrayList<String>();
    List<webAutomation> webAutomation=gc.getCourses().getWebAutomation();
    for(int i=0;i<webAutomation.size();i++) {
    	a.add( gc.getCourses().getWebAutomation().get(i).getCourseTitle());
    }
    
    List<String> str= Arrays.asList(details);
    
    Assert.assertTrue(a.equals(str));

	}

}
