import java.util.Scanner;
import java.util.Random;

public class Hangman extends Chatbot{

  //instance variables
  private int lives = 10;
  private String word = "";
  private String unguessed = "";
  private boolean correctGuess = false;

  Scanner in = new Scanner (System.in);
  String statement = "";

  String[] dictionary = {"snake", "auspicious", "magnanimous", "computer", "science", "programming"}

  public void randomWord(){
    Random ran = new Random();
    word = dictionary[ran.nextInt(dictionary.length)];
    System.out.println("Your word has " + word.length() + " letters");
    System.out.println("You have 10 lives. Start guessing one letter at a time! Please use lowercase!");
    while (int i = 0; i < word.length(); i += 1){
      unguessed += "_";
    }
    System.out.println(unguessed);
  }

  public void hangmanGame(){
    statement = in.nextLine();
    while (int i = 0; (i < word.length()) && (lives > 0); i += 1){
      if (statement.equals(word[1])){
        correctGuess = true;
        unguessed[i] = word[i];
      }
    }
    if ((correctGuess == true) && (unguessed.indexOf("_") > -1)){
      System.out.println("Ding ding! You guessed correctly!")
      System.out.println("What you have now: " + unguessed);
    }
    else if ((correctGuess == true) && (unguessed.indexOf("_") == -1)){
      System.out.println("Woohoo! You got the word!");
    }
    else if ((correctGuess == false) && (lives > 0)){
      lives -= 1;
      System.out.println("Oops, you have " + lives + "left");
    }
    if (lives == 0){
      System.out.println("K.O.");
      System.out.println("Correct answer " + word);
    }
    correctGuess = false;
  }
}
