package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Subscription {
    private LocalDate registrationStartDate;
    private LocalDate registrationStopDate;
    private final SubscriptionType subscriptionType;
    private final Client client;

    public Subscription(SubscriptionType subscriptionType, Client client) {
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.registrationStartDate = LocalDate.now();
        this.setRegistrationStopDate();
    }

    public Subscription(SubscriptionType subscriptionType, Client client, String registrationStartDate) {
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.setRegistrationStartDate(registrationStartDate);
        this.setRegistrationStopDate();
    }

    private void setRegistrationStartDate(String registrationStartDateString) {
        LocalDate tempRegistrationStartDate = LocalDate.parse(registrationStartDateString);
        if (tempRegistrationStartDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата регистрации не может быть раньше текущей");
        }
        this.registrationStartDate = tempRegistrationStartDate;
    }


    private void setRegistrationStopDate() {
       this.registrationStopDate = this.registrationStartDate.plus(this.subscriptionType.getValue(),this.subscriptionType.getExpire());
    }

    /*private void setStoppedAllowedTime() {
        if (this.subscriptionType == SubscriptionType.SINGLE || this.subscriptionType == SubscriptionType.FULL) this.stoppedAllowedTime = LocalTime.of(22,0);
        if (this.subscriptionType == SubscriptionType.DAILY) this.stoppedAllowedTime = LocalTime.of(16,0);
    }*/

    /*private void setAllowedZone() {
        if (this.subscriptionType == SubscriptionType.SINGLE) this.allowedZone = new Zones[] {Zones.SWIMPOOL, Zones.GYM};
        if (this.subscriptionType == SubscriptionType.DAILY) this.allowedZone = new Zones[] {Zones.GROUP, Zones.GYM};
        if (this.subscriptionType == SubscriptionType.FULL) this.allowedZone = new Zones[] {Zones.SWIMPOOL, Zones.GYM, Zones.GROUP};
    }*/

    public boolean checkOutdated() {
        return this.registrationStopDate.isBefore(LocalDate.now());
    }

    public boolean checkAllowedTime() {
        return LocalTime.now().isBefore(this.subscriptionType.getStoppedAllowedTime()) && (LocalTime.now().isAfter(this.subscriptionType.getStartAllowedTime()));
    }

    public LocalDate getRegistrationStartDate() {
        return registrationStartDate;
    }

    public LocalDate getRegistrationStopDate() {
        return registrationStopDate;
    }

    /*public LocalTime getStartAllowedTime() {
        return startAllowedTime;
    }

    public LocalTime getStoppedAllowedTime() {
        return stoppedAllowedTime;
    }*/

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public boolean checkAllowedZone(Zones requestedZone) {
        if (requestedZone == Zones.SWIMPOOL) {
            for (Zones zone : this.subscriptionType.getAllowedZone()) {
                if (zone == Zones.SWIMPOOL) return true;
            }
            return false;
        }
        if (requestedZone == Zones.GYM) {
            for (Zones zone : this.subscriptionType.getAllowedZone()) {
                if (zone == Zones.GYM) return true;
            }
            return false;
        }
        if (requestedZone == Zones.GROUP) {
            for (Zones zone : this.subscriptionType.getAllowedZone()) {
                if (zone == Zones.GROUP) return true;
            }
            return false;
        }
        return false;
    }


    /*public Zones[] getAllowedZone() {
        return allowedZone;
    }*/

    public Client getClient() {
        return client;
    }
}
