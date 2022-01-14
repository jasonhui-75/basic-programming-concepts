package healthyhearts;

import java.util.Scanner;

public class HealthyHearts {
	private int age;
	public HealthyHearts(int age)
	{
		this.age = age;
	}
	public String toString()
	{
		int max = 220-this.age;
		return String.format("Your maximum heart rate should be %d beats per minute\n"
							+ "Your target HR Zone is %d - %d beats per minute", max,(int) Math.round(.5*max), (int)Math.round(.85*max) );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("What is your age?");
		Scanner sc = new Scanner(System.in);
		Integer age = null;
		try{
			age = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {
			while(age == null) {
				System.out.println("Please provide an integer");
				age = Integer.parseInt(sc.nextLine());
			}
		}
		HealthyHearts hh = new HealthyHearts(age);
		System.out.println(hh);
	}

}
