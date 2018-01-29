package com.tracktik.scheduler.domain;

import java.util.ArrayList;
import java.util.List;

public class Employee {

  private String id;
  private String name;
  private AvailabilityPreference availabilityPreference;
  private List<Site> siteExperience = new ArrayList<>();
  private List<Post> postExperience = new ArrayList<>();
  private List<Skill> skills = new ArrayList<>();
  private Long cost;  //times 100
  private Long preferredHours = 40L;
  private Double latitude;
  private Double longitude;

  public String getId() {
    return id;
  }

  public Employee setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Employee setName(String name) {
    this.name = name;
    return this;
  }

  public AvailabilityPreference getAvailabilityPreference() {
    return availabilityPreference;
  }

  public Employee setAvailabilityPreference(AvailabilityPreference availabilityPreference) {
    this.availabilityPreference = availabilityPreference;
    return this;
  }

  public List<Site> getSiteExperience() {
    return siteExperience;
  }

  public Employee setSiteExperience(List<Site> siteExperience) {
    this.siteExperience = siteExperience;
    return this;
  }

  public List<Post> getPostExperience() {
    return postExperience;
  }

  public Employee setPostExperience(List<Post> postExperience) {
    this.postExperience = postExperience;
    return this;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public Employee setSkills(List<Skill> skills) {
    this.skills = skills;
    return this;
  }

  public Long getCost() {
    return cost;
  }

  public Employee setCost(Long cost) {
    this.cost = cost;
    return this;
  }

  public Long getPreferredHours() {
    return preferredHours;
  }

  public Employee setPreferredHours(Long preferredHours) {
    this.preferredHours = preferredHours;
    return this;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Employee setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Employee setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    Employee other = (Employee) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


  public Employee setCostFromFloatString(String pay_rate) {
    if (pay_rate != null) {
      Float rate = new Float(pay_rate);
      rate = rate * 100;
      this.setCost(rate.longValue());
    }

    return this;
  }


  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", availabilityPreference=" + availabilityPreference +
        ", siteExperience=" + siteExperience +
        ", skills=" + skills +
        ", cost=" + cost +
        ", preferredHours=" + preferredHours +
        '}';
  }
}
