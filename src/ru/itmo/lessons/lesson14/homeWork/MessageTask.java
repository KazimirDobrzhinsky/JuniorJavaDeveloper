package ru.itmo.lessons.lesson14.homeWork;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        int[] count = new int[MessagePriority.values().length];

        for (Message message : messageList) {
            count[message.getPriority().ordinal()]++;
        }

        System.out.println("Кол-во приоритетов: Low -" + count[0] + ", Medium - " + count[1] + ", High - " + count[2] + ", Urgent - " + count[3]);
        System.out.println();
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        /*int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;*/

        int[] counts = new int[10];

        for (Message message : messageList) {
            counts[message.getCode()]++;

        }
        //System.out.println("Кол-во кодов: 1 - " + count1 + ", 2 - " + count2 + ", 3 - " +count3 + ", 4 - " +count4 + ", 5 - " +
        //        count5 + ", 6 - " +count6 + ", 7 - " +count7 + ", 8 - " +count8 + ", 9 - " +count9 + ", 10 - " +count10);
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> uniqueMessageList = new HashSet<>(messageList);
        System.out.println("Кол-во уникальных сообщений - " + uniqueMessageList.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> uniqueMessageList = new LinkedHashSet<>(messageList);
        messageList = new ArrayList<>(uniqueMessageList);
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удалениия");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() == priority) {
                iterator.remove();
            }
        }
        System.out.println("После удаления");
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("До удалениия");
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() != priority) {
                iterator.remove();
            }
        }
        System.out.println("После удаления");
        System.out.println(messageList);
    }

}
