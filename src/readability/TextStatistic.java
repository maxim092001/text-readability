package readability;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Grankin Maxim (maximgran@gmail.com) at 11:00 05.06.2020
 */
public class TextStatistic {
    private long words;
    private long sentences;
    private long characters;
    private long syllables;
    private long polysyllables;

    public TextStatistic() {
    }

    public void countStatistics(final List<String> text) {
        long characters = 0;
        long numberOfWordsInSentence = 0;
        long numberOfWordsSummary = 0;
        long numberOfSentences = 0;
        long syllablesSummary = 0;
        long polysyllables = 0;

        for (String word : text) {
            long syllables = countSyllablesInWord(word);
            polysyllables += syllables > 2 ? 1 : 0;

            characters += word.length();
            syllablesSummary += syllables;

            char lastSymbol = word.charAt(word.length() - 1);

            if (lastSymbol == '.' || lastSymbol == '!' || lastSymbol == '?') {
                numberOfWordsSummary += numberOfWordsInSentence + 1;
                numberOfSentences++;
                numberOfWordsInSentence = 0;
            } else {
                numberOfWordsInSentence++;
            }
        }

        numberOfSentences += numberOfWordsInSentence == 0 ? 0 : 1;
        numberOfWordsSummary += numberOfWordsInSentence;
        this.words = numberOfWordsSummary;
        this.sentences = numberOfSentences;
        this.characters = characters;
        this.syllables = syllablesSummary;
        this.polysyllables = polysyllables;
    }

    private long countSyllablesInWord(final String word) {
        String i = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher m = Pattern.compile(i).matcher(word);
        int syllables = 0;

        while (m.find()) {
            syllables++;
        }

        return Math.max(syllables, 1);
    }

    public long getWords() {
        return words;
    }

    public void setWords(final long words) {
        this.words = words;
    }

    public long getSentences() {
        return sentences;
    }

    public void setSentences(final long sentences) {
        this.sentences = sentences;
    }

    public long getCharacters() {
        return characters;
    }

    public void setCharacters(final long characters) {
        this.characters = characters;
    }

    public long getSyllables() {
        return syllables;
    }

    public void setSyllables(final long syllables) {
        this.syllables = syllables;
    }

    public void setPolysyllables(final long polysyllables) {
        this.polysyllables = polysyllables;
    }

    public long getPolysyllables() {
        return polysyllables;
    }
}
