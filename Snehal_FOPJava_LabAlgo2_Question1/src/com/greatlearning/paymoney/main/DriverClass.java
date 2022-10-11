package com.greatlearning.paymoney.main;

import java.util.InputMismatchException;
import java.util.Scanner;;

public class DriverClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the size of transaction array");
		try {
			int n = scanner.nextInt();
			int[] transArray = new int[n];
			System.out.println("Enter the values of array");
			for (int i = 0; i < n; i++) {
				transArray[i] = scanner.nextInt();
			}
			System.out.println("enter the total no of targets that needs to be achieved");
			int noOfTargets = scanner.nextInt();
			for (int i = 0; i < noOfTargets; i++) {
				System.out.println("enter the value of target");
				int targetValue = scanner.nextInt();
				int flag = 0;
				int sum = 0;
				// check if target met
				for (int j = 0; j < n; j++) {
					sum = sum + transArray[j];

					if (sum >= targetValue) {
						System.out.println("\tTarget achieved after " + (j + 1) + " transactions");
						flag = 1;
						break;
					}

				}
				if (flag == 0) {
					System.out.println("\tGiven target is not achieved");
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("Exception : Only Integers are allowed as Inputs");
			throw new InputMismatchException("Integers Expected check input. \n" + e);
		} finally {
			scanner.close();
		}
	}
}
