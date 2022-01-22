import java.util.Scanner;

public class Recbot extends Chatbot {

  Scanner in = new Scanner (System.in);

  public Recbot() {
    super();
  }

  public String languageSetting() {
    String a = "we have a selection of languages to select from. choose any (as most of the works have English translations.)";
    String b = "\n\t- 'English' \n\t\t>press 'eng' to browse~";
    String c = "\n\t- 'Chinese' \n\t\t>press 'cn' to browse~";
    String d = "\n\t- 'Korean' \n\t\t>say 'kn' to browse~";
    String e = "\n\t- 'Japanese' \n\t\t>say 'jp' to browse~";
    System.out.println( a + b + c + d + e );
    String statement = in.nextLine();
    return langChoose(statement);
  }

  public String langChoose(String statement) {
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "which language, friend? you are welcome to try any";
      statement = in.nextLine();
    }
    else if (findKeyword(statement, "eng") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "cn") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "kn") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "jp") >= 0){
      System.out.println("\n-~-~-");
    }
    else
    {
      System.out.println("not a choice buddy.");
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
