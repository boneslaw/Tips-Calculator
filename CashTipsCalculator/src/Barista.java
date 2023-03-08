import java.math.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Barista
{
	// Creates the array
	CafeMember[] baristaList;
	double finalResult;
	double amount;
	double tipPot = 0;
	double roundedTips = 0;
	double baristaHours = 0;
	double cafeHours = 0;
	int priority;
	int anotherValue;
	double roundedUp = 0;
	boolean roundingAuthorized = false;
	
	public Barista()
	{
		
		// Remember to update hours worked otherwise error will occur.
		baristaList = new CafeMember[30];

		baristaList[0] = new CafeMember ("Maycie", 'Z', 1);
		baristaList[1] = new CafeMember ("Meghan", 'B', 5);
		baristaList[2] = new CafeMember ("Nova", 'B', 9);
		baristaList[3] = new CafeMember ("Brock", 'B', 3);
		baristaList[4] = new CafeMember ("Erin", 'B', 1);

		// Error made here
		baristaList[5] = new CafeMember ("Brock", 'B', 1);
		baristaList[6] = new CafeMember ("Sydney", 'C', 1);
		baristaList[7] = new CafeMember ("Ashley", 'C', 1);
		baristaList[8] = new CafeMember ("Cat", 'C', 1);
		baristaList[9] = new CafeMember ("Abby", 'C', 1);
		baristaList[10] = new CafeMember ("Amy", 'D', 1);
		baristaList[11] = new CafeMember ("Victoria", 'F', 1);
		baristaList[12] = new CafeMember ("Morgan", 'G', 1);
		baristaList[13] = new CafeMember ("Emily", 'G', 1);
		baristaList[14] = new CafeMember ("Jory", 'H', 1);
		baristaList[15] = new CafeMember ("Emily", 'K', 1);
		baristaList[16] = new CafeMember ("Makenna", 'K', 1);
		baristaList[17] = new CafeMember ("Elijah", 'L', 1);
		baristaList[18] = new CafeMember ("Roni", 'M', 1);
		baristaList[19] = new CafeMember ("Angelique", 'O', 1);
		baristaList[20] = new CafeMember ("Hannah", 'P', 1);
		baristaList[21] = new CafeMember ("Bri", 'P', 1);
		baristaList[22] = new CafeMember ("Jade", 'R', 1);
		baristaList[23] = new CafeMember ("Jenna", 'R', 1);
		baristaList[24] = new CafeMember ("Mackenzie", 'S', 1);
		baristaList[25] = new CafeMember ("Alex", 'S', 1);
		baristaList[26] = new CafeMember ("Joey", 'S', 1);
		baristaList[27] = new CafeMember ("Austin", 'W', 1);
		baristaList[28] = new CafeMember ("Ronnie", 'W', 1);
		baristaList[29] = new CafeMember ("Tamarah", 'W', 1);
		
	}

	public static double withBigDecimal(double value, int places) 
	{
		BigDecimal bigDecimal = new BigDecimal(value);
		bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}

	
	//-----------------------------------------------------------------
	//Pays all baristas
	//-----------------------------------------------------------------
	
	public void printList()
	{
		for (int count=0; count < baristaList.length; count++)
		{

			System.out.println (baristaList[count]);
			amount = baristaList[count].pay(); 
			baristaHours = baristaList[count].verifyHours();
		}
	}
	
	

	public void payday () 
	{ 
		boolean validInput = false;
		while (!validInput)
		{
			try { 
				System.out.println("Enter the cash total: $");
				Scanner scan = new Scanner(System.in);
				double cashTotal = scan.nextDouble();
				
				if (cashTotal > 1000 || cashTotal < 30) {
					System.out.println("That doesn't seem right. Try entering another number?");
					cashTotal = scan.nextDouble();
				}
				
				System.out.println("\nEnter the cafe's total hours worked:");
				double hoursTotal = scan.nextDouble();
				if (hoursTotal > 1000 || hoursTotal < 30) {
					System.out.println("That doesn't seem right. Try entering another number?");
					hoursTotal = scan.nextDouble();
				}

				//-----------------------------------------------------------------
				// Calculates the tips per hour
				//-----------------------------------------------------------------
				
				double tipRate = cashTotal / hoursTotal;

				System.out.println("---------------------------------------------------\n");


				//-----------------------------------------------------------------
				//Calculates the tip amounts
				//-----------------------------------------------------------------
				

				for (int count=0; count < baristaList.length; count++)
				{
					
					System.out.println (baristaList[count]);
					amount = baristaList[count].pay(); 
					baristaHours = baristaList[count].verifyHours();
					finalResult = amount* tipRate;
					


					//-----------------------------------------------------------------
					// Sets up a case if the tips got rounded up. 
					//-----------------------------------------------------------------

					roundedUp = Math.round(finalResult);

					if (amount == 0.0)
						System.out.println ("No tips for this week.");
					else
						cafeHours += baristaHours;
					tipPot += finalResult;
					roundedTips += roundedUp;
					
					if (roundingAuthorized = true) {
						System.out.println ("Paid: $" +  withBigDecimal(roundedUp, 2));
						System.out.println ("Exact value: $" +  withBigDecimal(finalResult, 2));
					}
					else
					{
						System.out.println ("Paid: $" +  withBigDecimal(finalResult, 2));
					}
					
					System.out.println ("------------------------------------");
				}

				//-----------------------------------------------------------------
				// Adds all the tips together and verifies hours worked
				//-----------------------------------------------------------------


				if (cafeHours != hoursTotal) 
				{
					System.out.println("-----------------------------------------------------------------\n" + " ! WARNING: !\n" + "Hours do not match up.\n" + "Verify input.\n"); 
					System.out.println("You entered " + hoursTotal);
					System.out.println("However, " + cafeHours + " was calculated from the list.");
					System.out.println("-----------------------------------------------------------------/n");
					break;
				}
				else
				{
					System.out.print("Hour input of " + hoursTotal + " hours matches " + cafeHours + " of barista hours totaled. \n");
					System.out.println("\nThe tip rate is: $" + withBigDecimal(tipRate, 2) + " an hour.");
				}

				//-----------------------------------------------------------------
				// Compares all the tips issued to the original cash amount to verify the best rate.
				//-----------------------------------------------------------------

				if (roundedTips > cashTotal)
				{
					System.out.println("\nYou can not round up fairly this week.");
					System.out.println ("Total tips issued: $" + withBigDecimal(tipPot, 2));
					System.out.println("There will be $" + (roundedTips - cashTotal) + " left over.\n");
				}

				else if (roundedTips == cashTotal)
				{
					System.out.println("\nYou can not round up as the tips were distributed evenly.");
					System.out.println ("Total tips issued: $" + withBigDecimal(tipPot, 2) + "\n");
				}
				else
				{
					roundingAuthorized = true;
					System.out.println("\nYou CAN round up this week.");
					System.out.println("Total tips issued if rounded up: $" + withBigDecimal(roundedTips, 2) + " leaving $" + (cashTotal - roundedTips) + " to spare. \n");
					}
				}
			
			catch (InputMismatchException ex)
			{
				System.out.println("Please enter a number value.");
				System.out.println("Press enter to continue.");
				Scanner scan = new Scanner(System.in);
				scan.nextLine();
			}
		}
	}
}