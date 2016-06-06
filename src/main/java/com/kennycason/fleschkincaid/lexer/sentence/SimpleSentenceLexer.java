package com.kennycason.fleschkincaid.lexer.sentence;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by kenny on 3/11/14.
 *
 * A naive version
 */
public class SimpleSentenceLexer implements SentenceLexer {

    public List<Sentence> tokenize(final String text) {
        final List<Sentence> sentences = new LinkedList<>();
        final BreakIterator border = BreakIterator.getSentenceInstance(Locale.US);
        border.setText(text);
        int start = border.first();
        //iterate, creating sentences out of all the Strings between the given boundaries
        for (int end = border.next(); end != BreakIterator.DONE; start = end, end = border.next()) {
            sentences.add(new Sentence(text.substring(start,end)));
        }
        return sentences;
    }

}
