package EvIsi;

public class Computer {
     int id;
     String Brand;
     String Model;
     String Color;
     
     public Computer (int id,String Brand,String Model,String Color) {     //default
    	 this.id = id;
    	 this.Brand = Brand;
    	 this.Model = Model;
    	 this.Color = Color;
    	 
    	 
     }
     public Computer (String Model) {          //model qebul eden
    	 
    	 this.Model = Model;
    	 
    	 
    	 
     }
     
     public Computer (String Model,String Color) {      // model && color qebul eden
    	 
    	 this.Model = Model;
    	 this.Color = Color;
    	 
    	 
    	 
     }
     
   
     
}
