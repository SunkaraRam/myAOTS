package com.aots.qa.tests;

import java.util.TreeMap;

public class HomePageTest {

	public static void main(String[] args) {
		
		System.out.println("This is Ram sunkara");
	
		IntegerSep(123456789);
		
		StringSep();
	
	}
	
	public static void IntegerSep(int num) {
		
		String str = Integer.toString(num);
		
		System.out.println(str);// It will print the string
		
		char[] ch = str.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			
			System.out.print(ch[i]+" ");
		}
	}
	
	public static void StringSep() {

		int count =1 ;
		String divf="manual test and automation test and webapp test";
		String[] words=divf.split(" ");
	
		TreeMap<String , Integer> map = new TreeMap<String, Integer>();
		
		for(int i=0;i<words.length;i++) {
			
			if (map.containsKey(words[i])) {
				
				count = map.get(words[i]);
				map.put(words[i], count+1);
			}
			else {
				map.put(words[i], count);
			}
			
		}
	System.out.println(map);
}

}