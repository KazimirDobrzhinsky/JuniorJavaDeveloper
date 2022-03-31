package ru.itmo.lessons.course1;

public class Application {

    public static void main(String[] args) {
        Client client1 = new Client("Казимир","Добржинский", "1995-03-24");
        Client client2 = new Client("Казимир2","Добржинский", "2005-03-24");
        Client client3 = new Client("Казимир3","Добржинский", "1995-03-24");
        Client client4 = new Client("Казимир4","Добржинский", "1995-03-24");

        Subscription subscription1 = new Subscription(SubscriptionType.FULL, client1);
        Subscription subscription2 = new Subscription(SubscriptionType.FULL, client2);
        Subscription subscription3 = new Subscription(SubscriptionType.FULL, client3);
        Subscription subscription4 = new Subscription(SubscriptionType.FULL, client4);



        Fitness fitnessClub1 = new Fitness("Спарта");

        fitnessClub1.register(subscription1,Zones.GYM);
        fitnessClub1.register(subscription2,Zones.SWIMPOOL);
        fitnessClub1.register(subscription3,Zones.GROUP);
        fitnessClub1.register(subscription4,Zones.GYM);

        fitnessClub1.printInformationAboutRegistration();

        fitnessClub1.closeFitness();

        fitnessClub1.printInformationAboutRegistration();






    }


}
