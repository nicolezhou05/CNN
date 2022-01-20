import java.util.Scanner;
//import java.util.ArrayList;

public class Madlibs extends Chatbot{

  Scanner in = new Scanner (System.in);
  //String statement = in.nextLine();

  //ArrayList<String> collection;

  public Madlibs(){
    super();
    play = true;
  }

  public String play() {
    System.out.println("let's play some madlibs! \n\tsay a word in the provided category!\n");
    //statement = in.nextLine();
    return playLibs();
  }

  public String playLibs(){
    System.out.println("\n\t >tell me a month!");
    String a = in.nextLine();
    System.out.println("\n\t >tell me a name!");
    String b = in.nextLine();
    System.out.println("\n\t >tell me an organ!");
    String c = in.nextLine();
    System.out.println("\n\t >tell me a verb!");
    String d = in.nextLine();
    System.out.println("\n\t >tell me an animal!");
    String e = in.nextLine();
    System.out.println("\n\t >tell me an adjective!");
    String f = in.nextLine();
    System.out.println("\n\t >tell me an emotion!");
    String g = in.nextLine();

    String story = "\nIt was a sunny day in " + a +
    ", \nand " + b + " was looking for something to do. \nTheir " + c
     + " was positively ACHING, and they suspected that the only way to ease the discomfort was to " + d
     + ". \nThey came across a(n) " + e + " wading in the river, \nand picked it up, because it looked " + f
     + ". \nThe " + e + " made a face of " + g + ", and upon seeing this, " + b
     + " promptly threw it back in the water. \nAfter contemplating for a whole " + h
     + " seconds, \n" + b + " grabbed the " + e + " again and ate it, \nhoping it'd make their " + c
     + " feel better. \nIt didn't.\n";

     return story;
  }
}
