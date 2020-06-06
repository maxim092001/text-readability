package readability;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grankin Maxim (maximgran@gmail.com) at 12:14 06.06.2020
 */
public class ReadabilityScores {
    private double automatedReadabilityIndex;
    private double fleschKincaidTests;
    private double simpleMeasureOfGobbledygook;
    private double colemanLiauIndex;
    private double averageAge;
    private double sumAge;

    public ReadabilityScores() {
    }

    public List<String> getScores(final List<String> scores, final TextStatistic textStatistic) {
        List<String> result = new ArrayList<>();
        initAutomatedReadabilityIndex(textStatistic);
        initFleschKincaidTests(textStatistic);
        initSimpleMeasureOfGobbledygook(textStatistic);
        initColemanLiauIndex(textStatistic);
        double numberOfScores = 0;
        for (String word : scores) {
            switch (word) {
                case "ARI":
                    result.add(String.format("Automated Readability Index: %.2f (about %d year olds)",
                            automatedReadabilityIndex,
                            AgeStatistic.getAge((int)Math.round(automatedReadabilityIndex))));
                    numberOfScores++;
                    break;
                case "FK":
                    result.add(String.format("Flesch–Kincaid readability tests: %.2f (about %d year olds)",
                            fleschKincaidTests,
                            AgeStatistic.getAge((int)Math.round(fleschKincaidTests))));
                    numberOfScores++;
                    break;
                case "SMOG":
                    result.add(String.format("Simple Measure of Gobbledygook: %.2f (about %d year olds)",
                            simpleMeasureOfGobbledygook,
                            AgeStatistic.getAge((int)Math.round(simpleMeasureOfGobbledygook))));
                    numberOfScores++;
                    break;
                case "CL":
                    result.add(String.format("Coleman–Liau index: %.2f (about %d year olds)",
                            colemanLiauIndex,
                            AgeStatistic.getAge((int)Math.round(colemanLiauIndex))));
                    numberOfScores++;
                    break;
                case "all":
                    result.add(String.format("Automated Readability Index: %.2f (about %d year olds)",
                            automatedReadabilityIndex,
                            AgeStatistic.getAge((int)Math.round(automatedReadabilityIndex))));
                    result.add(String.format("Flesch–Kincaid readability tests: %.2f (about %d year olds)",
                            fleschKincaidTests,
                            AgeStatistic.getAge((int)Math.round(fleschKincaidTests))));
                    result.add(String.format("Simple Measure of Gobbledygook: %.2f (about %d year olds)",
                            simpleMeasureOfGobbledygook,
                            AgeStatistic.getAge((int)Math.round(simpleMeasureOfGobbledygook))));
                    result.add(String.format("Coleman–Liau index: %.2f (about %d year olds)",
                            colemanLiauIndex,
                            AgeStatistic.getAge((int)Math.round(colemanLiauIndex))));
                    numberOfScores = 4;
                    break;
            }
            sumAge();
            averageAge = sumAge / numberOfScores;
        }


        return result;
    }

    private void sumAge() {
        sumAge += AgeStatistic.getAge((int)Math.round(automatedReadabilityIndex));
        sumAge += AgeStatistic.getAge((int)Math.round(simpleMeasureOfGobbledygook));
        sumAge += AgeStatistic.getAge((int)Math.round(fleschKincaidTests));
        sumAge += AgeStatistic.getAge((int)Math.round(colemanLiauIndex));
    }

    private void initAutomatedReadabilityIndex(final TextStatistic statistics) {
        this.automatedReadabilityIndex = 4.71 * statistics.getCharacters() / statistics.getWords()
                + 0.5 * statistics.getWords() / statistics.getSentences() - 21.43;
    }

    private void initFleschKincaidTests(final TextStatistic statistic) {
        this.fleschKincaidTests = 0.39 * statistic.getWords() / statistic.getSentences() +
                11.8 * statistic.getSyllables() / statistic.getWords() - 15.59;
    }

    private void initSimpleMeasureOfGobbledygook(final TextStatistic statistic) {
        this.simpleMeasureOfGobbledygook = 1.043 * Math.sqrt(statistic.getPolysyllables() * 30.0
                / statistic.getSentences()) + 3.1291;
    }

    private void initColemanLiauIndex(final TextStatistic statistic) {
        this.colemanLiauIndex = 0.0588 * 100.0 * statistic.getCharacters() / statistic.getWords() -
                0.296 * 100.0 * statistic.getSentences() / statistic.getWords() - 15.8;
    }

    public double getAverageAge() {
        return averageAge;
    }
}
