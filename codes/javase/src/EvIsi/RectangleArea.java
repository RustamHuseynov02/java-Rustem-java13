package EvIsi;

public class RectangleArea {

	public static void main(String[] args) {
		double length = 10.0;
        double width = 5.0;
        double area = length * width;
        System.out.println("RectangleArea: " + area);
        
        //CubeVolume

        double edgeLength = 3.0;
        double volume = edgeLength * edgeLength * edgeLength;
        System.out.println("Cube Volume: " + volume);
        
        //FahrenheitToCelsius
        
        double fahrenheit = 68.0;
        double celsius = (fahrenheit - 32) * 5/9;
        //double celsius1 = (fahrenheit - 32) % 10 * 3 + 2 ;
        System.out.println("Fahrenheit To Celsius: " + celsius);
	}

}
