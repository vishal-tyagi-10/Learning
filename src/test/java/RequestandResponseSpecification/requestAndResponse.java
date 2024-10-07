package RequestandResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import Serialization.AddPOJO;
import Serialization.location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class requestAndResponse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AddPOJO add= new AddPOJO();
		add.setAccuracy(50);
		add.setAddress("29, side layout, cohen 09");
		add.setLanguage("French-IN");
		
		location l= new location();//create object to add the data in location and add in add place
		l.setLat(-38.38349);
		l.setLng(33.427362);
		add.setLocation(l);//pass the object of the location class because it contains all the details
		
		add.setName("Vishal Tyagi");
		add.setPhone_number("01234567");
		
		ArrayList<String> list= new ArrayList<>();//create arrayList because it contains list
		list.add("shoe park");
		list.add("shop");
		add.setTypes(list);
		
		add.setWebsite("http://google.com");
		
		
		//before RequestAnd Response SpecBuilder
		
		
//		RestAssured.baseURI="https://rahulshettyacademy.com";
//		String response=	given().body(add)//add is an object in body to serialization or add data in the json we create object and pass in body
//				.queryParam("key","qaclick123")
//			.when().post("/maps/api/place/add/json")
//			.then().assertThat().statusCode(200).extract().response().asString();
//		
//		System.out.println(response);
		
		
//build- Request SpecBuilder is  use we have something common in code in add ,delete post and put then to optimise we put in utily file and call it without writing again and again to optimise code 		
//build - Response SpecBuilder is similar to requestSpecBuilder but it store response common data
		
		
		// After Response And Request SpecBuilder
		
		//for Request
		RequestSpecification res= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key","qaclick123").build();  // always use build in the last to convert it into RequestSpecification
		
		//for Response
		ResponseSpecification response= new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		//for Specific request
		RequestSpecification r=	given().spec(res).body(add);  //use spec to use request in request
			
		Response result = r.when().post("/maps/api/place/add/json"); //use r. to use request specification
		
	String a=	result.then().spec(response).extract().response().asString();
	
	System.out.println(a);
	}

}
