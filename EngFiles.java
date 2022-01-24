import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class EngFiles{

  Scanner in = new Scanner (System.in);
  String selection = "";
  String[] music = {"Alec Benjamin", "The Neighborhood", "Twenty One Pilots", "Conan Gray"};


  public String engGenres() {
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
      Fantasy med0 = new Fantasy();
      med0.fMedia();
    }
    else if (findKeyword(statement, "scifi") >= 0){
      System.out.println("\n-~-~-");
      Scifi med1 = new Scifi();
      med1.sMedia();
    }
    else if (findKeyword(statement, "historical") >= 0){
      System.out.println("\n-~-~-");
      Historical med2 = new Historical();
      med2.hMedia();
    }
    else if (findKeyword(statement, "realistic") >= 0){
      System.out.println("\n-~-~-");
      Realistic med3 = new Realistic();
      med3.rMedia();
    }
    else if (findKeyword(statement, "thrills") >= 0){
      System.out.println("\n-~-~-");
      Thriller med4 = new Thriller();
      med4.tMedia();
    }
    else if (findKeyword(statement, "help") >= 0){
      System.out.println("\n-~-~-");
      Selfhelp med5 = new Selfhelp();
      med5.sMedia();
    }
    else if (findKeyword(statement, "music") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + musicGeneration());
      System.out.println("Enjoy!!");
    }
    else
    {
      System.out.println("not a choice buddy.");
    }
    return response;
  }

//--------------------Music----------------------
public String musicGeneration() {
  Random r = new Random();
  selection = music[r.nextInt(music.length)];
  return selection;
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
