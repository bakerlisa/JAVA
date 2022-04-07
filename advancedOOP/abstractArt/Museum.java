import java.util.ArrayList;

public class Museum {
        /// Evening wrap up - if we can't instainate through parent, then mayeb we do it by hand, or we set up a class that has that one method inside that we can extend to child classes?
        public ArrayList<Object> museum = new ArrayList<Object>();

        public Museum(){

        }


        // SETTERS
        public ArrayList<Object> getMuseum(Object newItem){
            this.museum.add(newItem);
        }

        // GETTERS
        // public void setMuseum(){
        //     return museum;
        // }

        // METHODS
        public void addMuseum(Object newItem){
            ArrayList<Object> museum = new ArrayList<Object>();
            museum.add(newItem);

        }
}
