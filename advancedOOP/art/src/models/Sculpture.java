package models;

public class Sculpture extends Art {
	public String paintType;
	
	public Sculpture(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.title = title;
        this.author = author;
        this.description = description;
        this.paintType = paintType;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
