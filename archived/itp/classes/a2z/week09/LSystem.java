/* Daniel Shiffman               */
/* Programming from A to Z       */
/* Spring 2006                   */
/* http://www.shiffman.net       */
/* daniel.shiffman@nyu.edu       */

/* LSystem Class                 */

// An LSystem has a starting sentence
// An a ruleset
// Each generation recursively replaces characteres in the sentence
// Based on the rulset

public class LSystem {
    
    private String sentence;     // The sentence (a String)
    private Rule[] ruleset;      // The ruleset (an array of Rule objects)
    private int generation;      // Keeping track of the generation #
    
    // Construct an LSystem with a startin sentence and a ruleset
    public LSystem(String axiom, Rule[] r) {
        sentence = axiom;
        ruleset = r;
        generation = 0;
    }
    
    // Generate the next generation
    public void generate() {
        // An empty StringBuffer that we will fill
        StringBuffer nextgen = new StringBuffer();
        // For every character in the sentence
        for (int i = 0; i < sentence.length(); i++) {
            // What is the character
            char curr = sentence.charAt(i);
            // We will replace it with itself unless it matches one of our rules
            String replace = "" + curr;
            // Check every rule
            for (int j = 0; j < ruleset.length; j++) {
                char a = ruleset[j].getMatch();
                // if we match the Rule, get the replacement String out of the Rule
                if (a == curr) {
                    replace = ruleset[j].getReplace();
                    break; 
                }
            }
            // Append replacement String
            nextgen.append(replace);
        }
        // Replace sentence
        sentence = nextgen.toString();
        // Increment generation
        generation++;
    }
    
    public String getSentence() {
        return sentence; 
    }
    
    public int getGeneration() {
        return generation; 
    }
    
 
}
