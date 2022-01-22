import java.util.Scanner;
import java.util.Random;

public class Hangman extends Chatbot{

  //instance variables
  private int lives = 8;
  private String word = "";
  private String unguessed[];
  private boolean correctGuess = false;
  private int blankCtr = 0;

  Scanner in = new Scanner (System.in);
  String statement = "";

  String[] dictionary = {"snake", "auspicious", "magnanimous", "computer", "science", "programming"};

  public void play(){

    System.out.println("\nok! we'll be playing hangman then!\n\t- i will choose a random word\n\t- you will guess it letter by letter!\n");
    System.out.println("...choosing\n\n...choosing\n\n...choosing\n\nchosen!\n");
    Random ran = new Random();
    word = dictionary[ran.nextInt(dictionary.length)];
    String[] unguessed = new String[word.length()];
    System.out.println("your word has " + word.length() + " letters");
    System.out.println("you have 8 lives. start guessing one letter at a time! please use lowercase!");
    for (int i = 0; i < word.length(); i += 1){
      unguessed[i] = "_";
    }
    blankCtr = word.length();
    System.out.println(unguessed);
    hangmanGame();
  }

  public void hangmanGame(){
    statement = in.nextLine();
    for (int i = 0; (i < word.length()) && (lives > 0); i += 1){
      if (statement.equals(word.substring(i,i))){
        correctGuess = true;
        unguessed[i] = word.substring(i,i);
        blankCtr--;
      }
    }
    if ((correctGuess == true) && (blankCtr > 0)){
      System.out.println("ding ding! you guessed correctly!");
      System.out.println("what you have now: " + unguessed);
      hangmanGame();
    }
    else if ((correctGuess == true) && (blankCtr == 0)){
      System.out.println("woohoo! you got the word!");
    }
    else if ((correctGuess == false) && (lives > 0)){
      lives -= 1;
      System.out.println("oops, you have " + lives + " lives left");
      hangmanGame();
    }
    if (lives < 1){
      System.out.println("K.O.");
      System.out.println("correct answer: " + word);
    }
    correctGuess = false;
  }
}
