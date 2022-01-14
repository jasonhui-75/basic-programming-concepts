package rockpaperscissors;

import java.util.Random;

public class RockPaperScissors {
	private static RockPaperScissors rps = null;
	private Integer win;
	private Integer loss;
	private Integer tie;
	private Integer rounds;
	private Integer currentRound;
	private RockPaperScissors(int rounds)
	{
		if(rounds >= 1 && rounds <= 10)
			this.rounds = rounds;
		else
			throw new RoundsOutOfBoundException();
		win = 0;
		loss = 0;
		tie = 0;
		currentRound = 1;
	}
	public static RockPaperScissors getInstance(int rounds)
    {
        if (rps == null)
        	rps  = new RockPaperScissors(rounds);
 
        return rps;
    }
	private Symbol randomSymbol() 
	{
		int rng = new Random().nextInt(3);
		//System.out.println("rng from randomSymbol(): "+ rng);
		switch(rng)
		{
			case 0:
			{
				return Symbol.ROCK;
			}
			case 1:
			{
				return Symbol.PAPER;
			}
			case 2:
			{
				return Symbol.SCISSORS;
			}
		}
		throw new RandomIntNotInRange();
	}
	public String userInput(Symbol s)
	{
		System.out.println("User chooses " + s);
		Symbol computer = randomSymbol();
		System.out.println("Computer chooses " + computer);
		String message = null;
		switch(s)
		{
			case ROCK:
			{
				switch(computer)
				{
					case ROCK:
					{
						++tie;
						message = "Tie";
						break;
					}
					case PAPER:
					{
						++loss;
						message = "Computer wins round :"+currentRound ;
						break;
					}
					case SCISSORS:
					{
						++win;
						message = "User wins round :"+currentRound ;
						break;
					}
				}
				break;
			}
			case PAPER:
			{
				switch(computer)
				{
					case ROCK:
					{
						++win;
						message = "User wins round :"+currentRound ;
						break;
					}
					case PAPER:
					{
						++tie;
						message = "Tie" ;
						break;
					}
					case SCISSORS:
					{
						++loss;
						message = "Computer wins round :"+currentRound ;
						break;
					}
				}
				break;
			}
			case SCISSORS:
			{
				switch(computer)
				{
					case ROCK:
					{
						++loss;
						message = "Computer wins round :"+currentRound ;
						break;
					}
					case PAPER:
					{
						++win;
						message = "User wins round :"+currentRound ;
						break;
					}
					case SCISSORS:
					{
						++tie;
						message = "Tie" ;
						break;
					}
				}
				break;
			}
		}//end of outer swtich
		if(currentRound >rounds)
		{
			String winner = null;
			winner = (win > loss)?"User":"Computer";
			return ((winner == null)? "DRAW":winner+"has won")+
					String.format("\n[Round %d/%d , win: %d, tie: %d, loss: %d]",currentRound, rounds, win, tie, loss);
		}
		return String.format("%s\n[Round %d/%d, win: %d, tie: %d, loss: %d]",message, currentRound++, rounds, win, tie, loss);  
	}
	static Symbol toSymbol(String s)
	{
		Integer input = null;
		try {
			input = Integer.parseInt(s);
			//System.out.println("user entered a number");
			switch(input) {
				case 1:
					return Symbol.ROCK;
				case 2:
					return Symbol.PAPER;
				case 3:
					return Symbol.SCISSORS;
				default:
					System.out.println("number not in range ");
					throw new IncorrectUserInputException("User input must be in the range of 1-3");
			}
		}catch(NumberFormatException e){
			//System.out.println("user did not enter a number");
			if(s.equalsIgnoreCase("rock"))
			{
				return Symbol.ROCK;
			}
			else if(s.equalsIgnoreCase("paper"))
			{
				return Symbol.PAPER;
			}
			else if(s.equalsIgnoreCase("scissors"))
			{
				return Symbol.SCISSORS;
			}
			else
				throw new IncorrectUserInputException("User's input does not match any valid symbol");
				
		}
	}
	static boolean isValidSymbol(String s)
	{
		Integer input = null;
		try {
			input = Integer.parseInt(s);
			return (input <1 || input >3)? false:true;
		}catch(NumberFormatException e){
			return (s.equalsIgnoreCase("rock") || 
				s.equalsIgnoreCase("paper") ||
				s.equalsIgnoreCase("scissors"))?true:false;
		}
	}
	
	static void reset() {
		rps = null;
	}
	public Integer getWin() {
		return win;
	}
	public Integer getLoss() {
		return loss;
	}
	public Integer getTie() {
		return tie;
	}
	public Integer getRounds() {
		return rounds;
	}
	public Integer getCurrentRound() {
		return currentRound;
	}
	
}
