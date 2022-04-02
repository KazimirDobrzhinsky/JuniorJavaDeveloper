package ru.itmo.lessons.course1;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public enum SubscriptionType {
    SINGLE(new Zones[] {Zones.SWIMPOOL, Zones.GYM}, LocalTime.of(22,0), ChronoUnit.DAYS, 0),
    DAILY(new Zones[] {Zones.GROUP, Zones.GYM}, LocalTime.of(16,0), ChronoUnit.MONTHS, 6),
    FULL(new Zones[] {Zones.SWIMPOOL, Zones.GYM, Zones.GROUP}, LocalTime.of(22,0), ChronoUnit.YEARS, 1);
    private final Zones[] allowedZone;
    private final LocalTime startAllowedTime = LocalTime.of(8,0);
    private final LocalTime stoppedAllowedTime;
    private final ChronoUnit expire;
    private long value;

    SubscriptionType(Zones[] allowedZone, LocalTime stoppedAllowedTime, ChronoUnit expire, long value) {
        this.allowedZone = allowedZone;
        this.stoppedAllowedTime = stoppedAllowedTime;
        this.expire = expire;
        this.setValue(value);
    }

    private void setValue(long value) {
        if (value < 0) throw new IllegalArgumentException("Величина не может быть меньше нуля");
        this.value = value;
    }

    public Zones[] getAllowedZone() {
        return allowedZone;
    }

    public LocalTime getStartAllowedTime() {
        return startAllowedTime;
    }

    public LocalTime getStoppedAllowedTime() {
        return stoppedAllowedTime;
    }

    public ChronoUnit getExpire() {
        return expire;
    }

    public long getValue() {
        return value;
    }
}
