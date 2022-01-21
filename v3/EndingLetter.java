import java.util.Scanner;
import java.util.ArrayList;

public class EndingLetter extends Chatbot{

  Scanner in = new Scanner (System.in);

  String mode = "";
  private int lives = 2;
  String statement = "";
  String lastLtr = "";

  //one per letter of the alphabet
  /*ArrayList A = new ArrayList<String>();
  ArrayList B = new ArrayList<String>();
  ArrayList C = new ArrayList<String>();
  ArrayList D = new ArrayList<String>();
  ArrayList E = new ArrayList<String>();
  ArrayList F = new ArrayList<String>();
  ArrayList G = new ArrayList<String>();
  ArrayList H = new ArrayList<String>();
  ArrayList I = new ArrayList<String>();
  ArrayList J = new ArrayList<String>();
  ArrayList K = new ArrayList<String>();
  ArrayList L = new ArrayList<String>();
  ArrayList M = new ArrayList<String>();
  ArrayList N = new ArrayList<String>();
  ArrayList O = new ArrayList<String>();
  ArrayList P = new ArrayList<String>();
  ArrayList Q = new ArrayList<String>();
  ArrayList R = new ArrayList<String>();
  ArrayList S = new ArrayList<String>();
  ArrayList T = new ArrayList<String>();
  ArrayList U = new ArrayList<String>();
  ArrayList V = new ArrayList<String>();
  ArrayList W = new ArrayList<String>();
  ArrayList X = new ArrayList<String>();
  ArrayList Y = new ArrayList<String>();
  ArrayList<String> Z = new ArrayList<>();*/

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

    //used words
    //ArrayList used = new ArrayList<String>();

    playing();

    return mode;
  }

  public void playing(){
    statement = in.nextLine();
    if (lives < 1){
      System.out.println("welp, sorry friend, you have no more lives left...\n\tguess i won!");
    } else{
        for(int i = 0; i < used.size(); i++){
          if (statement == used.get(i)){
            lives--;
            System.out.println("that's been used! " + lives + " left...");
            playing();
          } else{
              used.add(statement);
              lastLtr = statement.substring(statement.length()-1);
          }
        }
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
      /*A.add("apple");
      A.add("ant");
      A.add("annoy");
      A.add("almost");
      A.add("app");

      B.add("bunny");
      B.add("boy");
      B.add("ball");
      B.add("bin");
      B.add("board");

      C.add("cat");
      C.add("corn");
      C.add("cap");
      C.add("coat");
      C.add("clap");

      D.add("dog");
      D.add("dime");
      D.add("dizzy");
      D.add("doll");
      D.add("dart");

      E.add("elephant");
      E.add("eat");
      E.add("envelope");
      E.add("earn");
      E.add("elevator");

      F.add("fairy");
      F.add("far");
      F.add("frill");
      F.add("fast");
      F.add("fork");*/

    } else if (mode == "places"){

/*      A.add("arkansas");
      A.add("alabama");
      A.add("arkansas");
      A.add("algeria");
      A.add("australia");

      B.add("bohemia");
      B.add("brooklyn");
      B.add("botswana");
      B.add("bombay");
      B.add("beijing");

      C.add("colombo");
      C.add("china");
      C.add("connecticut");
      C.add("chile");
      C.add("cambridge");

      D.add("denmark");
      D.add("denver");
      D.add("delaware");
      D.add("dubai");
      D.add("dhaka");

      E.add("elmhurst");
      E.add("europe");
      E.add("ethiopia");
      E.add("egypt");
      E.add("ecuador");

      F.add("finland");
      F.add("far rockaway");
      F.add("florence");
      F.add("france");
      F.add("fiji");

      G.add("germany");
      G.add("goa");
      G.add("ghana");
      G.add("guatemala");
      G.add("greece");

      H.add("holland");
      H.add("houston");
      H.add("huntington");
      H.add("haiti");
      H.add("hungary");

      I.add("italy");
      I.add("india");
      I.add("idaho");
      I.add("iceland");
      I.add("ireland");

      J.add("jerusalem");
      J.add("japan");
      J.add("jamaica");
      J.add("jordan");
      J.add("jinzhou");

      K.add("kazakhstan");
      K.add("korea");
      K.add("kuwait");
      K.add("kyrgystan");
      K.add("kenya");

      L.add("lebanon");
      L.add("lithuania");
      L.add("libya");
      L.add("liberia");
      L.add("laos");

      M.add("mexico");
      M.add("morocco");
      M.add("montreal");
      M.add("mongolia");
      M.add("montana");

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
