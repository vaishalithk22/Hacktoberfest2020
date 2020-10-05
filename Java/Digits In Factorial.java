

import java.io.*;
import java.util.*;
class Mathematics {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		

		int T=sc.nextInt();
		
		while(T-->0)
		{
		    Factorial obj=new Factorial();
		    int N;
		    
		    //taking N
		    N=sc.nextInt();
		    
		   //calling method digitsInFactorial()
		   System.out.println(obj.digitsInFactorial(N));
		    
		}
		
	}
}




class Factorial
{
    
    public int digitsInFactorial(int N)
    {
        //Your code here
        double res=0;
        for(int i=2;i<=N;i++){
            res+=Math.log10(i);
        }
        
        
        
        int count=(int)(Math.floor(res)+1);
            
        
        return count;
    }

}
