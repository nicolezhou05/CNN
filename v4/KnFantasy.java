import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class KnFantasy {

  Scanner in = new Scanner (System.in);
  String selection = "";

  //String arrays for different types of medias:
  String[] fantasyWebtoon = {"King's Maker", "Who Made Me a Princess", "Noblesse", "Black Haze", "Omniscient Reader’s Viewpoint", "Leveling Up With the Gods", "Ranker Who Lives A Second Time", "Solo Leveling"};

  public String fMedia() {
    String a = "which type of media would you like to consume?";
    String b = "\n\t- 'Books' \n\t\t>press 'books' to claim a random book~";
    String c = "\n\t- 'Movie' \n\t\t>press 'movie' to claim a random movie~";
    String d = "\n\t- 'Show' \n\t\t>press 'show' to claim a random show~";
    String e = "\n\t- 'Graphic novel/webtoon' \n\t\t>press 'webtoon' to claim a random graphic novel or webtoon~";
    String f = "\n\t- 'Animation/Cartoon' \n\t\t>press 'animation' to claim a random animation/cartoon~";
    String g = "\n\t- 'Games' \n\t\t>press 'game' to claim a random game~";
    String h = "\n\t- 'Podcast' \n\t>press 'pods' to claim a random podcast~";
    System.out.println( a + b + c + d + e + f + g + h);
    String statement = in.nextLine();
    return fantasySelection(statement);
  }

  public String fantasySelection(String statement) {
    String response = "";
    if ((statement.trim()).length() == 0){
      response = "which media fits your mood today?";
      statement = in.nextLine();
    }
    else if (findKeyword(statement, "books") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");
    }
    else if (findKeyword(statement, "movie") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");
    }
    else if (findKeyword(statement, "show") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");
    }
    else if (findKeyword(statement, "webtoon") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fWebtoonSelection());
      System.out.println("Enjoy your read!!");
    }
    else if (findKeyword(statement, "animation") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");
    }
    else if (findKeyword(statement, "game") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");

    }
    else if (findKeyword(statement, "pods") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any good podcasts, send them our way!!");
    }
    else
    {
      System.out.println("not a choice buddy.");
      statement = in.nextLine();
      fantasySelection(statement);
    }
    return response;
  }

//----------------Webtoon---------------------------
  public String fWebtoonSelection() {
      Random r = new Random();
      selection = fantasyWebtoon[r.nextInt(fantasyWebtoon.length)];
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
