package oophomework;

public class Person {
      int id;
      String name;
      String surName;
      int age;
      int phone;
      String address;
      
      
      
      public void printInfo(int id,String name,String surname,int age,int phone,String address) {
    	  System.out.println("id : " + id);
    	  System.out.println("name : " + name);
    	  System.out.println("surName : " + surname);
    	  System.out.println("age : " + age);
    	  System.out.println("phone : " + phone);
    	  System.out.println("address : " + address);
      }
      
}
