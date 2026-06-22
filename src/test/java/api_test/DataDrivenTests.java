package api_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_Endpoints.UserEndPoints;
import api_payload.User;
import api_utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority = 1, dataProvider = "UserData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String id, String username, String firstName, String lastName, String email,
			String password, String phone) {

		User userpayload = new User();

		userpayload.setId((int)Double.parseDouble(id));
		userpayload.setUsername(username);
		userpayload.setFirstName(firstName);
		userpayload.setLastName(lastName);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);

		Response response = UserEndPoints.createUser(userpayload);

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String username) {
		Response response = UserEndPoints.deleteUser(username);

		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
