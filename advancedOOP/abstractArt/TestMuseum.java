import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestMuseum {
    public static void main(String[] args){
        ArrayList<Object> museum = new ArrayList<Object>();

        // Painting
        Painting Paint = new Painting("Jackson Polluck","Painting 1","Why we every call this art I've not idea but who cares I'm making millions for it","oil on canvas");
            
        Painting Paint2 = new Painting("Jane Doe","Clock Towers","Beautiful depiction of a ballerina on water","Fresco");
        Painting Paint3 = new Painting("Ernest Hemmingway","Love and Ocean","Resplendent depiction of a couple on the beach experssing their unending vows to one another","Watercolor and Colored pencil");

        // Sculpture
        Sculpture Sculpt = new Sculpture("Mandel Guiver","Thinking man","Man Sitting and thinking","marble");
        Sculpture Sculpt2 = new Sculpture("Reaching for Apples", "Mary Luise", "Rendering of ayoung girll reaching for an apple that's just out of reach", "Metal wires");
            // System.out.println(Sculpt.getMaterial());
            // System.out.println(Sculpt2.getAuthor());

        // Museum
        museum.add(Paint);
        museum.add(Paint2);
        museum.add(Paint3);
        museum.add(Sculpt);
        museum.add(Sculpt2);

        
        for(int i=0;i<museum.get(0).getClass().getMethods().length;i++){
            System.out.println(museum.get(0).getClass().getMethods()[i]);
        }
    }
}
