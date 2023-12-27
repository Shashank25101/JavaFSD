package methods;

public class overload {
	public void area(int b,int h)
    {
         System.out.println("Area of Triangle : "+(0.5*b*h));
    }
    public void area(int r) 
    {
         System.out.println("Area of Circle : "+(3.14*r*r));
    }
//both methods are having same name 
    public static void main(String args[])
   {

overload obj=new overload();
       obj.area(10,12);
       obj.area(5);  
   }

}
