package com.tracktik.scheduler.api.domain;

public class RequestEmployee {

  public String id;
  public String name;
  public String geo_lat;
  public String geo_lon;
  public String pay_rate;
  public String seniority;

  @Override
  public String toString() {
    return "RequestEmployee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", geo_lat='" + geo_lat + '\'' +
        ", geo_lon='" + geo_lon + '\'' +
        ", pay_rate='" + pay_rate + '\'' +
        ", seniority='" + seniority + '\'' +
        '}';
  }
}
