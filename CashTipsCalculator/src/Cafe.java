import java.util.InputMismatchException;
import java.util.Scanner;

public class Cafe 
{
	
	//-------------------------------------------------------------------------------
	//A small program used to divvy up cash tips by hours worked.
	//By totaling up at the end, it lets the user know if it's safe
	//to round up or if it'll go over the original total!
	// C.Brock
	//------------------------------------------------------------------------------

	public static void main (String[] args)
	{ 
		System.out.println("MMMMMMMMMMMMMXOXN0XWNK0WMMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMMXockocONOcdNMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMMWk;xO;dWXl:XMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMNxcodcokxlcOWMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMWx;kk;xKc.cXMMMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMO:dk:dKl.cKMMMMMMMMMMMMMMMMM\r\n"
				+ "MMMXOkkkkkkkxlcdl:ddc:lkkkkkkkOXMMMMMMMM\r\n"
				+ "MMWd...........................lklcccxXW\r\n"
				+ "MMWd.'lllllllllllllllllllllll' .'cdxl',O\r\n"
				+ "MMMx..clllllllllllllllllllllc. ,OWMMWx.;\r\n"
				+ "MMM0'.:lllllllllllllllllllll:..xWMMMMk.,\r\n"
				+ "MMMWl.'lllllllllllllllllllll' .xMMMMK:.d\r\n"
				+ "MMMMK;.,lllllllllllllllllll;...'dOko,'dN\r\n"
				+ "MMWWW0,.,clllllllllllllllc'.;O0o:;:cdKWM\r\n"
				+ "Nd;;;;'  .................  ';;;;oXMMMMM\r\n"
				+ "WO;  .,;;;;;;;;;;;;;;;;;;;;;,.  ;kWMMMMM\r\n"
				+ "MMNk:'..',,,,,,,,,,,,,,,,,'..':kNMMMMMMM\r\n"
				+ "MMMMWXOdocc:::::::::::::cloxOXWMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n");
		int option = 0;
		System.out.println("---------------------------------------------------");
		System.out.println("Welcome to the Tuesday Tip Calculator");
		System.out.println("---------------------------------------------------\n");

		// Initializes tip calculations 
		Barista personnel = new Barista();

		Scanner scan = new Scanner(System.in);
		System.out.println("Select 1 to Print List");
		System.out.println("Select 2 to Calculate Tip Rate");

		int choice = 0;
		boolean success = false;
		while (choice == 0) {

			try {
				option = scan.nextInt();
				switch (option) {
				case 1: 
					choice = 1;
					personnel.printList();
					success = true;
					break;

				case 2: 
					choice = 2;
					personnel.payday();
					success = true;
					break;

				default:
					choice = 3;
					System.out.println("\nInvalid choice. Press any button to continue\n");
					System.out.println("Select 1 to Print List");
					System.out.println("Select 2 to Calculate Tip Rate");
					choice = 0;
				}
			}

			catch (InputMismatchException ex) 
			{
				System.out.println("\nInvalid choice.\n");
				System.out.println("Select 1 to Print List");
				System.out.println("Select 2 to Calculate Tip Rate");
				scan.next();	
			}	
		}
	}
}