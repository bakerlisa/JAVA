import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, lovely to see you %s. How are you?", "Lisa");
    }

    public String angryAlfred(String yelling){
        return yelling.toUpperCase();
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "Today is " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        int alexis = conversation.indexOf("Alexis"); 
        int alfred = conversation.indexOf("Alfred");

        if(alexis > -1){
            return "Oh sure ask her. I'm usre she can do it";
        }else if(alfred > -1) {
            return "Yes sir, right away sir";
        }else{
            return "I'm all over it! You should've come to me first";
        }

    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

