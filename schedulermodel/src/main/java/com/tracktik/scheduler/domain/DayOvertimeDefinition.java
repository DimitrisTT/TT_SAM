package com.tracktik.scheduler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class DayOvertimeDefinition {
  private String id;
  private String name;
  private Long minimumHours;
  private Long maximumHours;
  private String overtimeType;
}