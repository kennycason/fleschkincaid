package com.fleschkincaid.lexer;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by kenny on 3/11/14.
 */
public class SyllableLexer {

    private static final Pattern SYLLABLE_PATTERN = Pattern.compile("[aeiouy]+?\\w*?[^e]");

    public List<Syllable> tokenize(Sentence sentence) {
        List<Syllable> syllables = new LinkedList<>();

        for(String syllable : SYLLABLE_PATTERN.split(sentence.getText())) {
            syllables.add(new Syllable(syllable));
        }

        return syllables;
    }

}
