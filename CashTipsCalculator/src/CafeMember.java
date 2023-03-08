public class CafeMember 
{
	//---------------------------------------------------------------
	//Sets up new barista with their name and hours
	//---------------------------------------------------------------

	public String name;
	public Character lastInitial;
	public double hoursWorked;

	public double getHoursWorked() {
		return hoursWorked;
	}


	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public void setLastInitial(Character lastInitial) {
		this.lastInitial = lastInitial;
	}


	public CafeMember (String baristaName, Character baristaInitial, double cafeHoursWorked)
	{
		name = baristaName;
		lastInitial = baristaInitial;
		hoursWorked = cafeHoursWorked;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getLastInitial() {
		return lastInitial;
	}

	public void setInitial(char lastInitial) {
		this.lastInitial = lastInitial;
	}
	
	public String toString()
	{
		String result =  name + " " + lastInitial + " " +hoursWorked;
		return result;
	}

	public double pay()
	{
		return hoursWorked;
	}

	public double verifyHours()
	{
		return hoursWorked;
	}


}
