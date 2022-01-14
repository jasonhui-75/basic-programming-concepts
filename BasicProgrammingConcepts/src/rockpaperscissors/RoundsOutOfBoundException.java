package rockpaperscissors;

public class RoundsOutOfBoundException extends RuntimeException {
	public RoundsOutOfBoundException(String m)
	{
		super(m);
	}
	public RoundsOutOfBoundException()
	{
		super("Rounds must be in the range of 1 - 10");
	}
	
}
