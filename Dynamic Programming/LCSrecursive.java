import java.util.*;
import java.io.*;
import java.math.*;
public class LCSrecursive{

	static int lcs(String first, String second, int m , int n){
	
	if(m==0 || n==0) // String is empty
		return 0;
	if(first.charAt(m-1)==second.charAt(n-1))
		return 1 + lcs(first,second, m-1, n-1);
	else
		return Math.max(lcs(first,second,m,n-1), lcs(first,second,m-1, n));
	}
	public static void main(String[] args){


		Scanner in = new Scanner(System.in);
		
		String first = in.nextLine();
		String second = in.nextLine();
		
		int length = lcs(first, second, first.length(),second.length());
		System.out.println(length);	
	
	
	}

}
