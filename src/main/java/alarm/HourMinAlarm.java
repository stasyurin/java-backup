/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import Exceptions.SetTimeException;
import Exceptions.TimeForwardException;
import clock.SetType;
import clock.IClock;

/**
 *
 * @author stani
 */
public class HourMinAlarm implements IAlarm {

    int hour, min;
    boolean alarm_now = false;

    public HourMinAlarm(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }


    
    @Override
    public void setAlarm_now(boolean alarm_now) {
        this.alarm_now = alarm_now;
    }

    public boolean isAlarm_now() {
        return alarm_now;
    }
    
    
    

    @Override
    public void setTime(int val, SetType t) throws SetTimeException {
        switch (t) {
            case hour:
                if (!isHourValidValue(val)) {
                    throw new SetTimeException("setHour: invalid value");
                } else {
                    hour = val;
                }
                break;
            case min:
                if (!isMinValidValue(val)) {
                    throw new SetTimeException("setMin: invalid value");
                } else {
                    min = val;
                }
                break;
            default:
                throw new SetTimeException("not allowed type: " + t);
        }
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean isHourValidValue(int hour) {
        if (hour < 0 || hour > 11) {
            return false;
        }
        return true;
    }

    public boolean isMinValidValue(int min) {
        if (min < 0 || min > 59) {
            return false;
        }
        return true;
    }
    
    


    @Override
    public int getTime(SetType t) throws SetTimeException {
        if (t == SetType.hour) {
            return hour;
        } else if (t == SetType.min) {
            return min;
        } else {
            throw new SetTimeException("not allowed type: " + t);
        }
    }
    
    
}
