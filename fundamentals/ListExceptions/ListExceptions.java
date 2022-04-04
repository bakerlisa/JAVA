import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.*;

public class ListExceptions {
    public void exceptionsLoop(ArrayList<Object> mylist){
        for(int i = 0; i < mylist.size(); i++) {
            try{
                Integer castedValue = (Integer) mylist.get(i);
                
            } catch(Exception e) {
                System.out.println(e);
                // System.out.println("Sorry no can do");
                // back-up plan here.
            }
        } 
    }
}
