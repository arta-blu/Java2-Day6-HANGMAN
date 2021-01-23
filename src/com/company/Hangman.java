package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;
import java.util.*;


public class Hangman {

    private static final int MAX_RETRY_COUNT = 6; //this will not change, no initiate anything, can not change value
    private static final String HIDDEN_LETTER = "_";

    private List<String> words = new ArrayList<>(); //not using Set - because doublicate can be


    //need to initialize, otherwise it will be null
    private int tryCounter = 0;
    private Set<Character> usedLetters = new HashSet<>(); //Set - allows us to save unique values
    private String currentWord;
    private String hiddenWord;

    public Hangman() {
        loadWords();
        restart(); //restart here as initializing the game
    }

    public int getTryCounter() { //use this value to get "picture"

        return tryCounter;
    }

    public int getTryCount(){

        return (MAX_RETRY_COUNT - tryCounter); //remaining trys
    }

    public String getHiddenWord() {

        return hiddenWord;
    }

    public void restart() { // () does not take any arguments
        tryCounter = 0;
        usedLetters.clear(); //clear - used letter set should be empty
        pickWord();
    }

    public void guess(Character ch) {
        var chUpper = ch.toString().toUpperCase();

        if (isGameOver() != GameResult.CONTINUE) { //iepriekš bija: tryCounter == MAX_RETRY_COUNT
            return;
        }

        if (usedLetters.contains(chUpper)) {
            return;
        }

        if (currentWord.toUpperCase().contains(chUpper)) {

            var chArray = hiddenWord.toCharArray();

            for (int i = 0; i < currentWord.length(); i++) { //swapping underscores to letter
                if (currentWord.toUpperCase().charAt(i) == chUpper.charAt(0)) {
                    chArray[i] = chUpper.charAt(0); // chUpper.charAt(0);
                }
            }

            hiddenWord = new String(chArray); //replace positions with found letter __A__A_
        } else {
            usedLetters.add(chUpper.charAt(0));
            ++tryCounter; //++ position indicates at which point increase the value
        }
    }

    public Iterable<Character> getUsedLetters() { //interface of particular data type, returns list for for each loop, non changeable just readable
        return usedLetters;
    }

    public GameResult isGameOver() { //using ENUM class - GameResult - more return answers possible
        if( tryCounter == MAX_RETRY_COUNT){//(...)- return value of expression
            return GameResult.HANG_THE_MAN;
        }else if (!hiddenWord.contains(HIDDEN_LETTER)){
            return GameResult.SUCCESS;
        }
        return GameResult.CONTINUE;
    }

    private void pickWord() { // this method will set currentWord
        var wordCount = words.size(); //how many words in that list, but it is excl.! if nr incl -1
        var index = getRandomNumber(0, wordCount); //list is 0-based,min value is 0
        currentWord = words.get(index); //after getting number we get the word

   //corrected      System.out.println("Test " + currentWord); //testing porposes which word

        hiddenWord = "";

        for (int i = 0; i < currentWord.length(); i++) {
            hiddenWord += HIDDEN_LETTER; //concatinate with some symbol
        }
    }

    private int getRandomNumber(int min, int max) { //values I need to parse,
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private void loadWords() {
        words.clear(); //iztīra pirms saliek vārdus iekšā

        try {
            File myObj = new File("C:\\Temp\\hangman.txt"); //file path
            Scanner myReader = new Scanner(myObj); //file handle myObj

            while (myReader.hasNextLine()) { //do we have next line
                String data = myReader.nextLine(); // if we have one line at a time
           //corrected     System.out.println(data); //printing that data out

                words.add(data); //will add all words from the file
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}














