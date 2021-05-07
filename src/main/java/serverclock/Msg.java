/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclock;

import java.sql.Struct;

/**
 *
 * @author stanislavyurin
 */
public class Msg {
    Operation op;
    WhatClockEnum what_clock;
    int alarm_hour;
    int alarm_min;
    int alarm_sec;

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public WhatClockEnum getWce() {
        return what_clock;
    }

    public void setWce(WhatClockEnum wce) {
        this.what_clock = wce;
    }

    public void setAlarm_hour(int alarm_hour) {
        this.alarm_hour = alarm_hour;
    }

    public void setAlarm_min(int alarm_min) {
        this.alarm_min = alarm_min;
    }

    public void setAlarm_sec(int alarm_sec) {
        this.alarm_sec = alarm_sec;
    }

    public void setWhat_clock(WhatClockEnum what_clock) {
        this.what_clock = what_clock;
    }

    public WhatClockEnum getWhat_clock() {
        return what_clock;
    }

    public int getAlarm_hour() {
        return alarm_hour;
    }

    public int getAlarm_min() {
        return alarm_min;
    }

    public int getAlarm_sec() {
        return alarm_sec;
    }

    @Override
    public String toString() {
        return "Msg{" + "op=" + op + ", what_clock=" + what_clock + ", alarm_hour=" + alarm_hour + ", alarm_min=" + alarm_min + ", alarm_sec=" + alarm_sec + '}';
    }
    
    

    
    
    
}
