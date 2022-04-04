public class Funda{
    public static void main(String[] arg){
        System.out.println("Hello World");

        System.out.println("X is eual to 5");
        // addValues();

        int[] myArray = {4,5,6,7,8};
        String[] fruits = {"banans", "Strawberries","Watermelon","Grapes"};

        for(int i = 0; i < fruits.length ; i++){
            System.out.println(fruits[i]);
        }

        for(int num : myArray){
            System.out.println(num);
        }

        // System.out.println(fruits[0]);
    }
    public void addValues(){
        System.out.println("Hello World");
    }
}