package functionalInterface;

public class MyFunctionalInterfaceClass {

	// @FunctionalInterface annotation ensures that the compiler will flag an error 
	//  if the interface has more than one method signature.
	
	
	@FunctionalInterface
	public interface toIntWithSafety {
		/**
		 * Convert a string to an integer and handle exceptions
		 * @param num The string to be converted
		 * @return The converted string or zero if an exception is thrown during conversion
		 */
		Integer calculate(String num);
	}
	
	
}
