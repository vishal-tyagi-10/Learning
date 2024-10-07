package Serialization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class AddPlacebyPojo {

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
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=	given().body(add)//add is an object in body to serialization or add data in the json we create object and pass in body
			.queryParam("key","qaclick123")
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(response);
	
	JsonPath js= new JsonPath(response);
	String Placeid=js.getString("place_id");
	
	
	
	//get add details
	String get=given().queryParam("place_id", Placeid).queryParam("key","qaclick123")
	.get("/maps/api/place/get/json")
	.then().statusCode(200).extract().response().asString();
	
	System.out.println(get);
	
	
	
	//update details
	
	String update=given()
	.body("{\r\n"
			+ "\"place_id\":\""+Placeid+"\",\r\n"
			+ "\"address\":\"70 winter walk, USA\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "")
	.put("/maps/api/place/update/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(update);
	
	
	
	//get add details
	
		String change =given().queryParam("place_id", Placeid).queryParam("key","qaclick123")
		.get("/maps/api/place/get/json")
		.then().statusCode(200).extract().response().asString();
		
		System.out.println(change);
	

	}

}
