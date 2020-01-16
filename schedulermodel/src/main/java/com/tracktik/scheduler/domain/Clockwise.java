package com.tracktik.scheduler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@Data
public class Clockwise {
    private int id;
    private Set<Payroll> payrollSet = new HashSet<Payroll>();
    private Set<Period> periodSet = new HashSet<Period>();

    /*
    @param pst is a payrollSchedule's PeriodStartTime
    @param psd is a payrollSchedule's PeriodStartDate
    @param freq is a payrollSchedule's Frequency
     */
    public Clockwise(LocalTime pst, LocalDate psd, String freq){
        periodSet = new HashSet<Period>();
        payrollSet =  new HashSet<Payroll>();
        int tempTime = 0;
        switch (freq){
            case "weekly":
                for(int i=0; i<12; i++) {
                    Period period = new Period();
                    period.setId(i);
                    if(i == 0){
                        tempTime += (psd.getDayOfYear() * 86400);
                        tempTime += (pst.getHour() * 3600);
                        tempTime += (pst.getMinute() * 60);
                        tempTime += (pst.getSecond());
                        period.setStartTimeStamp(tempTime);
                    } else {
                        tempTime++;
                        period.setStartTimeStamp(tempTime);
                    }
                    tempTime += (7*86400); //days in a week * seconds in a day
                    tempTime--; //to not offset every period by one second
                    period.setEndTimeStamp(tempTime);
                    periodSet.add(period);
                    payrollSet.addAll(Payroll.gimmeFive(i));
                }
                break;
            case "bi_weekly":
                for(int i=0; i<6; i++){
                    Period period = new Period();
                    period.setId(i);
                    if(i == 0){
                        tempTime += (psd.getDayOfYear() * 86400);
                        tempTime += (pst.getHour() * 3600);
                        tempTime += (pst.getMinute() * 60);
                        tempTime += (pst.getSecond());
                        period.setStartTimeStamp(tempTime);
                    } else {
                        tempTime++;
                        period.setStartTimeStamp(tempTime);
                    }
                    tempTime += (14*86400); //days in two weeks * seconds in a day
                    tempTime--; //to not offset every period by one second
                    period.setEndTimeStamp(tempTime);
                    periodSet.add(period);
                    payrollSet.addAll(Payroll.gimmeFive(i));
                }
                break;
            default:
                break;
        }
    }

}
