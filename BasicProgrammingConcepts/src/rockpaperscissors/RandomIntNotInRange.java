package rockpaperscissors;

public class RandomIntNotInRange extends RuntimeException {
	public RandomIntNotInRange() {
		super("Random generated number is not int the range of 0-2");
	}
}
