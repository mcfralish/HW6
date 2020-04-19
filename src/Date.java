
public class Date {
	
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void addDays(int days) {
		day += days;
		
		while (days > this.daysIn(month)) {
			days -= this.daysIn(month);
			month++;
		}
		
		if (month>12) {
			year += (month/12);
			month -= (12*(month/12));
			
		}
	}
	
	public void addWeeks(int weeks) {
		this.addDays(7*weeks);
	}
	
	public int daysTo(Date other) {
		int count = 0;
		
		int tempYear = other.getYear();
		int tempMonth = other.getMonth();
		int tempDay = other.getDay();
		
		if (tempYear<this.year){
			System.out.println("This date is in the past.");
			return count;
		}
		
		else if((tempYear==this.year)&&(tempMonth<this.month)) {
			System.out.println("This date is in the past.");
			return count;
		}
		
		else if((tempYear==this.year)&&(tempMonth==this.month)&&(tempDay<this.day)) {
			System.out.println("This date is in the past.");
			return count;
		}
		
		else if((tempYear==this.year)&&(tempMonth==this.month)&&(tempDay==this.day)) {
			System.out.println("That day is today.");
			return count;
		}
				
		while (tempYear > this.year){
			if ((tempYear - year) > 1) {
				if (sIsLeapYear(tempYear)) count += 366;
				else count += 365;
				tempYear--;
			}
			
			else {
				if (tempMonth > this.month) {
					if (sIsLeapYear(tempYear)) count += 366;
					else count += 365;
					tempYear--;
				}
				
				else {
					while(tempMonth>0) {
						if (tempDay>0) {
							count += tempDay;
							tempDay = 0;
							tempMonth--;
						}
						
						count += daysIn(tempMonth);
						tempMonth--;
					}
					
					
					tempYear--;
					tempMonth = 12;
					tempDay = 31;
				}
			}
		}
		
		while (tempMonth > this.month) {
			if (tempDay>0) {
				count += tempDay;
				tempDay = 0;
				tempMonth--;
			}
			
			count += daysIn(tempMonth);
			tempMonth--;
		}
		
		if ((other.getMonth()>this.month)||(other.getYear()>this.year)) {
			tempDay = daysIn(tempMonth);
			count += (tempDay-this.day);
		}
		
		else count += (other.getDay()-this.day);
		
		return count;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isLeapYear() {
		if ((year%4) != 0)return false;
		
		boolean temp = true;
		if ((year%100) == 0) temp = false;
		if ((year%400) == 0) temp = true;
		return temp;
	}
	
	public static boolean sIsLeapYear(int year) {
		if ((year%4) != 0)return false;
		
		boolean temp = true;
		if ((year%100) == 0) temp = false;
		if ((year%400) == 0) temp = true;
		return temp;
	}
	
	public String toString() {
		return ""+year+"/"+month+"/"+day;
	}
	
	private static int daysIn(int month) {
		if (month==2) {
			if (sIsLeapYear(month)) return 29;
			else return 28;
		}
		
		else if (month==4||month==6||month==9||month==11) return 30;
		else return 31;
	}
	
	

}
