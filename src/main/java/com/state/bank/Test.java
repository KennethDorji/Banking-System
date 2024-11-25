package com.state.bank;

public class Test {

	
	private static void generateArithmaticExeption(int a, int b) {
		try {
			int c = a/b;
			System.out.println("result ="+c);
		} catch (ArithmeticException e) {
			if (b==0) {
				int newInput = b+1;
				int c = a/newInput;
				System.out.println("we have received 0 input for second argument so to just avoid exception we have added 1 in the input ="+c);
			}
			
		} 
		System.out.println(executeMe());
	}
	
	public static void main(String[] args) {
		generateArithmaticExeption(100, 1);
	}
	
	public static String executeMe() {
		return "Thank you guys helped me to be executed successfully";
	}
}
