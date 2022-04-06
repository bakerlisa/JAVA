import java.util.ArrayList;

public class Sculpture extends Art {
    public String material;

    // CONSTRUCTORS
    public Sculpture(String title, String author, String description, String material){
        this.title = title;
        this.author = author;
        this.description = description;
        this.material = material;
        this.museum = new ArrayList<Art>();
    }

    // GETTERS
    public String getMaterial(){
        return material;
    }

    // SETTERS
    public void setMaterial(String madeWith){
        this.material = madeWith;
    }

    // METHODS
    public void viewArt(){
        System.out.println("Viewing Sculptures");
    }
}
