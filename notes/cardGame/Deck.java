import java.util.ArrayList;

public class Deck{
        String[] cardSuit = {"hearts","spade","diamond","club"};
        Integer[] cardNumber = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        ArrayList<Object> deck = new ArrayList<Object>();

        public ArrayList<Object> createDeck(){

            for(int i=0;i<cardSuit.length;i++){
                for(int j=0;j<cardNumber.length;j++){
                    Card card = new Card(cardSuit[i],cardNumber[j]);
                        deck.add(card);
                        // System.out.println(card.getSuit() + " " + card.getNumber() );     
                }
            }
            // System.out.println("Deck: " + deck.get(1));
            return deck;
        }

        public void showDeck(){
            System.out.println(deck.get(0).getClass().getDeclaredMethods());
            
            

            for(int i=0; i<deck.size();i++){
                // System.out.println(deck.get(i));
                // System.out.println(deck.get(i));
                // for(int j=0;j < deck.get(i).length;j++){
                //     System.out.println(name);
                // }
                // System.out.println(deck.get(i).getSuit());
                
                // deck.forEach(card -> {
                //     System.out.println(card.getClass());
                // });

            }
        }
}