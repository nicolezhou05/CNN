import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class CnFantasy {

  Scanner in = new Scanner (System.in);
  String selection = "";

  //String arrays for different types of medias:
  String[] fantasyBooks = {"The Grandmaster of Demonic Cultivation by MXTX", "Heaven Official's Blessing by MXTX", "The Scum Villain's Self-Saving System by MXTX", "The Dumb Husky and His White Chat Shizun by Meatbun Doesn't Eat Meat"};
  String[] fantasyShows = {"The Long Ballad"};
  String[] fantasyWebtoon = {"Soul Land", "Cheating Men Must Die", "Heaven Official's Blessing", "The Long Ballad"};
  String[] fantasyAnimation = {"Link Click", "Heaven Official's Blessing", "Bai Yao Pu", "Nezha"};
  String[] fantasyGame = {"Genshin Impact"};
  String[] fantasyAD = {"The Grandmaster of Demonic Cultivation", "Tong Qian Kan Shi: Copper Coins"};

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
      System.out.println("Drumroll please... \nAnd your selection is: " + fBookSelection());
      System.out.println("Enjoy your read!!");
    }
    else if (findKeyword(statement, "movie") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Truth be told, we don't have any. If you know any, send them our way!!");
    }
    else if (findKeyword(statement, "show") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fShowSelection());
      System.out.println("Enjoy your watch!!");
    }
    else if (findKeyword(statement, "webtoon") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fWebtoonSelection());
      System.out.println("Enjoy your read!!");
    }
    else if (findKeyword(statement, "animation") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fAnimSelection());
      System.out.println("Enjoy your watch!!");
    }
    else if (findKeyword(statement, "game") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fGameSelection());
      System.out.println("Enjoy playing!!");
    }
    else if (findKeyword(statement, "pods") >= 0){
      System.out.println("\n-~-~-");
      System.out.println("Drumroll please... \nAnd your selection is: " + fADSelection());
      System.out.println("Enjoy listening!!");
    }
    else
    {
      System.out.println("not a choice buddy.");
      statement = in.nextLine();
      fantasySelection(statement);
    }
    return response;
  }

//--------------------Books-----------------------
  public String fBookSelection() {
    Random r = new Random();
    selection = fantasyBooks[r.nextInt(fantasyBooks.length)];
    return selection;
  }

//----------------Shows---------------------------
  public String fShowSelection() {
      Random r = new Random();
      selection = fantasyShows[r.nextInt(fantasyShows.length)];
      return selection;
    }

//----------------Webtoon---------------------------
  public String fWebtoonSelection() {
      Random r = new Random();
      selection = fantasyWebtoon[r.nextInt(fantasyWebtoon.length)];
      return selection;
    }

//----------------Webtoon---------------------------
  public String fAnimSelection() {
      Random r = new Random();
      selection = fantasyAnimation[r.nextInt(fantasyAnimation.length)];
      return selection;
    }

//----------------Webtoon---------------------------
  public String fGameSelection() {
      Random r = new Random();
      selection = fantasyGame[r.nextInt(fantasyGame.length)];
      return selection;
    }

//----------------Audio Dramas---------------------------
  public String fADSelection() {
      Random r = new Random();
      selection = fantasyAD[r.nextInt(fantasyAD.length)];
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
