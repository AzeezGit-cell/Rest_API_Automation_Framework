package api_test;

import java.util.Arrays;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api_Endpoints.PetEndpoints;
import api_payload.Category;
import api_payload.Pets;
import api_payload.Tags;
import api_utilities.Log;
import io.restassured.response.Response;

public class PetTests {

	Faker faker;
	Pets pet;
	Category category;
	Tags tags;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();

		pet = new Pets();

		category = new Category();

		tags = new Tags();

		category.setId(faker.number().numberBetween(1000, 9999));
		category.setName(faker.animal().name());

		tags.setId(faker.number().numberBetween(1000, 9999));
		tags.setName(faker.animal().name());

		pet.setId(faker.number().numberBetween(1000, 9999));
		pet.setCategory(category);
		pet.setName(faker.name().name());
		pet.setPhotoURLs(Arrays.asList("photos.png"));
		pet.setTags(Arrays.asList(tags));
		pet.setStatus("Available");
	}

	@Test(priority = 1)
	public void createUser() {

		Log.logger.info("Creating pet");

		Response response = PetEndpoints.createuser(pet);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

		Log.logger.info("pet is created");
	}

	@Test(priority = 2)
	public void getUser() {

		Log.logger.info("Retreving pet");

		Response response = PetEndpoints.getUser(this.pet.getId());

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

		Log.logger.info("pet is retirved");
	}

	@Test(priority = 3)
	public void updateUser() {

		Log.logger.info("update a user");

		Response response = PetEndpoints.updateUser(pet, this.pet.getId());

		response.then().log().all();

		Log.logger.info("user is updated");
	}

	@Test(priority = 4)
	public void deleteUser() {

		Log.logger.info("Deleting a user");

		Response response = PetEndpoints.deleteUser(this.pet.getId());

		response.then().log().all();

		Log.logger.info("user is deleted");
	}
}
