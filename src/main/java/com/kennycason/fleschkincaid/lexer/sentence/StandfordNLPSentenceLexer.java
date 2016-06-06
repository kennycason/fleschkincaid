package com.kennycason.fleschkincaid.lexer.sentence;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenny on 3/11/14.
 *
 * A naive version
 */
public class StandfordNLPSentenceLexer implements SentenceLexer {

    @Override
    public List<Sentence> tokenize(final String text) {
        final List<Sentence> sentences = new ArrayList<>();
        final DocumentPreprocessor dp = new DocumentPreprocessor(new StringReader(text));

        for (final List<HasWord> sentence : dp) {
            sentences.add(new Sentence(sentence.toString()));
        }
        return sentences;
    }

}
