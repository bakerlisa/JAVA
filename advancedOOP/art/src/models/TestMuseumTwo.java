package models;
//package models;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import java.lang.reflect.*;
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.lang.reflect.InvocationTargetException;
//import java.io.*;
//
//public class TestMuseum {
//
//
//		// TODO Auto-generated method stub
//		Painting Paint = new Painting("Jackson Polluck","Painting 1","Why we every call this art I've not idea but who cares I'm making millions for it","oil on canvas");
//		Painting Paint2 = new Painting("Jane Doe","Clock Towers","Beautiful depiction of a ballerina on water","Fresco");
//        Painting Paint3 = new Painting("Ernest Hemmingway","Love and Ocean","Resplendent depiction of a couple on the beach experssing their unending vows to one another","Watercolor and Colored pencil");
//        
//        // Sculpture
//        Sculpture Sculpt = new Sculpture("Mandel Guiver","Thinking man","Man Sitting and thinking","marble");
//        Sculpture Sculpt2 = new Sculpture("Reaching for Apples", "Mary Luise", "Rendering of ayoung girll reaching for an apple that's just out of reach", "Metal wires");
//        
//        ArrayList<Object> museum = new ArrayList<Object>();
//        	// Class reference (not the actual class)
//        	museum.add(Paint);
//        	museum.add(Paint2);
//        	museum.add(Paint3);
//        	
//        	museum.add(Sculpt);
//        	museum.add(Sculpt2);
//        	
////        	object str =  Sculpt.getClass().getSimpleName();
////			System.out.println("museum : " + Sculpt.getClass().getSimpleName());
//        	
//        	System.out.println();
//        		for(int m=0;m < museum.size(); m++){
//        			Method[] methods = museum.get(m).getClass().getMethods();
//        			Class<?> classObj = museum.get(m).getClass();
//        			
//        			for (Method method : methods) {
////        				if (method.getName().equals("getMaterial")) {
////        					try {
////        						Method getMaterial = classObj.getDeclaredMethod("getMaterial", null);
////        						try {
////        							try {
////        								getMaterial.invoke(Paint3, null);
////        								System.out.println(getMaterial.invoke(Paint3, null));
////        							} catch (IllegalAccessException e) {
////        								// TODO Auto-generated catch block
////        								e.printStackTrace();
////        							} catch (IllegalArgumentException e) {
////        								// TODO Auto-generated catch block
////        								e.printStackTrace();
////        							} 
////        						}
////        						catch (InvocationTargetException e){
////        							System.out.println(e.getCause());
////        						}
////        					} catch (NoSuchMethodException | SecurityException e) {
////        						// TODO Auto-generated catch block
////        						e.printStackTrace();
////        					}
////        				}
//        				
//        				if (method.getName().equals("getPaintType")) {
//        					try {
//        						Method getPaintType = classObj.getDeclaredMethod("getPaintType", null);
//        						try {
//        							try {
//        								getPaintType.invoke(Sculpt, null);
//        								System.out.println(getPaintType.invoke(Sculpt, null));
//        							} catch (IllegalAccessException e) {
//        								// TODO Auto-generated catch block
//        								e.printStackTrace();
//        							} catch (IllegalArgumentException e) {
//        								// TODO Auto-generated catch block
//        								e.printStackTrace();
//        							} 
//        						}
//        						catch (InvocationTargetException e){
//        							System.out.println(e.getCause());
//        						}
//        					} catch (NoSuchMethodException | SecurityException e) {
//        						// TODO Auto-generated catch block
//        						e.printStackTrace();
//        					}
//        				}
//        			}
//        		}
//        		System.out.println();
//        		for(int m=0;m < museum.size(); m++){
//        			Method[] methodMORE = museum.get(m).getClass().getMethods();
//        			
//        			 for (Method method : methodMORE) {
//        				  
//        	                String MethodName = method.getName();
//        	                System.out.println("Name of the method: "
//        	                                   + MethodName);
//        	            }
//        		}
//        		
//			
//	
//}
