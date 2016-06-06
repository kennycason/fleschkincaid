package com.kennycason.fleschkincaid.lexer.word;

import com.kennycason.fleschkincaid.lexer.sentence.Sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenny on 3/11/14.
 */
public class WordLexer {

    public List<Word> tokenize(final Sentence sentence) {
        final List<Word> words = new ArrayList<>();

        final String[] parsedWords = sentence.getText().split("\\s+");
        for (final String word : parsedWords) {
            words.add(new Word(word));
        }

        return words;
    }

}
