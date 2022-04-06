public class Card{

    public String suit;
    public int number;

    // CONSTRUCTOR
    public Card(){
    }

    public Card(String suit, int number){
        this.suit = suit;
        this.number = number;
    }

    // GETTERS
    public String getSuit(){
        return this.suit;
    }
    public int getNumber(){
        return this.number;
    }
    public String getCard(){
        return "CArd is: ";
    }


    // SETTERS
    public void setSuit(String suit){
        this.suit = suit;
    }
    public void setNumber(int number){
        this.number = number;
    }

    // METHODS
    public void createCard(String suit, int number){
        this.suit = suit;
        this.number = number;
    }
}   
