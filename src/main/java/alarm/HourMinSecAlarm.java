/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import Exceptions.SetTimeException;
import clock.IClock;
import clock.SetType;

/**
 *
 * @author stani
 */
public class HourMinSecAlarm extends HourMinAlarm {
    int sec;

    public HourMinSecAlarm(int hour, int min, int sec) {
        super(hour, min);
        this.sec = sec;
    }
    
    
    @Override
    public void setTime(int val, SetType t) throws SetTimeException {
        try {
            super.setTime(val, t);
        } catch (SetTimeException e) {
            if (t == SetType.sec) {
                if (!isSecValidValue(val)) {
                    throw new SetTimeException("setSec: invalid value");
                } else {
                    sec = val;
                }
            } else {
                throw new SetTimeException("not allowed type: " + t);
            }
        }
    }
    
    public boolean isSecValidValue(int sec) {
        return isMinValidValue(sec);
    }


    
    @Override
    public int getTime(SetType t) throws SetTimeException {
        try {
            return super.getTime(t);
        } catch (SetTimeException e) {
            if (t == SetType.sec) {
                return sec;
            } else {
                throw new SetTimeException("not allowed type: " + t);
            }
        }
    }
}
