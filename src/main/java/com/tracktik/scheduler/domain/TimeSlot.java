package com.tracktik.scheduler.domain;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class TimeSlot {

  private LocalDateTime start;
  private LocalDateTime end;

  public TimeSlot(String sStartDateTime, String sEndDateTime) {
    start = LocalDateTime.parse(sStartDateTime, DateTimeFormatter.ISO_DATE_TIME);
    end = LocalDateTime.parse(sEndDateTime, DateTimeFormatter.ISO_DATE_TIME);
  }

  public TimeSlot(Long startTime, Long endTime) {
    start = LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), TimeZone.getDefault().toZoneId());
    end = LocalDateTime.ofInstant(Instant.ofEpochMilli(endTime), TimeZone.getDefault().toZoneId());
  }

  public LocalDateTime getStart() {
    return start;
  }

  public TimeSlot setStart(LocalDateTime start) {
    this.start = start;
    return this;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public TimeSlot setEnd(LocalDateTime end) {
    this.end = end;
    return this;
  }

  public Boolean overlaps(TimeSlot other, int hours) {
    LocalDateTime thisEnd = this.getEnd().plusHours(hours);
    LocalDateTime otherEnd = other.getEnd().plusHours(hours);
    return this.getStart().isBefore(otherEnd) && other.getStart().isBefore(thisEnd);

  }

  public Long getDurationHours() {
    return Duration.between(start, end).toHours();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((end == null) ? 0 : end.hashCode());
    result = prime * result + ((start == null) ? 0 : start.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TimeSlot other = (TimeSlot) obj;
    if (end == null) {
      if (other.end != null)
        return false;
    } else if (!end.equals(other.end))
      return false;
    if (start == null) {
      if (other.start != null)
        return false;
    } else if (!start.equals(other.start))
      return false;
    return true;
  }
}
