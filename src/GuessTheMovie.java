import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheMovie {
    static Random randomNumber = new Random();
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static void main (String [] args) throws FileNotFoundException {
        System.out.println("You have 15 tries to guess the letters of a popular movie I pick at random!" +
                "\nRemember, it's one letter at a time! Let's goooooo!");
        // Open the file to be read
        File file = new File("movieList.txt");
        // Put the list into an array
        Scanner scanner = new Scanner(file);
        String [] movieArray = new String[25];
        for (int i = 0; i < 25; i++){
            movieArray [i] = scanner.nextLine();
        }
        // Create a random number that will be used to choose one of the movies
        int movieNumber = randomNumber.nextInt(25);
        String movie = movieArray[movieNumber];
        // Replace name with underscores
        String underScored = movie.replaceAll("\\S", "_");
        // Ask user to start guessing
        System.out.println(underScored);
        Scanner userInput = new Scanner(System.in);
        // Keep count of the number of tries
        int count = 15;
        // Create while loop to replace underscores with user guesses that are correct. It iterates 15 times and on
        // the condition that the movie name has not yet been completely figured out
        while (!movie.equals(underScored) && count > 0) {
            System.out.println("You have " + count + " guesses left.");
            // Store the letter in a variable
            char letter = userInput.next().charAt(0);
            // Replace underscore with letter if any of them match
            for (int i = 0; i < movie.length(); i++) {
                if (letter == movie.charAt(i)) {
                    underScored = underScored.substring(0, i) + letter + underScored.substring(i + 1);
                    System.out.println(underScored);
                }
            }
            count--;
        }
        // Display winner or loser message
            if (movie.equals(underScored)){
                System.out.println("You win, and you did it in only " + (15 - count) + " guesses!! Congratulations my cultured friend!");
            }
            else{
                System.out.println("You lose. Get cultured please. The movie name was " + movie);
            }
    }
}
