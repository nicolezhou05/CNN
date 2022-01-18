public class Chatbot{

  public static String name = "";
  //say hello
  public String sayHello(){
    return "hey there! what's your friend's name?";
  }

  // public String startTalking(String statement){
  //   getName(statement);
  //   return "do you want to do something? yes or no?";
  //   //System.out.println(firstGetResponse(statement));
  // }

  public String getName(String statement){
    name = statement;
     String x = "what a coincidence! my name is " + name + " too; guess we're friends now!";
     String y = "\nDo you want to do something? yes or no?";
     return x + y;
  }

  public String menu(){
    return "ok! ";
  }

  public String firstGetResponse(String statement){
    String response = "";
    if ((statement.trim()).length() == 0){
			response = "aw say something, will you?";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "ok... bye then.";
      statement = "bye";
		}
    else if (findKeyword(statement, "yes") >= 0)
    {
      response = "ok!";
      menu();
    }
    else {
      response = "yes or no?";
    }
    return response;
  }

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

//keywords
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
}
