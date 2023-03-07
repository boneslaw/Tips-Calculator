public class CafeMember
{
		//---------------------------------------------------------------
		//Sets up new barista with their name and hours
		//---------------------------------------------------------------

		public String name;
		public double hoursWorked;

		public CafeMember (String baristaName, double cafeHoursWorked)
		{
			name = baristaName;
			hoursWorked = cafeHoursWorked;
		}

		public String toString()
		{
			String result = "Name: " + name + "\n" ;
			result += "Hours Worked: " + hoursWorked;
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