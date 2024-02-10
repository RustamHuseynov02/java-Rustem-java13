package overrideng;

public class Employee extends Person{
       public double salary;
       
       @Override
    public void name() {
    	super.name();
    	
    	System.out.println("salary: " + salary);
    }
}
