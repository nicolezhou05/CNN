import java.util.Scanner;

public class EngFiles{

  Scanner in = new Scanner (System.in);

  public String engGenres() {
    String a = "which genre might behoove you on this day?";
    String b = "\n\t- 'Fantasy' \n\t\t>press 'fantasy' to claim a random media~";
    String c = "\n\t- 'Science Fiction' \n\t\t>press 'scifi' to claim a random media~";
    String d = "\n\t- 'Historical Fiction' \n\t\t>press 'historical' to claim a random media~";
    String e = "\n\t- 'Realistic Fiction' \n\t\t>press 'realistic' to claim a random media~";
    String f = "\n\t- 'Horror/Thriller' \n\t\t>press 'thrills' to claim a random media~";
    String g = "\n\t- 'Self-help' \n\t\t>press 'help' to claim a random media~";
    System.out.println( a + b + c + d + e );
    String statement = in.nextLine();
    return genreEng(statement);
  }

  public String genreEng(String statement) {
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "which genre fits your mood today?";
      statement = in.nextLine();
    }
    else if (findKeyword(statement, "fantasy") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "scifi") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "historical") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "realistic") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "thrills") >= 0){
      System.out.println("\n-~-~-");
    }
    else if (findKeyword(statement, "help") >= 0){
      System.out.println("\n-~-~-");
    }
    else
    {
      System.out.println("not a choice buddy.");
    }
    return response;
  }

//---------------------Fantasy--------------------

//--------------------Keywords--------------------
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
