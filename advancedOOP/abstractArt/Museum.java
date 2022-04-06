public class Museum {
    public static void main(String[] args){
        // Painting
        Painting Paint = new Painting("Jackson Polluck","Painting 1","Why we every call this art I've not idea but who cares I'm making millions for it","oil on canvas");
        Painting Paint2 = new Painting("Jane Doe","Clock Towers","Beautiful depiction of a ballerina on water","Fresco");
        Painting Paint3 = new Painting("Ernest Hemmingway","Love and Ocean","Resplendent depiction of a couple on the beach experssing their unending vows to one another","Watercolor and Colored pencil");
            // testing methods
            System.out.println(Paint.getPainting() + ", " + Paint.getTitle() );
            System.out.println(Paint.getPainting() + ", " + Paint2.getPainting() + ", " + Paint3.getPainting());

        // Sculpture
        Sculpture Sculpt = new Sculpture("Mandel Guiver","Thinking man","Man Sitting and thinking","marble");
        Sculpture Sculpt2 = new Sculpture("Reaching for Apples", "Mary Luise", "Rendering of ayoung girll reaching for an apple that's just out of reach", "Metal wires");
            System.out.println(Sculpt.getMaterial());
            System.out.println(Sculpt2.getAuthor());
    }
}
