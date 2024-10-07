package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;



public class BugReporting_JIRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://vishaltyagi.atlassian.net";
		
		String response= given().header("Content-Type","application/json")
				.header("Authorization","Basic dmlzaGFsdHlhZ2k4NjhAZ21haWwuY29tOkFUQVRUM3hGZkdGMDYwUmQybE1nS1hvY25sUjVNajM5RTNaTjJ5Qm5tLVd3OVhNLU9JWVhZeXVCX2pWWGVqZFpZZExGT1haUnRtb01pUWVod0VGSHFRNjJFSmxROU5JS055V0d0elk5QVFTWFRpMVJMZWF5dHJjaG1rYWc3Rzk2QXhrRS1HSEhZWXRyWHFnbk9kUFJKWFZPTUhrdTE0d2xOeGUxTFl1V2RZWUFwYkFwVkFsRmN6OD01QzAyNkM2MQ==")

				
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "       \"project\":\r\n"
						+ "       {\r\n"
						+ "          \"key\": \"JT\"\r\n"
						+ "       },\r\n"
						+ "       \"summary\": \"Bug checking rest Assured.\",\r\n"
						+ "      \r\n"
						+ "       \"issuetype\": {\r\n"
						+ "          \"name\": \"Bug\"\r\n"
						+ "       }\r\n"
						+ "   }\r\n"
						+ "}")
				.when().post("/rest/api/3/issue")
				.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
	JsonPath js = new JsonPath(response);
	String str= js.getString("id");
	System.out.println(str);
	
	
	given().header("Content-Type","multipart/form-data; boundary=<calculated when request is sent>").pathParam("Key",str)
	.header("Authorization","Basic dmlzaGFsdHlhZ2k4NjhAZ21haWwuY29tOkFUQVRUM3hGZkdGMDYwUmQybE1nS1hvY25sUjVNajM5RTNaTjJ5Qm5tLVd3OVhNLU9JWVhZeXVCX2pWWGVqZFpZZExGT1haUnRtb01pUWVod0VGSHFRNjJFSmxROU5JS055V0d0elk5QVFTWFRpMVJMZWF5dHJjaG1rYWc3Rzk2QXhrRS1HSEhZWXRyWHFnbk9kUFJKWFZPTUhrdTE0d2xOeGUxTFl1V2RZWUFwYkFwVkFsRmN6OD01QzAyNkM2MQ==")
	.header("X-Atlassian_Token","no-check")
	.multiPart("file",new File("C:\\Users\\2303764\\OneDrive - Cognizant\\Pictures\\Screenshots\\Screenshot 2024-04-23 154643.png"))
    .post("/rest/api/3/issue/{Key}/attachments").then().log().all().statusCode(200);
	}

}
