import java.util.ArrayList;

public class Painting extends Art {
    public String paintType;

    // CONSTRUCTORS
    public Painting(String title, String author, String description, String paintType){
        this.title = title;
        this.author = author;
        this.description = description;
        this.paintType = paintType;
        this.museum = new ArrayList<Art>();
    }

    // GETTERS
    public String getPainting(){
        return paintType;
    }
    
    // SETTERS
    public void setPainting(String artwork){
        this.paintType = artwork;
    }

    // METHODS
    public void viewArt(){
        System.out.println("Viewing Paintings");
    }
    public void addToMuseum(String title, String author, String description, String paintType){
        Painting newPainting = new Painting(title,author,description,paintType);
        museum.add(newPainting);
    } 
}
