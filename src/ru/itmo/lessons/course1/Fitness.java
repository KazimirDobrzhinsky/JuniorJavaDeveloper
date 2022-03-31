package ru.itmo.lessons.course1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Fitness {
    private String fitnessCLubTitle;
    private final Subscription[] subscriptionInPool = new Subscription[20];
    private final Subscription[] subscriptionInGym = new Subscription[20];
    private final Subscription[] subscriptionInGroup = new Subscription[20];

    public Fitness(String fitnessCLubTitle) {
        this.setFitnessCLubTitle(fitnessCLubTitle);
    }

    public void register(Subscription subscription, Zones zone) {
        if (subscription.checkOutdated()) {
            System.out.println("Абонемент просрочен");
            return;
        }
        if (!subscription.checkAllowedTime()) {
            System.out.println("Абонемент не позволяет занятия в текущее время");
            return;
        }
        if (this.checkIfAlreadyRegistered(zone, subscription)) {
            System.out.println("Абонемент уже зарегистрирован в одной из зон");
            return;
        }
        if (!subscription.checkAllowedZone(zone)) {
            System.out.println("Абонемент не включает запрошенную зону");
            return;
        }
        if (!this.checkIfFree(zone)) {
            System.out.println("Отсутствуют места в запрошенной зоне");
            return;
        }
        for (int i = 0; i < Objects.requireNonNull(this.returnZone(zone)).length; i++) {
            if (Objects.requireNonNull(this.returnZone(zone))[i] == null) {
                Objects.requireNonNull(this.returnZone(zone))[i] = subscription;
                break;
            }
        }
        System.out.println("Клиент " + subscription.getClient().getSurname() + " " + subscription.getClient().getName() + " зарегистрирован в зоне:" + zone.returnRussianNameOfZone());
        System.out.println("Время посещения: " + LocalDateTime.now());
    }

    private Subscription[] returnZone(Zones zone){
        if (zone == Zones.SWIMPOOL) {
            return this.subscriptionInPool;
        }
        if (zone == Zones.GROUP) {
            return this.subscriptionInGroup;
        }
        if (zone == Zones.GYM) {
            return this.subscriptionInGym;
        }
        return null;
    }

    public void printInformationAboutRegistration() {
        StringBuilder sbGym = new StringBuilder("Посетители тренажерного зала: ");
        StringBuilder sbPool = new StringBuilder("Посетители бассейна: ");
        StringBuilder sbGroup = new StringBuilder("Посетители групповых занятий: ");
        for (Subscription value : this.subscriptionInGym) {
            if (value != null) {
                sbGym.append(value.getClient().toString()).append(" ");
            }
        }
        for (Subscription subscription : this.subscriptionInPool) {
            if (subscription != null) {
                sbPool.append(subscription.getClient().toString()).append(" ");
            }
        }
        for (Subscription subscription : this.subscriptionInGroup) {
            if (subscription != null) {
                sbGroup.append(subscription.getClient().toString()).append(" ");
            }
        }
        System.out.println(sbGym);
        System.out.println(sbPool);
        System.out.println(sbGroup);
    }

    /*@Override
    public String toString() {
        return "Фитнесс клуб " + this.getFitnessCLubTitle() +
                "Посетители тренажерного зала: " + Arrays.toString(subscriptionInGym) +
                ", Посетители бассейна: " + Arrays.toString(subscriptionInPool) +
                ", Посетители групповых занятий: " + Arrays.toString(subscriptionInGroup);
    }*/ // - не потребовалось

    public void closeFitness() {
        Arrays.fill(this.subscriptionInGroup, null);
        Arrays.fill(this.subscriptionInPool, null);
        Arrays.fill(this.subscriptionInGym, null);
    }


    private boolean checkIfFree (Zones zone) {
        for (Subscription subscription : Objects.requireNonNull(this.returnZone(zone))) {
            if (subscription == null) return true;
        }
        return false;
    }

    private boolean checkIfAlreadyRegistered (Zones zone, Subscription subscription) {
        if (zone == Zones.SWIMPOOL) {
            for (Subscription value : this.subscriptionInGroup) {
                if (value == subscription) return true;
            }
            for (Subscription value : this.subscriptionInGym) {
                if (value == subscription) return true;
            }
        }
        if (zone == Zones.GYM) {
            for (Subscription value : this.subscriptionInGroup) {
                if (value == subscription) return true;
            }
            for (Subscription value : this.subscriptionInPool) {
                if (value == subscription) return true;
            }
        }
        if (zone == Zones.GROUP) {
            for (Subscription value : this.subscriptionInGym) {
                if (value == subscription) return true;
            }
            for (Subscription value : this.subscriptionInPool) {
                if (value == subscription) return true;
            }
        }
        return false;
    }

    public String getFitnessCLubTitle() {
        return fitnessCLubTitle;
    }

    public void setFitnessCLubTitle(String fitnessCLubTitle) {
        if (fitnessCLubTitle.length() < 3) {
            throw new IllegalArgumentException("Название клуба не может быть менее 2х символов");
        }
        this.fitnessCLubTitle = fitnessCLubTitle;
    }
}
