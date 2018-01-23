package com.tracktik.scheduler.application.domain;

import com.tracktik.scheduler.application.SolverStatus;
import com.tracktik.scheduler.domain.Schedule;
import com.tracktik.scheduler.domain.Shift;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchedulingResponse {

  public String id;
  public SolverStatus status;
  public Set<Shift> shifts = new HashSet<>();
  public SchedulingResponseMetadata meta;

  public SchedulingResponse(Schedule schedule, Long hardScore, Long softScore, SolverStatus _status) {
    id = schedule.getId();
    status = _status;
    shifts = schedule.getShifts();
    meta = new SchedulingResponseMetadata(hardScore, softScore);
  }

}
