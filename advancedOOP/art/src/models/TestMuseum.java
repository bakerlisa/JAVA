package models;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMuseum {
	public static void main(String[] args) {
		
		Museum newMuseum = new Museum();
			newMuseum.addToMuseum("painting", "Jackson Polluck","Lines","Nobody knows why this guys is famous because","Paint");	
			newMuseum.addToMuseum("painting", "Jane Doe","Clock Towers","Beautiful depiction of a ballerina on water","Fresco");
			newMuseum.addToMuseum("painting", "Ernest Hemmingway","Love and Ocean","Resplendent depiction of a couple on the beach experssing their unending vows to one another","Watercolor and Colored pencil");
			newMuseum.addToMuseum("sculpture", "Mandel Guiver","Thinking man","Man Sitting and thinking","marble");
			newMuseum.addToMuseum("sculpture", "Reaching for Apples", "Mary Luise", "Rendering of ayoung girll reaching for an apple that's just out of reach", "Metal wires");
		
//		newMuseum.viewAllArt();
		newMuseum.viewRandomArt();
	}
}
