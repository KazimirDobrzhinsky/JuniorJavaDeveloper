package ru.itmo.lessons.lesson17.homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopTenWords {
    public static void main(String[] args) {

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout the point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // TODO: Используя Stream API: создать Map<String, Long>, где
        //  - String - слово
        //  - Long - частота встречаемости
        //  В мапу должны войти только первые 10 по частоте встречаемости слов.

        topTenWords(text);

    }

    public static void topTenWords(String text) {
        /*Map<String, Long> mostFrequentWords = new HashMap<>();
        String[] subStr;
        subStr = text.split(" ");
        long oldValue;
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = subStr[i].toLowerCase();
        }
        for (String s : subStr) {
            if (!mostFrequentWords.containsKey(s)) {
                mostFrequentWords.put(s, (long) 1);
            } else {
                oldValue = mostFrequentWords.get(s);
                mostFrequentWords.replace(s, oldValue, oldValue + 1);
            }
        }

        Map<String, Long> sortedMap = mostFrequentWords.entrySet().stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).limit(10).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(sortedMap);*/

        Map<String, Long> map = Arrays.stream(text.split(" "))
                .collect(Collectors
                        .groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));


    }
}
