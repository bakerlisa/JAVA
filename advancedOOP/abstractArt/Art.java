import java.util.ArrayList;

public abstract class Art{
    public String title;
    public String author;
    public String description;
    public ArrayList<Art> museum ;


    // CONSTRUCTORS
    public Art(){
        this.museum = new ArrayList<Art>();
    }

    // GETTERS
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getDescription(){
        return description;
    }
    // SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public abstract void viewArt();
    public abstract void addToMuseum();
}