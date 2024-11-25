package com.state.bank.java8;

public class LambdaImpl {

	public static void main(String[] args) {
		LambdaInt lambdaInt = (a, b) -> a + b;
		LambdaInt multi = (s1, s2) -> s1 * s2;
		LambdaInt div = (s1, s2) -> s1 / s2;
		LambdaInt sub = (a, b) -> a - b;

		System.out.println(sub.doArithmaticOps(100, 10));
		System.out.println(div.doArithmaticOps(100, 10));
		System.out.println(multi.doArithmaticOps(100, 10));
		System.out.println(lambdaInt.doArithmaticOps(100, 10));
	}
}
