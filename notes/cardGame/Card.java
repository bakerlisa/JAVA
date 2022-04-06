public class Card{
    private String suit;
    private Integer number;
    private String color;

    // CONSTRUCTOR
    public Card(){

    }

    public Card(String color){
        this.color = color;
    }

    public Card(String color, String suit, Integer number){
        this.suit = suit;
        this.number = number;
        this.color = color;
    }

    // GETTERS
    public String getSuit(){
        return this.suit;
    }
    public Integer getNumber(){
        return this.number;
    }
    public String getCard(){
        return "CArd is: ";
    }


    // SETTERS
    public void setSuit(String suit){
        this.suit = suit;
    }
    public void setNumber(Integer number){
        this.number = number;
    }

  

    // METHODS
    
}   
