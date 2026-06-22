package api_Endpoints;

import api_payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;
	}

	public static Response getUser(String username) {

		Response response = given().pathParam("username", username).when().get(Routes.get_url);

		return response;
	}

	public static Response updateUser(String username, User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", username).body(payload).when().put(Routes.update_url);

		return response;
	}

	public static Response deleteUser(String username) {

		Response response = given().pathParam("username", username).delete(Routes.delete_url);

		return response;
	}

}
