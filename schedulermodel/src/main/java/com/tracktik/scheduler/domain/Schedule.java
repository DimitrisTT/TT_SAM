package com.tracktik.scheduler.domain;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import org.optaplanner.persistence.xstream.api.score.buildin.hardsoftlong.HardSoftLongScoreXStreamConverter;

import java.util.HashSet;
import java.util.Set;

@PlanningSolution
public class Schedule {

  private String id;

  @XStreamConverter(HardSoftLongScoreXStreamConverter.class)
  private HardSoftLongScore score;

  @ValueRangeProvider(id = "employees")
  @ProblemFactCollectionProperty
  private Set<Employee> employees = new HashSet<>();

  @PlanningEntityCollectionProperty
  private Set<Shift> shifts = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<Post> posts = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<Site> sites = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<TimeOff> timesOff = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<EmployeeAvailability> employeeAvailabilities = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<ConstraintPreference> constraintPreferences = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<EmployeeSiteDistance> employeeSiteDistance = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<KeyValueFact> keyValueFacts = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<SiteBan> siteBans = new HashSet<>();

  @ProblemFactCollectionProperty
  private Set<EmployeeConstraintMultiplier> employeeConstraintMultipliers = new HashSet<>();

  @PlanningScore
  public HardSoftLongScore getScore() {
    return score;
  }

  public Schedule setScore(HardSoftLongScore score) {
    this.score = score;
    return this;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public Schedule setEmployees(Set<Employee> employees) {
    this.employees = employees;
    return this;
  }

  public Set<Shift> getShifts() {
    return shifts;
  }

  public Schedule setShifts(Set<Shift> shifts) {
    this.shifts = shifts;
    return this;
  }

  public Schedule addShift(Shift shift) {
    shifts.add(shift);
    return this;
  }

  public Schedule addEmployee(Employee employee) {
    employees.add(employee);
    return this;
  }

  public Set<Post> getPosts() {
    return posts;
  }

  public Schedule setPosts(Set<Post> posts) {
    this.posts = posts;
    return this;
  }

  public Set<Site> getSites() {
    return sites;
  }

  public Schedule setSites(Set<Site> sites) {
    this.sites = sites;
    return this;
  }

  public String getId() {
    return id;
  }

  public Schedule setId(String id) {
    this.id = id;
    return this;
  }

  public Set<TimeOff> getTimesOff() {
    return timesOff;
  }

  public Schedule setTimesOff(Set<TimeOff> timesOff) {
    this.timesOff = timesOff;
    return this;
  }

  public Set<EmployeeAvailability> getEmployeeAvailabilities() {
    return employeeAvailabilities;
  }

  public Schedule setEmployeeAvailabilities(Set<EmployeeAvailability> employeeAvailabilities) {
    this.employeeAvailabilities = employeeAvailabilities;
    return this;
  }

  public Set<ConstraintPreference> getConstraintPreferences() {
    return constraintPreferences;
  }

  public Schedule setConstraintPreferences(Set<ConstraintPreference> constraintPreferences) {
    this.constraintPreferences = constraintPreferences;
    return this;
  }

  public Set<EmployeeSiteDistance> getEmployeeSiteDistance() {
    return employeeSiteDistance;
  }

  public Schedule setEmployeeSiteDistance(Set<EmployeeSiteDistance> employeeSiteDistance) {
    this.employeeSiteDistance = employeeSiteDistance;
    return this;
  }

  public Set<KeyValueFact> getKeyValueFacts() {
    return keyValueFacts;
  }

  public Schedule setKeyValueFacts(Set<KeyValueFact> keyValueFacts) {
    this.keyValueFacts = keyValueFacts;
    return this;
  }

  public Set<SiteBan> getSiteBans() {
    return siteBans;
  }

  public Schedule setSiteBans(Set<SiteBan> siteBans) {
    this.siteBans = siteBans;
    return this;
  }

  public Set<EmployeeConstraintMultiplier> getEmployeeConstraintMultipliers() {
    return employeeConstraintMultipliers;
  }

  public Schedule setEmployeeConstraintMultipliers(Set<EmployeeConstraintMultiplier> employeeConstraintMultipliers) {
    this.employeeConstraintMultipliers = employeeConstraintMultipliers;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Schedule schedule = (Schedule) o;

    return id != null ? id.equals(schedule.id) : schedule.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Schedule{" +
        "id='" + id + '\'' +
        ", score=" + score +
        ", employees=" + employees +
        ", shifts=" + shifts +
        ", posts=" + posts +
        ", sites=" + sites +
        ", timesOff=" + timesOff +
        ", employeeAvailabilities=" + employeeAvailabilities +
        ", constraintPreferences=" + constraintPreferences +
        ", employeeSiteDistance=" + employeeSiteDistance +
        ", keyValueFacts=" + keyValueFacts +
        ", siteBans=" + siteBans +
        ", employeeConstraintMultipliers=" + employeeConstraintMultipliers +
        '}';
  }
}
