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

        if (mode == "hard"){
          statement = in.nextLine();
          if (statement.length() < 7){
            lives--;
            System.out.println("not long enough...\n\t" + lives + " lives left...");
            playHard();
          } else {
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
          }
          playHard();

        } else {
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
        }

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

//hard mode
  public void playHard(){
    statement = in.nextLine();
    if (lives < 1){
      System.out.println("welp, sorry friend, you have no more lives left...\n\tguess i won!");
    } else if (statement == "none"){
        System.out.println("no words left? time to read a dictionary i guess...\nguess i won ehe");
      } else if (statement.substring(1,1) != botWord.substring(botWord.length()-1)){
        lives--;
        System.out.println("hmm, your word doesn't start with the last letter of mine...\n\t" + lives + " lives left");
      } else if (statement.length() < 7){
        lives--;
        System.out.println("not long enough...\n\t" + lives + "lives left...");
        playHard();
      } else {
        for(int i = 0; i < used.size(); i++){
          if (statement == used.get(i)){
            lives--;
            System.out.println("that's been used! " + lives + " lives left...");
            playHard();
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
                  playHard();
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

      dictionary.get(6).add("gorilla");
      dictionary.get(6).add("grow");
      dictionary.get(6).add("giant");
      dictionary.get(6).add("gas");
      dictionary.get(6).add("giggle");

      dictionary.get(7).add("horse");
      dictionary.get(7).add("haunt");
      dictionary.get(7).add("hiccup");
      dictionary.get(7).add("hotel");
      dictionary.get(7).add("happy");

      dictionary.get(8).add("igloo");
      dictionary.get(8).add("ink");
      dictionary.get(8).add("imp");
      dictionary.get(8).add("ill");
      dictionary.get(8).add("indigo");

      dictionary.get(9).add("joke");
      dictionary.get(9).add("jingle");
      dictionary.get(9).add("jig");
      dictionary.get(9).add("journey");
      dictionary.get(9).add("jam");

      dictionary.get(10).add("kangaroo");
      dictionary.get(10).add("kin");
      dictionary.get(10).add("know");
      dictionary.get(10).add("knock");
      dictionary.get(10).add("kelp");

      dictionary.get(11).add("lips");
      dictionary.get(11).add("long");
      dictionary.get(11).add("lion");
      dictionary.get(11).add("lurch");
      dictionary.get(11).add("linger");

      dictionary.get(12).add("monkey");
      dictionary.get(12).add("mat");
      dictionary.get(12).add("mine");
      dictionary.get(12).add("miff");
      dictionary.get(12).add("mitten");

      dictionary.get(13).add("nail");
      dictionary.get(13).add("nap");
      dictionary.get(13).add("nothing");
      dictionary.get(13).add("nick");
      dictionary.get(13).add("now");

      dictionary.get(14).add("organ");
      dictionary.get(14).add("orange");
      dictionary.get(14).add("oats");
      dictionary.get(14).add("oak");
      dictionary.get(14).add("ogre");

      dictionary.get(15).add("penny");
      dictionary.get(15).add("pun");
      dictionary.get(15).add("poll");
      dictionary.get(15).add("prim");
      dictionary.get(15).add("poor");

      dictionary.get(16).add("queen");
      dictionary.get(16).add("quack");
      dictionary.get(16).add("quip");
      dictionary.get(16).add("quite");
      dictionary.get(16).add("quill");

      dictionary.get(17).add("raisin");
      dictionary.get(17).add("rail");
      dictionary.get(17).add("rat");
      dictionary.get(17).add("rip");
      dictionary.get(17).add("rob");

      dictionary.get(18).add("swoon");
      dictionary.get(18).add("slip");
      dictionary.get(18).add("sway");
      dictionary.get(18).add("swift");
      dictionary.get(18).add("slick");

      dictionary.get(19).add("tire");
      dictionary.get(19).add("turn");
      dictionary.get(19).add("thwack");
      dictionary.get(19).add("twist");
      dictionary.get(19).add("temper");

      dictionary.get(20).add("usher");
      dictionary.get(20).add("umbrella");
      dictionary.get(20).add("up");
      dictionary.get(20).add("ultra");
      dictionary.get(20).add("utter");

      dictionary.get(21).add("velcro");
      dictionary.get(21).add("vole");
      dictionary.get(21).add("vain");
      dictionary.get(21).add("vinyl");
      dictionary.get(21).add("violet");

      dictionary.get(22).add("wrist");
      dictionary.get(22).add("water");
      dictionary.get(22).add("wagon");
      dictionary.get(22).add("window");
      dictionary.get(22).add("wring");

      dictionary.get(23).add("xerox");
      dictionary.get(23).add("xenon");
      dictionary.get(23).add("xylol");
      dictionary.get(23).add("xerus");

      dictionary.get(24).add("yellow");
      dictionary.get(24).add("yarn");
      dictionary.get(24).add("yip");
      dictionary.get(24).add("yeast");
      dictionary.get(24).add("yoke");

      dictionary.get(25).add("zebra");
      dictionary.get(25).add("zealous");
      dictionary.get(25).add("zoo");
      dictionary.get(25).add("zipper");
      dictionary.get(25).add("zone");

    }
    else if (mode == "places"){

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

      dictionary.get(13).add("norway");
      dictionary.get(13).add("new york");
      dictionary.get(13).add("niger");
      dictionary.get(13).add("new zealand");
      dictionary.get(13).add("nicaragua");

      dictionary.get(14).add("ottawa");
      dictionary.get(14).add("oregon");
      dictionary.get(14).add("ohio");
      dictionary.get(14).add("oslo");
      dictionary.get(14).add("oakland");

      dictionary.get(15).add("princeton");
      dictionary.get(15).add("portland");
      dictionary.get(15).add("panama");
      dictionary.get(15).add("peru");
      dictionary.get(15).add("pakistan");

      dictionary.get(16).add("quebec");
      dictionary.get(16).add("queens");
      dictionary.get(16).add("qatar");
      dictionary.get(16).add("qingdao");
      dictionary.get(16).add("quezon city");

      dictionary.get(17).add("romania");
      dictionary.get(17).add("rwanda");
      dictionary.get(17).add("russia");
      dictionary.get(17).add("rochester");
      dictionary.get(17).add("richmond");

      dictionary.get(18).add("spain");
      dictionary.get(18).add("sri lanka");
      dictionary.get(18).add("south africa");
      dictionary.get(18).add("syria");
      dictionary.get(18).add("serbia");

      dictionary.get(19).add("trinidad and tobago");
      dictionary.get(19).add("thailand");
      dictionary.get(19).add("texas");
      dictionary.get(19).add("tajikistan");
      dictionary.get(19).add("tanzania");

      dictionary.get(20).add("ugana");
      dictionary.get(20).add("uruguay");
      dictionary.get(20).add("ukraine");
      dictionary.get(20).add("united arab emirates");
      dictionary.get(20).add("uzbekistan");

      dictionary.get(21).add("venezuela");
      dictionary.get(21).add("vermont");
      dictionary.get(21).add("venice");
      dictionary.get(21).add("vietnam");
      dictionary.get(21).add("vancouver");

      dictionary.get(22).add("washington");
      dictionary.get(22).add("williamsburg");
      dictionary.get(22).add("wuhan");
      dictionary.get(22).add("warsaw");
      dictionary.get(22).add("wichita");

      dictionary.get(23).add("xi'an"); //idk anything else
      dictionary.get(23).add("xalapa");

      dictionary.get(24).add("yellowstone");
      dictionary.get(24).add("york");
      dictionary.get(24).add("yugoslavia");
      dictionary.get(24).add("yemen");
      dictionary.get(24).add("yokohama");

      dictionary.get(25).add("zanzibar");
      dictionary.get(25).add("zimbabwe");
      dictionary.get(25).add("zambia");

    } else if (mode == "hard"){

      dictionary.get(0).add("anteater");
      dictionary.get(0).add("assuage");
      dictionary.get(0).add("appropriate");
      dictionary.get(0).add("affluent");
      dictionary.get(0).add("acceleration");

      dictionary.get(1).add("bereave");
      dictionary.get(1).add("blasphemy");
      dictionary.get(1).add("blessing");
      dictionary.get(1).add("barnacle");
      dictionary.get(1).add("bashful");

      dictionary.get(2).add("caffeine");
      dictionary.get(2).add("capricious");
      dictionary.get(2).add("charisma");
      dictionary.get(2).add("cumbersome");
      dictionary.get(2).add("clandestine");

      dictionary.get(3).add("disgusting");
      dictionary.get(3).add("dismorphia");
      dictionary.get(3).add("dominatrix");
      dictionary.get(3).add("deprivation");
      dictionary.get(3).add("disproportional");

      dictionary.get(4).add("edifice");
      dictionary.get(4).add("exacerbate");
      dictionary.get(4).add("ethereal");
      dictionary.get(4).add("envelope");
      dictionary.get(4).add("endorphin");

      dictionary.get(5).add("fantasy");
      dictionary.get(5).add("frolick");
      dictionary.get(5).add("ferocious");
      dictionary.get(5).add("feminine");
      dictionary.get(5).add("frantic");

      dictionary.get(6).add("grateful");
      dictionary.get(6).add("gastrology");
      dictionary.get(6).add("gorgeous");
      dictionary.get(6).add("graphite");
      dictionary.get(6).add("garbage");

      dictionary.get(7).add("holistic");
      dictionary.get(7).add("heathen");
      dictionary.get(7).add("historical");
      dictionary.get(7).add("haphazardous");
      dictionary.get(7).add("hysteria");

      dictionary.get(8).add("incredible");
      dictionary.get(8).add("improbable");
      dictionary.get(8).add("illness");
      dictionary.get(8).add("intrepid");
      dictionary.get(8).add("ingenuine");

      dictionary.get(9).add("juxtapose");
      dictionary.get(9).add("jaggary");
      dictionary.get(9).add("jacquard");
      dictionary.get(9).add("jadedly");
      dictionary.get(9).add("jellyfish");

      dictionary.get(10).add("kayaking");
      dictionary.get(10).add("knowledge");
      dictionary.get(10).add("kangaroo");
      dictionary.get(10).add("kerchief");
      dictionary.get(10).add("kidnapper");

      dictionary.get(11).add("luminescence");
      dictionary.get(11).add("literally");
      dictionary.get(11).add("ladybug");
      dictionary.get(11).add("liability");
      dictionary.get(11).add("lacquer");

      dictionary.get(12).add("minstrel");
      dictionary.get(12).add("miserable");
      dictionary.get(12).add("mythical");
      dictionary.get(12).add("macabre");
      dictionary.get(12).add("mystery");

      dictionary.get(13).add("necromancer");
      dictionary.get(13).add("narwhal");
      dictionary.get(13).add("nebulous");
      dictionary.get(13).add("neophyte");
      dictionary.get(13).add("nativism");

      dictionary.get(14).add("ostentious");
      dictionary.get(14).add("overzealous");
      dictionary.get(14).add("opulent");
      dictionary.get(14).add("ostracize");
      dictionary.get(14).add("ostrich");

      dictionary.get(15).add("petulent");
      dictionary.get(15).add("principal");
      dictionary.get(15).add("primary");
      dictionary.get(15).add("princess");
      dictionary.get(15).add("pendulum");

      dictionary.get(16).add("quintessential");
      dictionary.get(16).add("quartet");
      dictionary.get(16).add("quarrel");
      dictionary.get(16).add("queendom");
      dictionary.get(16).add("quadruple");

      dictionary.get(17).add("rhombus");
      dictionary.get(17).add("resplendent");
      dictionary.get(17).add("reputation");
      dictionary.get(17).add("rhinocerous");
      dictionary.get(17).add("rickety");

      dictionary.get(18).add("slippery");
      dictionary.get(18).add("slender");
      dictionary.get(18).add("squabble");
      dictionary.get(18).add("stereotype");
      dictionary.get(18).add("shimmery");

      dictionary.get(19).add("tranquil");
      dictionary.get(19).add("teasing");
      dictionary.get(19).add("tasteful");
      dictionary.get(19).add("trombone");
      dictionary.get(19).add("tomorrow");

      dictionary.get(20).add("ululation");
      dictionary.get(20).add("underhand");
      dictionary.get(20).add("upbringing");
      dictionary.get(20).add("unemploy");
      dictionary.get(20).add("untruth");

      dictionary.get(21).add("vindicate");
      dictionary.get(21).add("voluptous");
      dictionary.get(21).add("villain");
      dictionary.get(21).add("voracious");
      dictionary.get(21).add("vacancy");

      dictionary.get(22).add("wallowing");
      dictionary.get(22).add("wriggle");
      dictionary.get(22).add("wisteria");
      dictionary.get(22).add("waistband");
      dictionary.get(22).add("wheelbarrow");

      dictionary.get(23).add("xylophone");
      dictionary.get(23).add("xenograft");

      dictionary.get(24).add("yearbook");
      dictionary.get(24).add("yearning");
      dictionary.get(24).add("youngest");
      dictionary.get(24).add("yardstick");
      dictionary.get(24).add("yellowing");

      dictionary.get(25).add("zoologist");
      dictionary.get(25).add("zirconium");
      dictionary.get(25).add("zeppelin");
      dictionary.get(25).add("zeitgeist");
      dictionary.get(25).add("zombified");
    }


    }

    //---------------------------Keywords----------------------------
    private int findKeyword(String statement, String goal, int startPos) {
      String phrase = statement.trim().toLowerCase();
      goal = goal.toLowerCase();

      int psn = phrase.indexOf(goal, startPos);

      while (psn >= 0) {
        String before = " ", after = " ";
        if (psn > 0) {
          before = phrase.substring(psn - 1, psn);
        }
        if (psn + goal.length() < phrase.length()) {
          after = phrase.substring(
          psn + goal.length(),
          psn + goal.length() + 1);
        }

        if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) //before is not a letter
        && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))  {
          return psn;
        }
        psn = phrase.indexOf(goal, psn + 1);
      }
      return -1;
    }


    private int findKeyword(String statement, String goal) {
      return findKeyword(statement, goal, 0);
    }
}
