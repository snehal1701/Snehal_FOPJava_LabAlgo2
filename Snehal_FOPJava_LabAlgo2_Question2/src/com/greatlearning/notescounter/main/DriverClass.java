package com.greatlearning.notescounter.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.greatlearning.notescounter.exception.NegativeAmountException;
import com.greatlearning.notescounter.exception.NegativeDenominationException;
import com.greatlearning.notescounter.util.ArrayUtil;

public class DriverClass {
	private static int[] arrDenominations, counter;
	private static int numberOfDenominations, amountToPay;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");

		try {
			numberOfDenominations = scanner.nextInt();
			if (numberOfDenominations < 1) {
				throw new IllegalArgumentException(
						"Only positive Integers are allowed, Actual : " + numberOfDenominations);
			}
			arrDenominations = new int[numberOfDenominations];
			System.out.println("Enter the currency denominations value");
			for (int i = 0; i < numberOfDenominations; i++) {
				arrDenominations[i] = scanner.nextInt();
				if (arrDenominations[i] < 1) {
					throw new NegativeDenominationException(
							"Denomination value cannot be less than 1, Actual:" + arrDenominations[i]);
				}
			}

			ArrayUtil.mergeSort(arrDenominations);
			counter = new int[numberOfDenominations];

			System.out.println("Enter the amount you want to pay");
			amountToPay = scanner.nextInt();
			if (amountToPay < 0) {
				throw new NegativeAmountException("Payable Amount cannot be less than 0, Actual: " + amountToPay);
			}
		} catch (InputMismatchException e) {
			System.out.println("Only integers are allowed as Inputs");
			throw e;
		} catch (NegativeDenominationException e) {
			System.out.println("Denominations cannot be less than 1");
			throw e;
		} catch (NegativeAmountException e) {
			System.out.println("You cannot pay in Negative amount");
			throw e;
		} finally {
			scanner.close();
		}

		int remainingAmount = countNotes(arrDenominations, counter, 0, numberOfDenominations - 1, amountToPay);

		if (remainingAmount > 0) {
			System.out.println("Amount cannot be paid in give denominations!");
		} else {
			System.out.println("Your payment approach in order to give min no of notes will be");

			for (int i = 0; i <= numberOfDenominations - 1; i++) {
				if (counter[i] != 0) {
					System.out.println(
							arrDenominations[i] + " x " + counter[i] + " = " + arrDenominations[i] * counter[i]);
				}
			}

		}
	}

	public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay) {
		if (amountToPay == 0) {
			return 0;
		}
		if (amountToPay < arrDenominations[0]) {
			return amountToPay;
		}

		if (amountToPay >= arrDenominations[high]) {
			counter[high] = amountToPay / arrDenominations[high];
			amountToPay %= arrDenominations[high];
			return countNotes(arrDenominations, counter, 0, high, amountToPay);
		}
		int mid = (low + high) / 2;
		if (amountToPay < arrDenominations[mid]) {
			return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
		}
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}
}
