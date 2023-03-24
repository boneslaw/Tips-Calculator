import java.math.*;
import java.text.NumberFormat;
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


	public Barista()
	{

		// Remember to update hours worked otherwise error will occur.
		baristaList = new CafeMember[31];

		baristaList[0] = new CafeMember ("NAME", 'I', 0.0);


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
						cafeHours += baristaHours;
						tipPot += finalResult;
						roundedTips += roundedUp;
						
						
						if (withBigDecimal(finalResult, 2) < 1)
						{
							System.out.println ("Paid: $0.00 when rounded down.");
						}
						
						else
						{
							System.out.println ("Exact value: $" +  withBigDecimal(finalResult, 2));
						}
						System.out.println ("\n------------------------------------\n");
				}


				//-----------------------------------------------------------------
				// Adds all the tips together and verifies hours worked
				//-----------------------------------------------------------------


				if (Math.round(cafeHours) != Math.round(hoursTotal)) 
				{
					System.out.println("-----------------------------------------------------------------\n" + " ! WARNING: !\n" + "Hours do not match up.\n" + "Verify input.\n"); 
					System.out.println("You entered " + hoursTotal);
					System.out.println("However, " + Math.round(cafeHours) + " was calculated from the list.");
					System.out.println("-----------------------------------------------------------------/n");
					break;
				}
				else
				{
					System.out.print("\nHour input of " + Math.round(hoursTotal) + " hours matches " + Math.round(cafeHours) + " of barista hours totaled. \n");
					System.out.println("The tip rate is: $" + withBigDecimal(tipRate, 2) + " an hour.");
				}

				//-----------------------------------------------------------------
				// Compares all the tips issued to the original cash amount to verify the best rate.
				//-----------------------------------------------------------------

				if (roundedTips > cashTotal)
				{
					System.out.println("\nYou can not round up fairly this week.");
					System.out.println("\n$" + cashTotal + " tips entered.");
				}

				else if (roundedTips == cashTotal)
				{

					System.out.println("\nYou can not round up as the tips were distributed evenly.");
					System.out.println("\n$" + cashTotal + " tips entered.");
					System.out.println ("Total tips issued: $" + withBigDecimal(tipPot, 2) + "\n");
				}
				else
				{

					tipPot = 0;
					roundedTips = 0;
					baristaHours = 0;
					cafeHours = 0;
					roundedUp = 0;


					for (int count=0; count < baristaList.length; count++)
					{

						System.out.println (baristaList[count]);
						amount = baristaList[count].pay(); 
						baristaHours = baristaList[count].verifyHours();
						finalResult = amount* tipRate;
						roundedUp = Math.round(finalResult);

						cafeHours += baristaHours;
						tipPot += finalResult;
						roundedTips += roundedUp;
						System.out.println ("Paid (Rounded): $" +  withBigDecimal(roundedUp, 2));
						System.out.println ("\n------------------------------------\n");
					}

					System.out.println("\nYou CAN round up this week.");
					System.out.println("The tip rate is: $" + withBigDecimal(tipRate, 2) + " an hour.\n");
					System.out.print("Hour input of " + Math.round(hoursTotal) + " hours matches " + Math.round(cafeHours) + " of barista hours totaled.");
					System.out.println("\nTotal tips issued if rounded up: $" + withBigDecimal(roundedTips, 2) + " leaving $" + (cashTotal - roundedTips) + " to spare. \n");
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

