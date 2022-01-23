import java.util.Scanner;

public class JpFiles{

  Scanner in = new Scanner (System.in);

  public String jpGenres() {
    String a = "which genre might behoove you on this day?";
    String b = "\n\t- 'Fantasy' \n\t\t>say 'fantasy' for futher exploration";
    String c = "\n\t- 'Science Fiction' \n\t\t>say 'scifi' for futher exploration";
    String d = "\n\t- 'Historical Fiction' \n\t\t>say 'historical' for futher exploration";
    String e = "\n\t- 'Realistic Fiction' \n\t\t>say 'realistic' for futher exploration";
    String f = "\n\t- 'Horror/Thriller/Mystery' \n\t\t>say 'thrills' for futher exploration";
    String g = "\n\t- 'Self-help' \n\t\t>say 'help' for futher exploration";
    String h = "\n\t- Or, would you like to listen to new music today? \n\t> if so, say 'music'";
    System.out.println( a + b + c + d + e + f + g + h);
    String statement = in.nextLine();
    return genreJp(statement);
  }

  public String genreJp(String statement) {
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "which genre fits your mood today?";
      statement = in.nextLine();
    }
    else if (findKeyword(statement, "fantasy") >= 0){
      System.out.println("\n-~-~-");
      JpFantasy med0 = new JpFantasy();
      med0.fMedia();
    }
    else if (findKeyword(statement, "scifi") >= 0){
      System.out.println("\n-~-~-");
      JpScifi med1 = new JpScifi();
      med1.sMedia();
    }
    else if (findKeyword(statement, "historical") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good ones, send them our way!!");
    }
    else if (findKeyword(statement, "realistic") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good ones, send them our way!!");
    }
    else if (findKeyword(statement, "thrills") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good ones, send them our way!!");
    }
    else if (findKeyword(statement, "help") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good ones, send them our way!!");
    }
    else if (findKeyword(statement, "music") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good ones, send them our way!!");
    }
    else
    {
      System.out.println("not a choice buddy.");
    }
    return response;
  }

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
