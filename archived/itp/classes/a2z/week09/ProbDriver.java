/* Daniel Shiffman               */
/* Programming from A to Z       */
/* Spring 2006                   */
/* http://www.shiffman.net       */
/* daniel.shiffman@nyu.edu       */

// Generates a String 100 characters long (starting with 'a')
// Based on probabilities assigned in each letter object

public class ProbDriver {
    
    public static void main(String[] args) {
        
        // Create array of 127 letters
        // (Letter is not really the best word as these can be spaces, numbers, punctuation marks, etc.)
        Letter[] letters = new Letter[127];
        // 
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new Letter((char) i);
            letters[i].calcprob();
        }
        StringBuffer stuff = new StringBuffer();

        char now = 'a';
        for (int i = 0; i < 100; i++) {
            stuff.append(now);
            now = letters[now].pickNext();
        }
        System.out.println(stuff.toString());
    }
}
