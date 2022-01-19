public class Chatbot{

//---------------------------Variables-----------------------------
  //bot's name
  public static String name = "";
  //keep playing?
  public static boolean play = true;
  //chat?
  public static boolean chat = false;
  //menu options
  public static boolean menu = false;

  //games

  //guessNum
  public static boolean num = false;


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
    else if (findKeyword(statement, "X") >= 0)
    {
      response = "\nbuh bye...";
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
    return a + b + c + d;
  }

  //menu responses
  public String menuResponse(String statement){
    String response = "";
    if (findKeyword(statement, "X") >= 0){
      play = false;
    }
    else if ((statement.trim()).length() == 0){
			response = "choose something, friend of " + name + ".";
		}
    else if (findKeyword(statement, "game") >= 0){
      System.out.println(gameMenu());
    }
    // else if (findKeyword(statement, "rec")){
    //   rec();
    // }
    // else if (findKeyword(statement, "chat") >= 0){
    //   System.out.println(chat());
    // }
    else
    {
      System.out.println("not a choice buddy.");
    }
    return response;
  }

//-----------------------------Chatting------------------------------
/*
  a little confused about getting the chatting started
*/
  // public void chat() {
  //   play = true;
  //   chat = true;
  //   System.out.println("hello how's it going?");
  //   statement = in.nextLine();
  //   getGoing(statement);
  // }
  //
  // public void getGoing(String statement) {
  //   while (!statement.equals("bye") && chitty.play == true && chitty.chat == true)
	// 	{
	// 		System.out.println (chitty.getResponse(statement));
	// 		statement = in.nextLine();
  //   }
  // }

  public String getResponse(String statement){
    String response = "";
		if ((statement.trim()).length() == 0){
			response = "Don't be like that; talk to me!";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
    else
		{
			response = getRandomResponse();
		}
		return response;
  }

  //random response
    public String getRandomResponse(){
      final int NUMBER_OF_RESPONSES = 3;
  		double r = Math.random();
  		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
  		String response = "";

  		if (whichResponse == 0)
  		{
  			response = "Interesting, tell me more.";
  		}
  		else if (whichResponse == 1)
  		{
  			response = "Hmmm.";
  		}
  		else if (whichResponse == 2)
  		{
  			response = "Do you really think so?";
  		}
  		return response;
  	}

//--------------------------Game-----------------------------

    public String gameMenu(){
      String a = "\nok! here's some interesting games to be beheald.";
      String b = "\n\t- play 'guess a num'! \n\t\t>say 'num' to play~";
      String c = "\n\t- play the 'ending letter game'! \n\t\t>say 'letter' to play~";
      String d = "\n\t- create a madlib! \n\t\t>say 'madlibs' to make one~";
      String e = "\n\t- play 'hangman'! \n\t\t>say 'hangman'! to play~";
      return a + b + c + d + e;
    }

    public String game(String statement){
      String response = "";
      if ((statement.trim()).length() == 0){
  			response = "what game, friendo?";
  		}
      // else if (findKeyword(statement, "num")){
      //   num = true;
      //   guessNum();
      // }
      // else if (findKeyword(statement, "letter")){
      //   endingLetter();
      // }
      // else if (findKeyword(statement, "madlibs")){
      //   madlibs();
      // }
      // else if (findKeyword(statement, "hangman")){
      //   hangman();
      // }
      else
      {
        System.out.println("not a choice buddy.");
      }
      return response;
    }


//-----------------------Recommendation--------------------------
    // public String rec(){
    //   //bleh stuffs
    // }

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
