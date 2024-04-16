package APITests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;

import com.digicert.api.constant.Constant;
import com.digicert.api.util.Utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Requests {

	Properties properties;
	
	@BeforeTest
	public void setUp() {

		try {
			properties = Utility.fetchApiDetails(Constant.API_PROPERTY_FILE_PATH);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getListOfMoviesandCount() {
		RestAssured.baseURI = properties.getProperty("baseURL");

		Response res = given().when().get("/").then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.and().extract().response();

		String responseString = res.asString();
		System.out.println(responseString);

		// Convert the string into Json Response
		JsonPath js = new JsonPath(responseString);
		int count = js.getInt("count");
		for (int i = 0; i < count; i++) {

			String Movies = js.get("results[" + i + "].title");
			System.out.println(Movies + " " + i);
			
		}

		assertEquals(6, count);

	}

	@Test
	public void getThirdMovieandChecktheDirector() {
		RestAssured.baseURI = properties.getProperty("baseURL");
		given().when().get("/3").then().statusCode(200).assertThat().body("director", equalTo("Richard Marquand"));

	}

	@Test
	public void getFifthMovieandChecktheProducers() {
		
		RestAssured.baseURI = properties.getProperty("baseURL");
		given().when().get("/5").then().statusCode(200).assertThat().body("producer",
				not(allOf(equalTo("Gary Kurtz"), equalTo("George Lucas"))));

	}

	@AfterTest
	public void tearDown() {
		System.out.println("All Tests Finished");

	}
}
