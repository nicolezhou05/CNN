import java.util.Scanner;

public class GameMenu extends Chatbot {

  Scanner in = new Scanner (System.in);
  String statement = in.nextLine();

  public GameMenu(){
    super();
  }

  public String gameMenu(){
    String a = "\nok! here's some interesting games to be beheald.";
    String b = "\n\t- play 'guess a num'! \n\t\t>say 'num' to play~";
    String c = "\n\t- play the 'ending letter game'! \n\t\t>say 'letter' to play~";
    String d = "\n\t- create a madlib! \n\t\t>say 'madlibs' to make one~";
    String e = "\n\t- play 'hangman'! \n\t\t>say 'hangman'! to play~";
    System.out.println(a + b + c + d + e);
    statement = in.nextLine();
    return game(statement);
  }

  public String game(String statement){
    String response = "";
    statement = in.nextLine();
    if ((statement.trim()).length() == 0){
      statement = in.nextLine();
      response = "what game, friendo?";
    }
    else if (findKeyword(statement, "num") >= 0){
      System.out.println("\n-~-~-");
      statement = in.nextLine();
      GuessNum g = new GuessNum(1,100);
      g.playIter();
    }
    else if (findKeyword(statement, "letter") >= 0){
      System.out.println("\n-~-~-");
      statement = in.nextLine();
      EndingLetter libby = new EndingLetter();
      libby.play();
    }
    else if (findKeyword(statement, "madlibs") >= 0){
      System.out.println("\n-~-~-");
      statement = in.nextLine();
      Madlibs maddy = new Madlibs();
      System.out.println(maddy.play());
    }
    // else if (findKeyword(statement, "hangman") >= 0){
    //   hangman();
    // }
    // else
    // {
    //   System.out.println("not a choice buddy.");
    // }
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
