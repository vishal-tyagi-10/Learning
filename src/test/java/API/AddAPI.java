package API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageloader.APIBODY;

import static io.restassured.RestAssured.*;

import java.util.Scanner;

import io.restassured.RestAssured;

public class AddAPI {

//	@Test
//	public void type() {
//		Scanner sc= new Scanner(System.in);
//		
//	
//		System.out.println("press 1 to enter manually and 2 for export from file");
//		int no=sc.nextInt();
//	
//		if(no==1) {
//			System.out.println("Enter isbn Number");
//			String isbn=sc.next();
//			System.out.println("Enter aisle Number");
//			String aisle=sc.next();
//			System.out.println("Enter Author Name");
//			String author=sc.next();
//			
//			AddAPI.addbook(isbn,aisle,author);
//		}
//		else {
//			AddAPI.useDataProvider();
//			
//		}
//		}	
//	
//	
//	public static void addbook(String isbn, String aisle ,String author) {
//		
//		RestAssured.baseURI="http://216.10.245.166";
//		given().header("Content-Type","application/json").body(APIBODY.body(isbn,aisle,author)).
//		when().post("Library/Addbook.php").
//		then().log().all().assertThat().statusCode(200).extract().response().asString();
//	}
//	
//	
//	
//	
//	
//	
//	  public static void useDataProvider() {
//	        Object[][] data = AddAPI.data();
//	        for (Object[] row : data) {
//	            String id = (String) row[0];//typecasting is done to convert Object to String but no type casting is required to convert string to Object: 
//	            String title = (String) row[1];
//	            String author = (String) row[2];
//	                                           
//	                                           // Autoboxing:For the primitive values (123 and true), 
//	                                           //Java automatically converts them to their corresponding wrapper
//	                                           // classes (Integer and Boolean)because the array is of type Object[].
//
//	            
////------forloop simple without autoboxing-----------------------------------------------------------------------------
////	            String[][] data = AddAPI.data1();
////		        for (int i=0;i<data.length;i++) {
////		            String id =  data[i][0];
////		            String title =  data[i][1];
//	            
//	            
//	            addbook(id, title,author);
//	        }
//	    }
////----------------------------	2nd use of data provider  --------------------------------------------------------
//	
//	@DataProvider(name="books")
//	public static  Object[][] data() {
//		return new Object[][] {{"12345","abcdef","Vishal"},{"123456","abcdefg","Tyagi"},{"12345678","abcfegyh","VishalTyagi"}};
//		
//	}
//	
//	
//	
//	
//	
//	
//	
	
//		
//----------------------------------2nd method for api testing using data provider-----------------------------------
		
		
		
	
	@Test(dataProvider="books")
		public void add(String isbn, String aisle,String author) {
		RestAssured.baseURI="http://216.10.245.166";
		given().log().all().header("Content-Type","application/json").body(APIBODY.body(isbn,aisle,author)).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200);
		
		System.out.print("=============GET LOG========");
		String id = isbn + aisle;
		System.out.println(given().basePath("Library/GetBook.php").params("ID", id).when().get().asPrettyString());
		}
		
	
	
	@DataProvider(name="books")
	public static  String[][] data1(){
		 String object[][]= {{"12345","abcdef","Vishal"},{"12345","abcdef","Tyagi"},{"12345678","abcfegyh","VishalTyagi"}};
		 return object;
	
	
		 
		 
		 
		 
		 
//------------------We can take body content for response from directly file without copy the data in.body().-----------------
//    content of the file to string takes 2 conversion: 1- file to byte   2- byte to string
//     .body(new String(Files.readAllBytes(Path.get(filepath))))    this method take data from file		 
		
	}
		
	

}
