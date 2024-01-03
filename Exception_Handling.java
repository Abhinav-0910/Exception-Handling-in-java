import java.util.*;
class InvalidNumber extends Exception {
	public InvalidNumber(String message) {
		super(message);
	}
}
class MathFunctions {
	float getMean(int[] array) throws InvalidNumber {
		int sum=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] > 100)
				throw new InvalidNumber("Invalid Number found:" );
			else
				sum += array[i];
		}
		return (float)sum/array.length;
	}
	float divideNum(int a, int b) throws ArithmeticException {
		if (b==0){
			throw new ArithmeticException("Cannot divide by zero");
		}
	return a/(float)b;
	}
}
class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MathFunctions m = new MathFunctions();
		try {
			System.out.println("1. Mean of Given array");
			System.out.println("2. Division of two numbers\n");
			System.out.print("Select the option from above :");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter length of an array:");
					int arrayLength = sc.nextInt();
					int[] array = new int[arrayLength];
					System.out.println("Enter elements of the array from 0 to 100 :");
					for (int i = 0; i < arrayLength; i++)
					array[i] = sc.nextInt();
					System.out.println("Mean is: " + m.getMean(array));
					break;
				case 2:
					System.out.print("Enter first number:");
					int num1 = sc.nextInt();
					System.out.print("Enter second number:");
					int num2 = sc.nextInt();
					System.out.println("Division is: " + m.divideNum(num1, num2));
					break;
			}
		} 
		catch (InvalidNumber e) {
			System.out.println("Invalid Number Exception: " + e.getMessage());
		}
		catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}