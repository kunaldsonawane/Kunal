import java.io.*;
import java.util.*;

class ReverseArraySpecial{
	static String swap(String str, int l, int r){
		char[] c = str.toCharArray();
		char temp = c[l];
		c[l] = c[r];
		c[r] = temp;
		str = String.valueOf(c);
		return str;
	}
	static boolean isalphabet(char c){
		
		if((c>='A' && c<='Z') || (c>='a' && c<='z')){
			return true;
		}
		return false;
	}
	static String reverse(String str){
		int l=0;
		int r = str.length()-1;
	
		while(l!=r){
			if(!isalphabet(str.charAt(l))){
				l++;
			}
			else if(!isalphabet(str.charAt(r))){
				r--;
			}
			else{
			
				str = swap(str,l,r);
				l++;
				r--;
			}
			
		}
		return str;
	
	}
	public static void main(String args[]){
		String str = "A$,b,c";
		String rev = reverse(str);
		System.out.println(rev);
	}

}
