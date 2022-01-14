package summativesums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummativeSums {
	public static int sumArray(int[] array)
	{
		int sum = 0;
		for(int n: array)
		{
			sum+=n;
		}
		return sum;
	}
	public static void main(String[] args) {
		List<int[]> input = Arrays.asList(new int[] { 1, 90, -33, -55, 67, -16, 28, -55, 15 }, 
											new int[]{ 999, -60, -77, 14, 160, 301 }, 
											new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
													140, 150, 160, 170, 180, 190, 200, -99 } );
		for(int i = 1; i<= input.size();++i)
		{
			System.out.println("#"+i+" Array Sum: "+sumArray(input.get(i-1)));
		}
		
	}

}
