import java.util.Scanner;

public class GameMenu extends Chatbot {

  Scanner in = new Scanner (System.in);

  public GameMenu(){
    super();
  }

  public String gameMenu(){
    String a = "\nok! here're some interesting games to behold.";
    String b = "\n\t- play 'guess a num'! \n\t\t>say 'num' to play~";
    String c = "\n\t- play the 'ending letter game'! \n\t\t>say 'letter' to play~";
    String d = "\n\t- create a madlib! \n\t\t>say 'madlibs' to make one~";
    String e = "\n\t- play 'hangman'! \n\t\t>say 'hangman'! to play~";
    System.out.println(a + b + c + d + e);
    String statement = in.nextLine();
    return game(statement);
  }

  public String game(String statement){
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "what game, friendo?";
      statement = in.nextLine();
    }
    else if (findKeyword(statement, "num") >= 0){
      System.out.println("\n-~-~-");
      GuessNum g = new GuessNum(1,100);
      g.playIter();
    }
    else if (findKeyword(statement, "letter") >= 0){
      System.out.println("\n-~-~-");
      EndingLetter libby = new EndingLetter();
      libby.play();
    }
    else if (findKeyword(statement, "madlibs") >= 0){
      System.out.println("\n-~-~-");
      Madlibs maddy = new Madlibs();
      System.out.println(maddy.play());
    }
    else if (findKeyword(statement, "hangman") >= 0){
      System.out.println("\n-~-~-");
      Hangman holden = new Hangman();
      holden.play();
    }
    else
    {
      System.out.println("not a choice buddy.");
      statement = in.nextLine();
    }
    return response;
  }

//---------------------------Keywords----------------------------
    private int findKeyword(String statement, String goal,
  			int startPos)
  	{
  		String phrase = statement.trim().toLowerCase();
  		goal = goal.toLowerCase();

  		int psn = phrase.indexOf(goal, startPos);

  		while (psn >= 0)
  		{

  			String before = " ", after = " ";
  			if (psn > 0)
  			{
  				before = phrase.substring(psn - 1, psn);
  			}
  			if (psn + goal.length() < phrase.length())
  			{
  				after = phrase.substring(
  						psn + goal.length(),
  						psn + goal.length() + 1);
  			}

  			if (((before.compareTo("a") < 0) || (before
  					.compareTo("z") > 0)) // before is not a
  											// letter
  					&& ((after.compareTo("a") < 0) || (after
  							.compareTo("z") > 0)))
  			{
  				return psn;
  			}

  			psn = phrase.indexOf(goal, psn + 1);

  		}

  		return -1;
  	}


  	private int findKeyword(String statement, String goal)
  	{
  		return findKeyword(statement, goal, 0);
  	}

}
