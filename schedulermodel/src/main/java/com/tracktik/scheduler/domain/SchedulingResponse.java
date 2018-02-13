package com.tracktik.scheduler.domain;

import java.util.HashSet;
import java.util.Set;

public class SchedulingResponse {

  private String id;
  private SolverStatus status;
  private Set<Shift> shifts = new HashSet<>();
  private SchedulingResponseMetadata meta = new SchedulingResponseMetadata();
  private Set<SchedulingResponse> next_best_solutions = new HashSet<>();

  public SchedulingResponse() {
  }

  public String getId() {
    return id;
  }

  public SchedulingResponse setId(String id) {
    this.id = id;
    return this;
  }

  public SolverStatus getStatus() {
    return status;
  }

  public SchedulingResponse setStatus(SolverStatus status) {
    this.status = status;
    return this;
  }

  public Set<Shift> getShifts() {
    return shifts;
  }

  public SchedulingResponse setShifts(Set<Shift> shifts) {
    this.shifts = shifts;
    return this;
  }

  public SchedulingResponseMetadata getMeta() {
    return meta;
  }

  public SchedulingResponse setMeta(SchedulingResponseMetadata meta) {
    this.meta = meta;
    return this;
  }

  public Set<SchedulingResponse> getNext_best_solutions() {
    return next_best_solutions;
  }

  public SchedulingResponse setNext_best_solutions(Set<SchedulingResponse> next_best_solutions) {
    this.next_best_solutions = next_best_solutions;
    return this;
  }

  @Override
  public String toString() {
    return "SchedulingResponse{" +
        "id='" + id + '\'' +
        ", status=" + status +
        ", shifts=" + shifts +
        ", meta=" + meta +
        ", next_best_solutions=" + next_best_solutions +
        '}';
  }
}
