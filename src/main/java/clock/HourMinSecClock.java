/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import Exceptions.SetTimeException;
import Exceptions.TimeForwardException;

/**
 *
 * @author stani
 */
public class HourMinSecClock extends HourMinClock{
    int sec_hand;
  

    public HourMinSecClock(int sec_hand, int hour_hand, int min_hand, float cost, String brand) {
        super(hour_hand, min_hand, cost, brand);
        this.sec_hand = sec_hand;
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
                    sec_hand = val;
                }
            } else {
                throw new SetTimeException("not allowed type: " + t);
            }
        }
    }

    public boolean isSecValidValue(int sec) {
        return isMinValidValue(sec);
    }

    public void setSec(int sec) {
        sec_hand = sec;
    }

    public int getSec() {
        return sec_hand;
    }
    
    @Override
    public String toString() {
        return super.toString() + ":" + sec_hand;
    }

    public void moveSecForward(int sec_incr) {
        this.sec_hand += sec_incr % 60;
        if (this.sec_hand >= 60) {
            this.sec_hand -= 60;
            moveMinForward(1);
        }
        moveMinForward(sec_incr / 60);
    }

    @Override
    public void moveTimeForward(int val, SetType t) throws TimeForwardException {
        try {
            super.moveTimeForward(val, t);
        } catch (TimeForwardException e) {
            if (t == SetType.sec) {
                if (!isTimeForwardValidValue(val)) {
                    throw new TimeForwardException("sec: invalid value");
                } else {
                    moveSecForward(val);
                }
            } else {
                throw new TimeForwardException("not allowed type: " + t);
            }
        }
    }

    @Override
    public int getTime(SetType t) throws SetTimeException {
        try {
            return super.getTime(t);
        } catch (SetTimeException e) {
            if (t == SetType.sec) {
                return sec_hand;
            } else {
                throw new SetTimeException("not allowed type: " + t);
            }
        }
    }
    
    
}
