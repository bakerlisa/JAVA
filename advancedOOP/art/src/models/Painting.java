package models;

public class Painting extends Art {
	public String material;

	public Painting(String title, String author, String description, String material) {
		super(title, author, description);
		this.title = title;
        this.author = author;
        this.description = description;
        this.material = material;   
	}
	

	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}

}
