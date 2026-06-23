package api_Endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api_payload.Pets;
import io.restassured.http.ContentType;

public class PetEndpoints {

	public static Response createuser(Pets payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;

	}

	public static Response getUser(Pets payload, int id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id", id)
				.body(payload).when().get(Routes.get_url + id);

		return response;
	}

	public static Response updateUser(Pets payload, int id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id", id)
				.body(payload).when().put(Routes.update_url + id);

		return response;
	}

	public static Response deleteUser(Pets payload, int id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id", id)
				.body(payload).when().post(Routes.delete_url + id);

		return response;
	}
}
