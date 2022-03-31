package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Subscription {
    private LocalDate registrationStartDate;
    private LocalDate registrationStopDate;
    private final LocalTime startAllowedTime = LocalTime.of(8,0);
    private LocalTime stoppedAllowedTime;
    private final SubscriptionType subscriptionType;
    private Zones[] allowedZone;
    private final Client client;

    public Subscription(SubscriptionType subscriptionType, Client client) {
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.registrationStartDate = LocalDate.now();
        this.setRegistrationStopDate();
        this.setStoppedAllowedTime();
        this.setAllowedZone();
    }
    public Subscription(SubscriptionType subscriptionType, Client client, String registrationStartDate) {
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.setRegistrationStartDate(registrationStartDate);
        this.setRegistrationStopDate();
        this.setStoppedAllowedTime();
        this.setAllowedZone();
    }

    private void setRegistrationStartDate(String registrationStartDateString) {
        LocalDate tempRegistrationStartDate = LocalDate.parse(registrationStartDateString);
        if (tempRegistrationStartDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата регистрации не может быть раньше текущей");
        }
        this.registrationStartDate = tempRegistrationStartDate;
    }


    private void setRegistrationStopDate() {
        if (this.subscriptionType == SubscriptionType.SINGLE) this.registrationStopDate = this.registrationStartDate;
        if (this.subscriptionType == SubscriptionType.DAILY) this.registrationStopDate = this.registrationStartDate.plusMonths(6);
        if (this.subscriptionType == SubscriptionType.FULL) this.registrationStopDate = this.registrationStartDate.plusYears(1);
    }

    private void setStoppedAllowedTime() {
        if (this.subscriptionType == SubscriptionType.SINGLE || this.subscriptionType == SubscriptionType.FULL) this.stoppedAllowedTime = LocalTime.of(22,0);
        if (this.subscriptionType == SubscriptionType.DAILY) this.stoppedAllowedTime = LocalTime.of(16,0);
    }

    private void setAllowedZone() {
        if (this.subscriptionType == SubscriptionType.SINGLE) this.allowedZone = new Zones[] {Zones.SWIMPOOL, Zones.GYM};
        if (this.subscriptionType == SubscriptionType.DAILY) this.allowedZone = new Zones[] {Zones.GROUP, Zones.GYM};
        if (this.subscriptionType == SubscriptionType.FULL) this.allowedZone = new Zones[] {Zones.SWIMPOOL, Zones.GYM, Zones.GROUP};
    }

    public boolean checkOutdated() {
        return this.registrationStopDate.isBefore(LocalDate.now());
    }

    public boolean checkAllowedTime() {
        return LocalTime.now().isBefore(this.stoppedAllowedTime) && (LocalTime.now().isAfter(this.startAllowedTime));
    }

    public LocalDate getRegistrationStartDate() {
        return registrationStartDate;
    }

    public LocalDate getRegistrationStopDate() {
        return registrationStopDate;
    }

    public LocalTime getStartAllowedTime() {
        return startAllowedTime;
    }

    public LocalTime getStoppedAllowedTime() {
        return stoppedAllowedTime;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public boolean checkAllowedZone(Zones requestedZone) {
        if (requestedZone == Zones.SWIMPOOL) {
            for (Zones zone : this.getAllowedZone()) {
                if (zone == Zones.SWIMPOOL) return true;
            }
            return false;
        }
        if (requestedZone == Zones.GYM) {
            for (Zones zone : this.getAllowedZone()) {
                if (zone == Zones.GYM) return true;
            }
            return false;
        }
        if (requestedZone == Zones.GROUP) {
            for (Zones zone : this.getAllowedZone()) {
                if (zone == Zones.GROUP) return true;
            }
            return false;
        }
        return false;
    }


    public Zones[] getAllowedZone() {
        return allowedZone;
    }

    public Client getClient() {
        return client;
    }
}
