import java.util.ArrayList;

public class Deck{
        String[] cardSuit = {"hearts","spade","diamond","club"};
        Integer[] cardNumber = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        ArrayList<Object> deck = new ArrayList<Object>();

        public ArrayList<Object> createDeck(ArrayList<Object> deck{

            for(int i=0;i<cardSuit.length;i++){
                for(int j=0;j<cardNumber.length;j++){
                    Card newCard = new Card();
                        newCard.setSuit(cardSuit[i]);
                        newCard.setNumber(cardNumber[j]);
                        deck.add(newCard);   
                }
            }
            return deck;
        }

        public void showDeck(){
            for(int i=0; i<deck.size();i++){

                // System.out.println(deck.get(i));
                // System.out.println(deck.getSuit() + " " + deck.getNumber);
            }
        }
}