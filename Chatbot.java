public class Chatbot {

//---------------------------Variables-----------------------------
  //bot's name
  public static String name = "";
  //keep playing?
  public static boolean play = true;
  //chat?
  public static boolean chat = false;
  //menu options
  public static boolean menu = false;

  //game menuResponse
  public static boolean gameResponse = false;


//-------------------------Initial Greeting-------------------------
  //say hello
  public String sayHello(){
    return "hey there! what's your friend's name?";
  }

  //bot's name is your friend's name
  public String getName(String statement){
    name = statement;
    String x = "\nwhat a coincidence! my name is " + name + " too... \n... \nguess we're friends now!";
    String y = "\n\ndo you want to do something? yes or no?";
    return x + y;
  }

  //do you want to start talking to the bot?
  public String firstGetResponse(String statement){
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "aw say something, will you?";
    }
    else if (findKeyword(statement, "no") >= 0)
    {
      response = "\nok... bye then.";
      play = false; //stop playing
    }
    else if (findKeyword(statement, "yes") >= 0)
    {
      menu = true;
      System.out.println(menu());
    }
    else {
      response = "yes or no?";
    }
    return response;
  }

//----------------------Menu Selection-------------------------------
  //menu options
  public String menu(){
    String a = "\nok! here's what i can do, as your trusted friend " + name + ".";
    String b = "\n\t- play a game! \n\t\t>say 'game' to play~";
    String c = "\n\t- give you a recommendation! \n\t\t>say 'rec' for my wise insight hehe";
    String d = "\n\t- chat with you and only you~ \n\t\t>say 'chat' to talk to me!";
    String e = "\n\t\t- \n\t\t- say 'bye' to leave :(";
    return a + b + c + d + e;
  }

  //menu responses
  public String menuResponse(String statement){
    String response = "";
    if ((statement.trim()).length() == 0){
			response = "choose something, friend of " + name + ".";
		}
    else if (findKeyword(statement, "game") >= 0){
      menu = false;
      gameResponse = true;
      GameMenu games = new GameMenu();
      return games.gameMenu();
    }
    else if (findKeyword(statement, "rec") >= 0){
      menu = false;
      System.out.println("-~-~-\n\nhello hello hello!");
      Recbot recs = new Recbot();
      System.out.println(recs.languageSetting());
    }
    else if (findKeyword(statement, "chat") >= 0){
      menu = false;
      System.out.println("\n-~-~-");
      Chat talker = new Chat();
      talker.chat();
    }
    else if (findKeyword(statement, "bye") >= 0){
      menu = false;
      System.out.println("\nbuh bye...");
    }
    else
    {
      System.out.println("not a choice buddy.");
    }
    return response;
  }

//-----------------------Chatting------------------------
    public String getResponse(String statement){
      String response = "";
      if ((statement.trim()).length() == 0){
        response = "don't be like that; talk to me!";
      }
      else if (findKeyword(statement, "no") >= 0)
      {
        response = "oh?";
      }
      else if (findKeyword(statement, "cat") >= 0 || findKeyword(statement, "dog") >= 0
      || findKeyword(statement, "rat") >= 0 || findKeyword(statement, "bird") >= 0
      || findKeyword(statement, "hamster") >= 0)
      {
        response = "tell me about your pets! i love animals hehe";
      }
      else if (findKeyword(statement, "red") >= 0 || findKeyword(statement, "orange") >= 0
      || findKeyword(statement, "yellow") >= 0 || findKeyword(statement, "green") >= 0
      || findKeyword(statement, "blue") >= 0 || findKeyword(statement, "indigo") >= 0
      || findKeyword(statement, "violet") >= 0 || findKeyword(statement, "pink") >= 0
      || findKeyword(statement, "black") >= 0 || findKeyword(statement, "white") >= 0
      || findKeyword(statement, "gray") >= 0 || findKeyword(statement, "beige") >= 0)
      {
        response = "whoa, that's my second favorite color! \n\tmy absolute favorite is cerulean though...\n\n\t\t...\n\tit reminds me of you, friend";
      }
      else if (findKeyword(statement, "friend") >= 0)
      {
        response = "hmm... tell me more about your other friend " + name;
      }
      else if (findKeyword(statement, "?") >= 0)
      {
        response = "not sure I know how to answer..."; //only works if '?' isn't attached to a word hm
      }
      else if (findKeyword(statement, "school") >= 0 || findKeyword(statement, "class") >= 0
      || findKeyword(statement, "work") >= 0)
      {
        response = "want to talk about something else?";
      }
      else if (findKeyword(statement, "I want to", 0) >= 0)
  		{
  			response = transformIWantToStatement(statement);
  		}

  		else if (findKeyword(statement, "I want", 0) >= 0)
  		{
  			response = transformIWantStatement(statement);
  		}
  		else
  		{
  			// Look for a two word (you <something> me)
  			// pattern
  			int psn = findKeyword(statement, "you", 0);
  			int psn1 = findKeyword(statement, "I", 0);

  			if (psn >= 0
  					&& findKeyword(statement, "me", psn) >= 0)
  			{
  				response = transformYouMeStatement(statement);
  			}

  			else if (psn1 >= 0
  					&& findKeyword(statement, "you", psn) >= 0)
  					{
  						response = transformIYouStatement(statement);
  					}
  			else
  			{
  				response = getRandomResponse(statement);
  			}
  		}
      return response;
    }

//specific responses from magpie
    private String transformIWantToStatement(String statement){
  		statement = statement.trim();
  		String lastChar = statement.substring(statement
  				.length() - 1);
  		if (lastChar.equals(".")){
  			statement = statement.substring(0, statement.length() - 1);
  		}
  		int psn = findKeyword (statement, "I want to", 0);
  		String restOfStatement = statement.substring(psn + 9).trim();
  		return "What would it mean to " + restOfStatement + "?";
  	}

  	private String transformIWantStatement(String statement){
  		statement = statement.trim();
  		String lastChar = statement.substring(statement.length() - 1);
  		if (lastChar.equals(".")){
  			statement = statement.substring(0, statement.length() - 1);
  		}
  		int psn = findKeyword (statement, "I want", 0);
  		String restOfStatement = statement.substring(psn + 7).trim();
  		return "um would " + restOfStatement + " really be better than a pat on the head from me?";
  	}

  	private String transformYouMeStatement(String statement){
  		statement = statement.trim();
  		String lastChar = statement.substring(statement.length() - 1);
  		if (lastChar.equals(".")){
  			statement = statement.substring(0, statement
  					.length() - 1);
  		}

  		int psnOfYou = findKeyword (statement, "you", 0);
  		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

  		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
  		return "pfft what makes you think that i " + restOfStatement + " you?";
  	}

  	private String transformIYouStatement(String statement) {
  		statement = statement.trim();
  		String lastChar = statement.substring(statement.length() - 1);
  		if (lastChar.equals(".")){
  			statement = statement.substring(0, statement
  					.length() - 1);
  		}

  		int psnOfYou = findKeyword (statement, "I", 0);
  		int psnOfMe = findKeyword (statement, "you", psnOfYou + 2);

  		String restOfStatement = statement.substring(psnOfYou + 2, psnOfMe).trim();
  		return "huh, why do you " + restOfStatement + " me?";
  	}


    //random response
    public String getRandomResponse(String statement){
      final int NUMBER_OF_RESPONSES = 6;
      double r = Math.random();
      int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
      String response = "";

      if (whichResponse == 0)
      {
        response = "fascinating, tell me more!";
      }
      else if (whichResponse == 1)
      {
        response = "hrm, that's...";
      }
      else if (whichResponse == 2)
      {
        response = "really?";
      }
      else if (whichResponse == 3)
      {
        response = statement + " you say...\n\n\t.....\n....\n\t\t...";
      }
      else if (whichResponse == 4)
      {
        response = "uh what-";
      }
      else if (whichResponse == 5)
      {
        response = "oh! i get it!";
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
