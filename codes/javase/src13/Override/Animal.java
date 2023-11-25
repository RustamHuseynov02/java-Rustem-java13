package Override;

public abstract class Animal implements Swimmer,Runner {
	
      String name;
    
      
      @Override
    public void swim() {
    	
    	
    }
      
      @Override
    public void run() {
    	// TODO Auto-generated method stub
    	
    }
      
      public Animal(String name) {
    	  this.name = name;
      }
      
      public abstract void speak();
}
