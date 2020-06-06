package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> text =  getTextFromFile(args[0]);

        TextStatistic statistics = new TextStatistic();
        statistics.countStatistics(text);

        System.out.println(String.format("java Main %s", args[0]));
        System.out.println("The text is:");
        text.forEach((s) -> System.out.print(s + " "));
        System.out.println();
        System.out.println(String.format("Words: %d", statistics.getWords()));
        System.out.println(String.format("Sentences: %d", statistics.getSentences()));
        System.out.println(String.format("Characters: %d", statistics.getCharacters()));
        System.out.println(String.format("Syllables: %d", statistics.getSyllables()));
        System.out.println(String.format("Polysyllables: %d", statistics.getPolysyllables()));
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        Scanner in = new Scanner(System.in);
        String[] desiredParameter = in.nextLine().split(" +");
        System.out.println();
        ReadabilityScores readabilityScores = new ReadabilityScores();
        List<String> scores = readabilityScores.getScores(Arrays.asList(desiredParameter), statistics);
        scores.forEach(System.out::println);

        System.out.println(String.format("This text should be understood in average by %.2f year olds.",
                readabilityScores.getAverageAge()));
    }


    private static List<String> getTextFromFile(final String fileName) {
        List<String> res = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                res.add(scanner.next());
            }
            return res;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

}
