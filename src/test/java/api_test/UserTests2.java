package api_test;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api_Endpoints.UserEndPoints2;
import api_payload.User;
import api_utilities.Log;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;

	User userpayload;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();

		userpayload = new User();

		userpayload.setId(faker.number().hashCode());

		userpayload.setUsername(faker.name().username());

		userpayload.setFirstName(faker.name().firstName());

		userpayload.setLastName(faker.name().lastName());

		userpayload.setEmail(faker.internet().emailAddress());

		userpayload.setPassword(faker.internet().password());

		userpayload.setPhone(faker.phoneNumber().cellPhone());

		userpayload.setUserStatus(faker.number().numberBetween(0, 5));
	}

	@Test(priority = 1)
	public void testPostUser() {

		Log.logger.info("Creating User");

		Response response = UserEndPoints2.createUser(userpayload);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

		Log.logger.info("User created");

	}

	@Test(priority = 2)
	public void testUserByname() {

		Log.logger.info("Retreving User");

		Response response = UserEndPoints2.getUser(this.userpayload.getUsername());

		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);

		Log.logger.info("User Retrevied");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {

		Log.logger.info("Updating User");

		userpayload.setFirstName(faker.name().firstName());

		userpayload.setLastName(faker.name().lastName());

		userpayload.setEmail(faker.internet().emailAddress());

		Response response = UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);

		Log.logger.info("User Updated");

		// checking data after update

		Response responseAfterUpdate = UserEndPoints2.getUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeleteUser() {

		Log.logger.info("Deleting User");

		Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());

		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);

		Log.logger.info("User Deleted");
	}

}
