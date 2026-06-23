package api_payload;

import java.util.List;

public class Pets {

	int id;
	Category category;
	String name;
	List<String> photoURLs;
	List<Tags> tags;
	String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoURLs() {
		return photoURLs;
	}

	public void setPhotoURLs(List<String> photoURLs) {
		this.photoURLs = photoURLs;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> list) {
		this.tags = list;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
