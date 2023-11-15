package MetodPractice2;

public class Example {
    void percent (int a) {
    	if (a < 0) {
    		System.out.println("0 boyukdur");
			return;
		}
    	
    	if (a > 100) {
    		System.out.println("a 100den boyukdur");
			return;
		}
    	else {
    		System.out.println("hec biri uygun deil");
    		
    	}
    	
    	System.out.println(a);
    	
    	
    }
    static {     // static - metodu cagirmadan sadece Example classinnan obyekt yaratdiqda ise dusur
		System.out.println("rustem");
	}
    
    {    //static olmayan kod bloku istediyimiz qeder istifade ede bilerik buda classdan obyekt yarannanda calisir
    	System.out.println("aaaaa");
    }
}
