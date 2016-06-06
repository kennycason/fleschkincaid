package com.kennycason.fleschkincaid;

import com.kennycason.fleschkincaid.lexer.sentence.Sentence;
import com.kennycason.fleschkincaid.lexer.sentence.SentenceLexer;
import com.kennycason.fleschkincaid.lexer.sentence.SimpleSentenceLexer;
import com.kennycason.fleschkincaid.lexer.syllable.SyllableLexer;
import com.kennycason.fleschkincaid.lexer.word.Word;
import com.kennycason.fleschkincaid.lexer.word.WordLexer;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kenny on 3/11/14.
 */
public class FleschKincaid {

    private static final int MIN_ALLOWED_SENTENCE_LENGTH = 10;

    private SentenceLexer sentenceLexer;

    private final SyllableLexer syllableLexer;

    private final WordLexer wordLexer;

    public FleschKincaid() {
        sentenceLexer = new SimpleSentenceLexer();
        syllableLexer = new SyllableLexer();
        wordLexer = new WordLexer();
    }

    public double calculate(final String text) {
        final List<Sentence> sentences = filterInvalidSentences(this.sentenceLexer.tokenize(text));
        final int syllableCount = countSyllables(sentences);
        final int wordCount = countWords(sentences);

        //calculate flesch index
        final double f1 = 206.835;
        final double f2 = 84.6;
        final double f3 = 1.015;
        final double r1 = (double) syllableCount / (double) wordCount;
        final double r2 = (double) wordCount / (double) sentences.size();

        return f1 - (f2 * r1) - (f3 * r2);
    }

    private static List<Sentence> filterInvalidSentences(final List<Sentence> sentences) {
        final Iterator<Sentence> iterator = sentences.iterator();
        while (iterator.hasNext()) {
            final Sentence sentence = iterator.next();
            if (sentence.getText().length() < MIN_ALLOWED_SENTENCE_LENGTH) {
                iterator.remove();
            }
        }
        return sentences;
    }

    private int countWords(final List<Sentence> sentences) {
        int count = 0;
        for( final Sentence sentence : sentences) {
            count += wordLexer.tokenize(sentence).size();
        }

        return count;
    }

    private int countSyllables(final List<Sentence> sentences) {
        int count = 0;
        for (final Sentence sentence : sentences) {
            for (final Word word : wordLexer.tokenize(sentence)) {
                count += syllableLexer.count(word);
            }
        }

        return count;
    }

    public void setSentenceLexer(final SentenceLexer sentenceLexer) {
        this.sentenceLexer = sentenceLexer;
    }

}
