package com.kennycason.fleschkincaid.lexer;

import com.kennycason.fleschkincaid.lexer.syllable.SyllableLexer;
import com.kennycason.fleschkincaid.lexer.word.Word;
import org.junit.Test;

/**
 * Created by kenny on 3/12/14.
 */
public class SyllableLexerTest {

    @Test
    public void countTest() {
        count("kawazaki");
        count("am");
        count("going");
        count("away");
        count("syllable");
        count("arrangement");
        count("strange");
    }

    private void count(final String word) {
        System.out.println("counting syllables: " + word);
        final SyllableLexer syllableLexer = new SyllableLexer();
        System.out.println(syllableLexer.count(new Word(word)));
    }

}
