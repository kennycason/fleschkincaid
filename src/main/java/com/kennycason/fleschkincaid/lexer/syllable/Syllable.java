package com.kennycason.fleschkincaid.lexer.syllable;

/**
 * Created by kenny on 3/11/14.
 */
public class Syllable {

    private final String text;

    public Syllable(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Syllable{" +
                "text='" + text + '\'' +
                '}';
    }

}

