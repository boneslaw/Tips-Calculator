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
		System.out.println("Welcome to the Tuesday Tip Calculator");
		System.out.println("---------------------------------------------------\n");
		
		// Initializes tip calculations 
		Barista personnel = new Barista();
		personnel.payday();
	}
}