import java.util.ArrayList;

public class TestListExceptions{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();

        myList.add("Lisa");
        myList.add(31);
        myList.add(300.50);
        myList.add("Youi're the best!");

        ListExceptions generator = new ListExceptions();

        generator.exceptionsLoop(myList);
    }
    
}