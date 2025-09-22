import java.util.*;
abstract class shape{
	abstract double calculateArea();
}
	class circle extends shape{
   		private double radius;
 	public circle(double radius){
    		this.radius=radius;
   }
	 double calculateArea(){
      		return Math.PI*Math.pow(radius,2);
      }
    }
 	 class rectangle extends shape{
    		private double length;
    		private double width;
 	public rectangle(double length,double width){
    		this.length=length;
    		this.width=width;
    }
 	double calculateArea(){
      		return length*width;
      }
   }
   	class triangle extends shape{
    		private double base;
    		private double heigth;
   	public triangle(double base,double heigth){
    		this.base=base;
    		this.heigth=heigth;
    }
   	double calculateArea(){
      	        return 0.5*base*heigth;
      }
   }
  public class Main{
      public static void main(String[] args){
           shape circle= new circle(5);
           shape rectangle = new rectangle(4,6);
           shape triangle = new triangle (3,7);
           System.out.println("circle area:"+circle.calculateArea());
           System.out.println("triangle area:"+triangle.calculateArea());
           System.out.println("rectangle area:"+rectangle.calculateArea());
      }
 }
