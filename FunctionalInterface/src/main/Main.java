/* 
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * 
 * Herein we demonstrate three things:
 * 1. The built-in functional interface Function<Double, Double>
 * 2. A custom functional interface: MyFunctionalInterfaceClass.toIntWithSafety
 * 3. A Lambda Expression in the context of a new Thread
 * 
*/

package main;

import java.util.function.Function;

import functionalInterface.MyFunctionalInterfaceClass;

public class Main {
	public static void main(String[] args) {
		
//		1. The built-in functional interface Function<Double, Double>
//		The function accepts a Double (first parameter) and returns a Double (second parameter)
		Function<Double, Double> SQRT_RoundUp = x -> Math.ceil(Math.sqrt(x)); 
		
		double result = SQRT_RoundUp.apply(42.0); // apply() is the built-in method that invokes your Lambda function
		System.out.println(result);
		
		// Pass the function as an argument
		demo(SQRT_RoundUp, 7.0);
		
		
//		2. A custom functional interface: MyFunctionalInterfaceClass.toIntWithSafety
		
		// Create an instance of the functional interface 'MyFunctionalInterface'
		MyFunctionalInterfaceClass.toIntWithSafety f = (String x) -> {try {return Integer.valueOf(x);} catch (Exception ex) {return 0;}};
		int answer = f.calculate("123");
		System.out.println(answer);

		answer = f.calculate("abc");		// oopsy not an integer, but it will be handled gracefully by our Lambda function, above.
		System.out.println(answer);
		
//		3. A Lambda Expression in the context of a new Thread		
	    // Use a lambda expression to create a Thread object and pass a Runnable object to the Thread constructor, then call start() on the Thread object
	    new Thread(()-> {System.out.println("New thread created");}).start();

	}
	/***
	 * Perform a computation with a Function passed as an argument
	 * @param aFunction The function to use
	 */
	private static void demo(Function<Double, Double> aFunction, Double number) {
		System.out.println(aFunction.apply(number));
	}
	
	
}
