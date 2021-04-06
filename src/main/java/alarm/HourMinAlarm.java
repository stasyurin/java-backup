/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import Exceptions.SetTimeException;
import clock.SetType;
import clock.IClock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stani
 */
public class HourMinAlarm implements IEventListener {

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

    @Override
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
        return !(hour < 0 || hour > 11);
    }

    public boolean isMinValidValue(int min) {
        return !(min < 0 || min > 59);
    }
    
    


    @Override
    public int getTime(SetType t) throws SetTimeException {
        if (null == t) {
            throw new SetTimeException("not allowed type: " + t);
        } else switch (t) {
            case hour:
                return hour;
            case min:
                return min;
            default:
                throw new SetTimeException("not allowed type: " + t);
        }
    }

    /**
     *
     * @param clock
     */
    @Override
    public void handleEvent(IClock clock) {
        try {
            if (clock.getTime(SetType.min) == min
                    && clock.getTime(SetType.hour) == hour) {
                setAlarm_now(true);
                
                Thread alarmTurnOffThread;
                alarmTurnOffThread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            setAlarm_now(false);
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }
                };
                alarmTurnOffThread.start();
            }
        } catch (SetTimeException ex) {
            System.out.println(ex);
        }
    }
    
    
}
