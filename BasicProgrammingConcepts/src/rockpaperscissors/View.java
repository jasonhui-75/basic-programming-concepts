package rockpaperscissors;

import java.util.Scanner;

public class View {
	public static void start()
	{
		while(true)
		{
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			RockPaperScissors.reset();
			System.out.println("How many rounds do you want to play?\n(rounds must be in the range of 1-10)");
			RockPaperScissors game = null;
		    int input = Integer.parseInt(myObj.nextLine());  // Read user input
		    try {
		    	 game = RockPaperScissors.getInstance(input);
		    }
		    catch(RoundsOutOfBoundException e)
		    {
		    	while(input < 1 || input > 10)
		    	{
			    	System.out.println("Please input an integer in the range of 1-10");
			    	input = myObj.nextInt();
		    	}
		    	game = RockPaperScissors.getInstance(input);
		    }
		    System.out.println("Game instance is created\n"
		    					+ "User must either enter a number from 1-3 or a string.\n"
		    					+ "1 = ROCK\t2 = PAPER\t3 = SCISSORS");
		    while(game.getCurrentRound() <= game.getRounds())
		    {
		    	
		    	System.out.println("What symbol do you want to use?");
		    	Symbol uSymbol = null;
		    	String uString = myObj.nextLine();

	    		System.out.println("you entered "+uString);
		    	try{
		    		//System.out.println("before toSymbol in try");
		    		uSymbol = RockPaperScissors.toSymbol(uString);
		    	}catch(IncorrectUserInputException e) {
		    		while(!RockPaperScissors.isValidSymbol(uString)) {
		    			System.out.println("Please input a valid symbol");
		    			uString = myObj.nextLine();
		    		}
		    		System.out.println("before toSymbol in catch");
		    		uSymbol = RockPaperScissors.toSymbol(uString);
		    	}
				System.out.println(game.userInput(uSymbol));
		    }
		    System.out.println("Do you want to play again?");
		    String response = myObj.next();
		    while(!response.equalsIgnoreCase("no") &&!response.equalsIgnoreCase("yes"))
		    {
			    System.out.println("Please enter yes or no");
			    response = myObj.next();
		    }
		    if(response.equalsIgnoreCase("no"))
		    {
		    	break;
		    }
		    else
		    {
		    	System.out.println("Game is restarting");
		    }
		}
	}
}
