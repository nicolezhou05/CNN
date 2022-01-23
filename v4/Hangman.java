import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Hangman extends Chatbot{

  //instance variables
  private int lives = 8;
  private String word = "";
  private String[] unguessed;
  private boolean correctGuess = false;
  private boolean alreadyGuessed = false;
  private int blankCtr = 0;

  Scanner in = new Scanner (System.in);
  String statement = "";

  String[] dictionary = {"snake", "auspicious", "magnanimous", "computer", "science", "programming"};

  public void play(){

    System.out.println("\nok! we'll be playing hangman then!\n\t- i will choose a random word\n\t- you will guess it letter by letter!\n");
    System.out.println("...choosing\n\n...choosing\n\n...choosing\n\nchosen!\n");
    Random ran = new Random();
    word = dictionary[ran.nextInt(dictionary.length)];
    unguessed = new String[word.length()];
    System.out.println("your word has " + word.length() + " letters");
    System.out.println("you have 8 lives. start guessing one letter at a time! please use lowercase!");
    for (int i = 0; i < word.length(); i += 1){
      unguessed[i] = "_";
    }
    blankCtr = word.length();
    System.out.println(Arrays.toString(unguessed));
    System.out.println();
    hangmanGame();
  }

  public void hangmanGame(){
    statement = in.nextLine();
    for (int i = 0; (i < word.length()) && (lives > 0); i += 1){
      if (statement.equals(word.substring(i,i + 1)) && unguessed[i].equals("_")){
        correctGuess = true;
        unguessed[i] = word.substring(i,i + 1);
        blankCtr--;
      }
      else if (statement.equals(word.substring(i, i + 1)) && (!unguessed[i].equals("_"))){
        alreadyGuessed = true;
      }
    }
    System.out.println();
    if ((correctGuess == true) && (blankCtr > 0)){
      System.out.println("ding ding! you guessed correctly!");
      System.out.println("what you have now: " + Arrays.toString(unguessed));
      correctGuess = false;
      hangmanGame();
    }
    else if ((correctGuess == true) && (blankCtr == 0)){
      System.out.println("woohoo! you got the word! the word was: " + word);
    }
    else if (alreadyGuessed == true){
      System.out.println("hmmm...it seems that you have already guessed this...");
      alreadyGuessed = false;
      hangmanGame();
    }
    else if ((correctGuess == false) && (lives > 0)){
      lives -= 1;
      System.out.println("oops, you have " + lives + " lives left");
      if (lives == 0){
        System.out.println("K.O.");
        System.out.println("correct answer: " + word);
      }
      else{
        correctGuess = false;
        hangmanGame();
      }
    }
  }
}
