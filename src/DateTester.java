
public class DateTester {
	public static void main(String[] args) {
		Date today = new Date(2020,4,20);
		System.out.println(today);
		Date then = new Date(2021,5,1);
		
		today.addDays(5);
		today.addWeeks(2);
		System.out.println(today);
		System.out.println(then);
		System.out.println(today.daysTo(then));
		
		System.out.println(today.isLeapYear());
	}

}
