package com.tracktik.scheduler.configuration;

import com.tracktik.scheduler.domain.ConfigFact;

import java.util.Objects;

public class NotAvailable extends ConfigFact {

    private int scoreImpact = -100;
    private boolean hardImpact = true;
    private boolean active = true;

    public NotAvailable(int scoreImpact, boolean hardImpact, boolean active) {
        this.scoreImpact = scoreImpact;
        this.hardImpact = hardImpact;
        this.active = active;
    }

    public NotAvailable() {
    }

    public int getScoreImpact() {
        return scoreImpact;
    }

    public void setScoreImpact(int scoreImpact) {
        this.scoreImpact = scoreImpact;
    }

    public boolean ishardImpact() {
        return hardImpact;
    }

    public void setHardImpact(boolean hardImpact) {
        this.hardImpact = hardImpact;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotAvailable that = (NotAvailable) o;
        return scoreImpact == that.scoreImpact &&
                hardImpact == that.hardImpact &&
                active == that.active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreImpact, hardImpact, active);
    }

    @Override
    public String toString() {
        return "NotAvailable{" +
                "scoreImpact=" + scoreImpact +
                ", hardImpact=" + hardImpact +
                ", active=" + active +
                '}';
    }
}
