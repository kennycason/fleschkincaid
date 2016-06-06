package com.kennycason.fleschkincaid.lexer.word;

/**
 * Created by kenny on 3/11/14.
 */
public class Word {

    private final String text;

    public Word(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Word{" +
                "text='" + text + '\'' +
                '}';
    }

}

