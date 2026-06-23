package api_Endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api_payload.Pets;
import io.restassured.http.ContentType;

public class PetEndpoints {

	public static Response createuser(Pets payload) {
		
		System.out.println(Routes.post_url);

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;

	}

	public static Response getUser(int id) {
		
		System.out.println(Routes.get_url);

		Response response = given().pathParam("petId", id).when().get(Routes.get_url);

		return response;
	}

	public static Response updateUser(Pets payload, int id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("petId", id)
				.body(payload).when().put(Routes.update_url);

		return response;
	}

	public static Response deleteUser(int id) {

		Response response = given().pathParams("petId", id).when().delete(Routes.delete_url);

		return response;
	}
}
