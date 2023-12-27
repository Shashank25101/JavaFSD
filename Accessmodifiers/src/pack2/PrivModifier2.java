package pack2;

import pack2.PrivModifier;

public class PrivModifier2 {

	public static void main(String args[])  
    {  
        PrivModifier obj = new PrivModifier();  
        // Trying to access private method of another class  
        obj.display3();  
    }  

}
// It shows compilation error : The method display3() from class PrivModifier is not visible as it is private

