import java.util.ArrayList;

public class TestMuseum {
    public static void main(String[] args){
        // Painting
        Painting Paint = new Painting("Jackson Polluck","Painting 1","Why we every call this art I've not idea but who cares I'm making millions for it","oil on canvas");
            
        Painting Paint2 = new Painting("Jane Doe","Clock Towers","Beautiful depiction of a ballerina on water","Fresco");
        Painting Paint3 = new Painting("Ernest Hemmingway","Love and Ocean","Resplendent depiction of a couple on the beach experssing their unending vows to one another","Watercolor and Colored pencil");

        // Sculpture
        Sculpture Sculpt = new Sculpture("Mandel Guiver","Thinking man","Man Sitting and thinking","marble");
        Sculpture Sculpt2 = new Sculpture("Reaching for Apples", "Mary Luise", "Rendering of ayoung girll reaching for an apple that's just out of reach", "Metal wires");

        // Museum
        ArrayList<Object> museum = new ArrayList<Object>();
            museum.add(Paint);
            Class c = museum.get(0).getClass();
            for (Field f : c.getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    System.out.println(f.getPainting());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }   
        System.out.println(museum.get(0).getClass());
    }
}
