package pass_by_reference2;

public class Scales {

	void calculate (Shop s) {
		s.price = 5 * s.weight;
		s.vegatablesPrice = 3 * s.weight;
		
		
		
	}
	void calculate2 (Shop s2) {
		s2.price = 3 * s2.weight;
		s2.vegatablesPrice = 6 * s2.weight;
	}
}
