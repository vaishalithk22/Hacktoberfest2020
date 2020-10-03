import java.util.*;

public class OddEven{
	public static void main(String args[]) 
	{
		//check if a number is odd-even without using any mathematical operation

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		// apply left shift after applying right shift and if the numbers are same ,its an even number
		
		/*
		* if number = 5,the right shift of it will be 2 and left shift of 2 will be 4
		* if number = 6, right shift of it will be 3 and left shift of 3 will be 6 
		*/
		int newNumber = (number>>1)<<1;
		
		if(number == newNumber)
			System.out.println(number + " is an even number");
		else
			System.out.println(number + " is an odd number");
	}
}