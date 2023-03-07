import java.math.*;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Barista 
{
	// Creates the array
	CafeMember[] baristaList;

	public Barista()
	{
		// Remember to update hours worked otherwise error will occur. 
		
		baristaList = new CafeMember[1];
        baristaList[0] = new CafeMember ("Default", 1.0);
        //Fill array with baristas.
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

	public void payday () 
	{
		boolean validInput = false;
		while (!validInput)
		{
			try { 
				System.out.println("Enter the cash total:");
				Scanner scan = new Scanner(System.in);

				double cashTotal = scan.nextDouble();
				System.out.println("\nEnter the cafe's total hours worked:");
				
				//-----------------------------------------------------------------
				// Calculates the tips per hour
				//-----------------------------------------------------------------
				double hoursTotal = scan.nextDouble();
				double tipRate = cashTotal / hoursTotal;

				System.out.println("---------------------------------------------------\n");

				double finalResult;
				double amount;
				double tipPot = 0;
				double roundedTips = 0;
				double baristaHours = 0;
				double cafeHours = 0;

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
					
					double roundedUp = 0;
					roundedUp = Math.round(finalResult);

					if (amount == 0.0)
						System.out.println ("No tips for this week.");
					else
						cafeHours += baristaHours;
						tipPot += finalResult;
					roundedTips += roundedUp;

					System.out.println ("Paid: $" +  withBigDecimal(finalResult, 2));
					System.out.println ("------------------------------------");
				}

				//-----------------------------------------------------------------
				// Adds all the tips together and verifies hours worked
				//-----------------------------------------------------------------
				
				System.out.println("\nThe tip rate is: $" + withBigDecimal(tipRate, 2) + " an hour.");
			
				if (cafeHours != hoursTotal) 
				{
					System.out.print("-----------------------------------------------------------------\n" + " ! WARNING: !\n" + "Hours do not match up.\n" + "Verify input.\n" + "-----------------------------------------------------------------/n");
					break;
				}
				else
				{
					System.out.print("Hour input of " + hoursTotal + " hours matches " + cafeHours + " of barista hours totaled. \n");
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
                else
                {
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
