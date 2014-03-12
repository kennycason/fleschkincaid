package com.fleschkincaid.lexer;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by kenny on 3/11/14.
 */
public class SyllableLexer {

    private static final Pattern SYLLABLE_PATTERN = Pattern.compile("[aeiouy]+?\\w*?[^e]");

    // TODO use countSyllables() logic to tokenize
    public List<Syllable> tokenize(Word word) {
        List<Syllable> syllables = new LinkedList<>();

        for(String syllable : SYLLABLE_PATTERN.split(word.getText())) {
            syllables.add(new Syllable(syllable));
        }

        return syllables;
    }

    public int countSyllables(Word word) {
        final String wordText = word.getText();
        final int length = wordText.length();
        int syl = 0;
        boolean vowel = false;

        if(wordText.isEmpty()) { return 0; }

        // check each word for vowels (don't count more than one vowel in a row)
        for(int i = 0; i < length; i++) {
            if (isVowel(wordText.charAt(i)) && !vowel) {
                vowel = true;
                syl++;
            } else if (isVowel(wordText.charAt(i)) && vowel) {
                vowel = true;
            } else {
                vowel = false;
            }
        }
        char tempChar = wordText.charAt(wordText.length()-1);
        // check for 'e' at the end, as long as not a word w/ one syllable
        if (((tempChar == 'e') || (tempChar == 'E')) && (syl != 1)) {
            syl--;
        }
        return syl;
    }

    //check if a char is a vowel (count y)
    public boolean isVowel(char c) {
        if ((c == 'a') || (c == 'A')) { return true;  }
        else if ((c == 'e') || (c == 'E')) { return true;  }
        else if ((c == 'i') || (c == 'I')) { return true;  }
        else if ((c == 'o') || (c == 'O')) { return true;  }
        else if ((c == 'u') || (c == 'U')) { return true;  }
        else if ((c == 'y') || (c == 'Y')) { return true;  }
        else { return false; }
    }

}
