package API;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get_API {
	
	private static Scanner s;

	@Test
	public static void get() {
		
		s = new Scanner(System.in);
		System.out.println("Enter Author Name");
		//String S= s.next();
		
		
		
		RestAssured.baseURI="http://216.10.245.166";
		given().queryParam("ID","12345abcdef").
		when().get("/Library/GetBook.php").
		then().log().all().assertThat().statusCode(200);
		
	
		
	}

}
