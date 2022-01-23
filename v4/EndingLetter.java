import java.util.Scanner;
import java.util.ArrayList;

public class EndingLetter extends Chatbot{

  Scanner in = new Scanner (System.in);

  String mode = "";
  private int lives = 2;
  String statement = "";
  String lastLtr = "";
  String botWord = "";

  ArrayList<ArrayList<String>> dictionary = new ArrayList<ArrayList<String>>();
  ArrayList used = new ArrayList<String>();
  public EndingLetter(){
    super();
    play = true;
  }

  public String play(){
    //instructions
    String m = "\nalright, we'll be playing the ending letter game!";
    String n = "\n\thow to play, you ask?";
    String o = "\n\t\t>say a word in the chosen category";
    String p = "\n\t\t>i will then say a word that starts with the last letter of your word";
    String q = "\n\t\t>you say a word that starts with the last letter of my word";
    String r = "\n\t\t>and we keep going until someone runs out of words!";
    String s = "\n\t\t>no repeats! all lowercase letters please! if you have no words, type 'none'!";
    String t = "\n\n\t>choose a category: 'simple'\t'places'\t'hard'";
    System.out.println(m + n + o + p + q + r + s + t);

    //choose mode
    statement = in.nextLine();
    System.out.println(chooseMode(statement));

    //create 26 arraylists in the dictionary, 1/letter
    for (int i = 0 ; i < 26 ; i++) {
      dictionary.add(new ArrayList<String>());
    }

    //fill dictionary based on mode
    fillDictionary(mode);

    System.out.println("\n-~-~-\ngo ahead!\n");

    statement = in.nextLine();
    used.add(statement);
    lastLtr = statement.substring(statement.length()-1);
    int a = whatLtr(lastLtr);

    botWord = dictionary.get(a).get(0);
      for(int j = 0; j < used.size(); j++){
        if (botWord == used.get(j)){
          dictionary.get(a).remove(0);
          botWord = dictionary.get(a).get(0);
        }
      }
        used.add(botWord);
        System.out.println(botWord);
        dictionary.get(a).remove(0);
        playing();

    return mode;
  }

  public void playing(){
    statement = in.nextLine();
    if (lives < 1){
      System.out.println("welp, sorry friend, you have no more lives left...\n\tguess i won!");
    } else if (statement == "none"){
        System.out.println("no words left? time to read a dictionary i guess...\nguess i won ehe");
      } else if (statement.substring(1,1) != botWord.substring(botWord.length()-1)){
        lives--;
        System.out.println("hmm, your word doesn't start with the last letter of mine...\n\t" + lives + " lives left");
      } else {
        for(int i = 0; i < used.size(); i++){
          if (statement == used.get(i)){
            lives--;
            System.out.println("that's been used! " + lives + " lives left...");
            playing();
          } else {
              used.add(statement);
              lastLtr = statement.substring(statement.length()-1);
              String botWord = "";
              int a = whatLtr(lastLtr);
              if(dictionary.get(a).size() < 1){
                System.out.println("aw wow i lost... and you won! well done!");
              } else {
                  botWord = dictionary.get(a).get(0);
                  for(int j = 0; j < used.size(); j++){
                    if (botWord == used.get(j)){
                      dictionary.get(a).remove(0);
                      botWord = dictionary.get(a).get(0);
                    }
                  }
                  used.add(botWord);
                  System.out.println(botWord);
                  dictionary.get(a).remove(0);
                  playing();
              }
          }
        }
      }

  }

  private int whatLtr(String lltr){
    int x;
    if (lltr == "a"){
      x = 0;
    } else if (lltr == "b"){
      x = 1;
    } else if (lltr == "c"){
      x = 2;
    } else if (lltr == "d"){
      x = 3;
    } else if (lltr == "e"){
      x = 4;
    } else if (lltr == "f"){
      x = 5;
    } else if (lltr == "g"){
      x = 6;
    } else if (lltr == "h"){
      x = 7;
    } else if (lltr == "i"){
      x = 8;
    } else if (lltr == "j"){
      x = 9;
    } else if (lltr == "k"){
      x = 10;
    } else if (lltr == "l"){
      x = 11;
    } else if (lltr == "m"){
      x = 12;
    } else if (lltr == "n"){
      x = 13;
    } else if (lltr == "o"){
      x = 14;
    } else if (lltr == "p"){
      x = 15;
    } else if (lltr == "q"){
      x = 16;
    } else if (lltr == "r"){
      x = 17;
    } else if (lltr == "s"){
      x = 18;
    } else if (lltr == "t"){
      x = 19;
    } else if (lltr == "u"){
      x = 20;
    } else if (lltr == "v"){
      x = 21;
    } else if (lltr == "w"){
      x = 22;
    } else if (lltr == "x"){
      x = 23;
    } else if (lltr == "y"){
      x = 24;
    } else if (lltr == "z"){
      x = 25;
    } else {
      x = 0;
    }
    return x;
  }

  public String chooseMode(String statement){
    String response = "";
    if ((statement.trim()).length() == 0){
			response = "choose a mood tehe~";
		}
    else if (findKeyword(statement, "simple") >= 0){
      mode = "simple";
      response = "simple it is; you may use whatever words you'd like!";
    }
    else if (findKeyword(statement, "places") >= 0){
      mode = "places";
      response = "yesyes let's fill in our maps! cities, countries, states, continents, counties...";
    }
    else if (findKeyword(statement, "hard") >= 0){
      mode = "hard";
      response = "show me your inner genius! all words must be longer than six letters!";
    }
    else
    {
      System.out.println("hm? what mode did you say?");
    }
    return response;
  }

//the massive collection of words
  public void fillDictionary(String mode){

    //easy mode - fill ArrayLists with these
    if (mode == "simple"){
      dictionary.get(0).add("apple");
      dictionary.get(0).add("ant");
      dictionary.get(0).add("annoy");
      dictionary.get(0).add("almost");
      dictionary.get(0).add("app");

      dictionary.get(1).add("bunny");
      dictionary.get(1).add("boy");
      dictionary.get(1).add("ball");
      dictionary.get(1).add("bin");
      dictionary.get(1).add("board");

      dictionary.get(2).add("cat");
      dictionary.get(2).add("corn");
      dictionary.get(2).add("cap");
      dictionary.get(2).add("coat");
      dictionary.get(2).add("clap");

      dictionary.get(3).add("dog");
      dictionary.get(3).add("dime");
      dictionary.get(3).add("dizzy");
      dictionary.get(3).add("doll");
      dictionary.get(3).add("dart");

      dictionary.get(4).add("elephant");
      dictionary.get(4).add("eat");
      dictionary.get(4).add("envelope");
      dictionary.get(4).add("earn");
      dictionary.get(4).add("elevator");

      dictionary.get(5).add("fairy");
      dictionary.get(5).add("far");
      dictionary.get(5).add("frill");
      dictionary.get(5).add("fast");
      dictionary.get(5).add("fork");

    } else if (mode == "places"){

      dictionary.get(0).add("arkansas");
      dictionary.get(0).add("alabama");
      dictionary.get(0).add("arkansas");
      dictionary.get(0).add("algeria");
      dictionary.get(0).add("australia");

      dictionary.get(1).add("bohemia");
      dictionary.get(1).add("brooklyn");
      dictionary.get(1).add("botswana");
      dictionary.get(1).add("bombay");
      dictionary.get(1).add("beijing");

      dictionary.get(2).add("colombo");
      dictionary.get(2).add("china");
      dictionary.get(2).add("connecticut");
      dictionary.get(2).add("chile");
      dictionary.get(2).add("cambridge");

      dictionary.get(3).add("denmark");
      dictionary.get(3).add("denver");
      dictionary.get(3).add("delaware");
      dictionary.get(3).add("dubai");
      dictionary.get(3).add("dhaka");

      dictionary.get(4).add("elmhurst");
      dictionary.get(4).add("europe");
      dictionary.get(4).add("ethiopia");
      dictionary.get(4).add("egypt");
      dictionary.get(4).add("ecuador");

      dictionary.get(5).add("finland");
      dictionary.get(5).add("far rockaway");
      dictionary.get(5).add("florence");
      dictionary.get(5).add("france");
      dictionary.get(5).add("fiji");

      dictionary.get(6).add("germany");
      dictionary.get(6).add("goa");
      dictionary.get(6).add("ghana");
      dictionary.get(6).add("guatemala");
      dictionary.get(6).add("greece");

      dictionary.get(7).add("holland");
      dictionary.get(7).add("houston");
      dictionary.get(7).add("huntington");
      dictionary.get(7).add("haiti");
      dictionary.get(7).add("hungary");

      dictionary.get(8).add("italy");
      dictionary.get(8).add("india");
      dictionary.get(8).add("idaho");
      dictionary.get(8).add("iceland");
      dictionary.get(8).add("ireland");

      dictionary.get(9).add("jerusalem");
      dictionary.get(9).add("japan");
      dictionary.get(9).add("jamaica");
      dictionary.get(9).add("jordan");
      dictionary.get(9).add("jinzhou");

      dictionary.get(10).add("kazakhstan");
      dictionary.get(10).add("korea");
      dictionary.get(10).add("kuwait");
      dictionary.get(10).add("kyrgystan");
      dictionary.get(10).add("kenya");

      dictionary.get(11).add("lebanon");
      dictionary.get(11).add("lithuania");
      dictionary.get(11).add("libya");
      dictionary.get(11).add("liberia");
      dictionary.get(11).add("laos");

      dictionary.get(12).add("mexico");
      dictionary.get(12).add("morocco");
      dictionary.get(12).add("montreal");
      dictionary.get(12).add("mongolia");
      dictionary.get(12).add("montana");
/*
      N.add("norway");
      N.add("new york");
      N.add("niger");
      N.add("new zealand");
      N.add("nicaragua");

      O.add("ottawa");
      O.add("oregon");
      O.add("ohio");
      O.add("oslo");
      O.add("oakland");

      P.add("princeton");
      P.add("portland");
      P.add("panama");
      P.add("peru");
      P.add("pakistan");

      Q.add("quebec");
      Q.add("queens");
      Q.add("qatar");
      Q.add("qingdao");
      Q.add("quezon city");

      R.add("romania");
      R.add("rwanda");
      R.add("russia");
      R.add("rochester");
      R.add("richmond");

      S.add("spain");
      S.add("sri lanka");
      S.add("south africa");
      S.add("syria");
      S.add("serbia");

      T.add("trinidad and tobago");
      T.add("thailand");
      T.add("texas");
      T.add("tajikistan");
      T.add("tanzania");

      U.add("ugana");
      U.add("uruguay");
      U.add("ukraine");
      U.add("united arab emirates");
      U.add("uzbekistan");

      V.add("venezuela");
      V.add("vermont");
      V.add("venice");
      V.add("vietnam");
      V.add("vancouver");

      W.add("washington"); //not like anything starts w W anyway

      X.add("xi'an"); //idk anything else

      Y.add("yellowstone");
      Y.add("york");
      Y.add("yugoslavia");
      Y.add("yemen");
      Y.add("yokohama");

      Z.add("zanzibar");
      Z.add("zimbabwe");
      Z.add("zambia");*/

    } else if (mode == "hard"){
/*      A.add("anteater");
      A.add("assuage");
      A.add("appropriate");
      A.add("affluent");
      A.add("acceleration");

      B.add("bereave");
      B.add("blasphemy");
      B.add("blessing");
      B.add("barnacle");
      B.add("bashful");

      C.add("caffeine");
      C.add("capricious");
      C.add("charisma");
      C.add("cumbersome");
      C.add("clandestine");

      D.add("disgusting");
      D.add("dismorphia");
      D.add("dominatrix");
      D.add("deprivation");
      D.add("disproportional");

      E.add("edifice");
      E.add("exacerbate");
      E.add("ethereal");
      E.add("envelope");
      E.add("endorphin");

      F.add("fantasy");
      F.add("frolick");
      F.add("ferocious");
      F.add("feminine");
      F.add("frantic");

      G.add("grateful");
      G.add("gastrology");
      G.add("gorgeous");
      G.add("graphite");
      G.add("garbage");

      H.add("holistic");
      H.add("heathen");
      H.add("historical");
      H.add("haphazardous");
      H.add("hysteria");

      I.add("incredible");
      I.add("improbable");
      I.add("illness");
      I.add("intrepid");
      I.add("ingenuine");

      J.add("juxtapose");
      J.add("jaggary");
      J.add("jacquard");
      J.add("jadedly");
      J.add("jellyfish");

      K.add("kayaking");
      K.add("knowledge");
      K.add("kangaroo");
      K.add("kerchief");
      K.add("kidnapper");

      L.add("luminescence");
      L.add("literally");
      L.add("ladybug");
      L.add("liability");
      L.add("lacquer");

      M.add("minstrel");
      M.add("miserable");
      M.add("mythical");
      M.add("macabre");
      M.add("mystery");

      N.add("necromancer");
      N.add("narwhal");
      N.add("nebulous");
      N.add("neophyte");
      N.add("nativism");

      O.add("ostentious");
*/
    }

    /*
      A = {"apple", "ant", "annoy", "almost", "app"};
      B = {"bunny", "boy", "ball", "bin", "board"};
      C = {"cat", "corn", "cap", "coat", "clap"};
      D = {"dog", "dime", "dizzy", "doll", "dart"};
      E = {"elephant", "eat", "envelope", "earn", "elevator"};
      F = {"fairy", "far", "frill", "fast", "fork"};
      G = {"gorilla", "gourd", "grin", "greet", "grow"};
      H = {"happy", "horn", "hat", "hiccup", "hotel"};
      I = {"igloo", "ill", "ink", "indigo", "imp"};
      J = {"jump", "joke", "jog", "jam", "juggle"};
      K = {"kangaroo", "kite", "kin", "know", "knock"};
      L = {"lion", "little", "lie", "lips", "large"};
      M = {"monkey", "martian", "mat", "most", "mine"};
      N = {"nap", "nothing", "nail", "nick", "now"};
      O = {"orange", "open", "organ", "oak", "oats"};
      P = {"penny", "pun", "please", "purse", "prim"};
      Q = {"queen", "quiet", "quip", "quack", "quill"};
      R = {"raisin", "run", "rail", "rat", "rant"};
      S = {"slip", "snake", "sway", "swoon", "swift"};
      T = {"tire", "try", "thwack", "twist", "trip"};
      U = {"under", "up", "usher", "utter", "umbrella"};
      V = {"vinyl", "vain", "vole", "veer", "violet"};
      W = {"wrist", "wine", "writ", "waste", "water"};
      X = {"xerox", "xenon", "xray", "xylol", "xerus"};
      Y = {"yellow", "yarn", "yawn", "yeast", "yip"};
      Z = {"zebra", "zone", "zipper", "zealous", "zoo"};*/
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
