import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Guess {

    private final String stringGuess;

    public Guess(String guess) {
        guess = guess.toLowerCase();
        this.stringGuess = guess;
    }

    /**
     * Create an answer for the game to compare to
     * @return A random line from the wordle-official file
     * @throws IOException File is not found
     */
    static public String createAnswer() throws IOException {
        File file = new File ("wordle/src/wordle-official.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> answers = new ArrayList<>();
        String line = "";
        while ((line = reader.readLine()) != null) {
            answers.add(line.toLowerCase());
        }

        Random random = new Random();
        return answers.get(random.nextInt(answers.size()));
    }

    /*
    Compares the answer passed in to the guess
    If the letter is in the correct place it will be in the final string.
    If the letter is not in the correct place a * will be placed.
    EX: Answer = "fart" Guess = "kack"
    Return: "*a**"
     */
    public String correctSpot(String answer) {
        if(stringGuess.length() != 5) {
            return null;
        }
        String characters = "";
        for(int i = 0; i < answer.length(); i++) {
            if(answer.charAt(i) == stringGuess.charAt(i)) {
                characters += stringGuess.charAt(i);
            } else {
                characters += '*';
            }
        }
        return characters;
    }

    /*
    Compares the answer to the guess
    If the letter is anywhere in the word it will be in the final string.
    If the letter is not in answer, a * will be placed.
    EX: Answer = "fa123" Guess = "987fa"
    Return: "***fa"
     */
    public String wrongSpot(String answer) {
        String characters = "";
        if(stringGuess.length() != 5) {
            return null;
        }
        for (int i = 0; i < answer.length(); i++) {
            boolean conatinsLetter = countOccurrences(answer, stringGuess.charAt(i)) > 0;
            if (conatinsLetter) {
                int index = answer.indexOf(stringGuess.charAt(i));
                answer = answer.substring(0, index) + '*'
                        + answer.substring(index + 1);
                characters += stringGuess.charAt(i) ;
            } else {
                characters += "*";
            }
        }

        return characters;
    }

    /*
    Counts the number of times a char occurs in a string
     */
    private static int countOccurrences(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    public String getStringGuess() {
        return stringGuess;
    }

}
