package pass_by_reference2;

public class MainClass {
     public static void main(String[] args) {
    	 Shop shop = new Shop("Alma","Xiyar",2.0);
    	 
    	 Shop shop2 = new Shop();
    	 shop2.fruit = "Armud";
    	 shop2.vegatables = "Pomidor";
    	 shop2.weight = 5.0;
    	 
    	 
    	 
    	 
    	 
		Scales scale = new Scales();
		scale.calculate(shop);
		scale.calculate2(shop2);
		
		
		System.out.println(shop.weight + " kq " + shop.fruit + " qiymeti : " + shop.price);
		System.out.println(shop.weight + " kq " + shop.vegatables + " qiymeti : " + shop.vegatablesPrice);
		
		
		System.out.println(shop2.weight + " kq " + shop2.fruit + " qiymeti : " + shop2.price);
		System.out.println(shop2.weight + " kq " + shop2.vegatables + " qiymeti : " + shop2.vegatablesPrice);
	}
}
