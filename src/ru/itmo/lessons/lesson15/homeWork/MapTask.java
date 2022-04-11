package ru.itmo.lessons.lesson15.homeWork;



import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(getList(firstTaskMap, city));

        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в списке вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(getMapOfWords(words));


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(getMapOfCustomers(customerMap, 18, 23));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(getAmountOfWord(text, "infancy"));
        System.out.println(getGroupOfWords(text));
        System.out.println();
        System.out.println();
        getMostFrequentWords(text);

    }

    public static List<String> getList(HashMap<String, String> firstTaskMap, String city) {
        ArrayList<String> listOfLogins = new ArrayList<>();
        for (Map.Entry<String, String> pair : firstTaskMap.entrySet()) {
            if (pair.getValue().equalsIgnoreCase(city)) listOfLogins.add(pair.getKey());
        }
        return listOfLogins;
    }

    public static Map<String, Integer> getMapOfWords(List<String> stringList) {
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String string : stringList) {
            if (mapOfWords.containsKey(string)) {
                mapOfWords.replace(string, mapOfWords.get(string) + 1);
            } else {
                mapOfWords.put(string, 1);
            }
        }
        return mapOfWords;
    }

    public static Map<Integer, Customer> getMapOfCustomers(HashMap<String, Customer> customerMap, int from, int to) {
        Map<Integer, Customer> newCustomerMap = new HashMap<>();
        Integer idKey = 1;
        for (Customer customer : customerMap.values()) {
            if (customer.getAge() <= to && customer.getAge() >= from) {
                newCustomerMap.put(idKey, customer);
            }
        }
        return newCustomerMap;
    }

    // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
    //  1. написать метод, принимающий на вход слово и возвращающий частоту
    //  встречаемости данного слова в тексте
    //  2. написать метод, который собирает все слова в группы
    //  по количеству букв:
    //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    //  3. написать метод, который выводит в консоль топ 10 самых частых слов

    public static int getAmountOfWord(String text, String word) {
        String[] subStr;
        subStr = text.split(" ");
        int count = 0;
        for (String s : subStr) {
            if (s.equalsIgnoreCase(word)) count++;
        }
        return count;
    }

    public static Map<Integer, List<String>> getGroupOfWords(String text) {
        Map<Integer, List<String>> groupOfWords = new HashMap<>();
        String[] subStr;
        subStr = text.split(" ");
        for (String s : subStr) {
            if (!groupOfWords.containsKey(s.length())) {
                ArrayList<String> stringArrayList = new ArrayList<>();
                stringArrayList.add(s);
                groupOfWords.put(s.length(), stringArrayList);
            } else {
                groupOfWords.get(s.length()).add(s);
            }
        }
        return groupOfWords;
    }

    public static void getMostFrequentWords(String text) {
        Map<String, Integer> mostFrequentWords = new HashMap<>();
        String[] subStr;
        subStr = text.split(" ");
        int oldValue;
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = subStr[i].toLowerCase();
        }
        for (String s : subStr) {
            if (!mostFrequentWords.containsKey(s)) {
                mostFrequentWords.put(s, 1);
            } else {
                oldValue = mostFrequentWords.get(s);
                mostFrequentWords.replace(s, oldValue, oldValue + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> mostFrequentWordsList = new ArrayList<>(mostFrequentWords.entrySet());

        mostFrequentWordsList.sort((c1,c2) -> (int) c2.getValue() - c1.getValue());

        for (int i = 0; i < 9; i++) {
            System.out.println(mostFrequentWordsList.get(i));
        }


    }
}
