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
public class HourMinClock extends Clock implements IClock{
    int hour_hand = 0;
    int min_hand = 0;
    boolean pause = false;
    
    @Override
    public void setTime(int val, SetType t) throws SetTimeException {
        switch (t) {
            case hour:
                if (!isHourValidValue(val)) {
                    throw new SetTimeException("setHour: invalid value");
                } else {
                    hour_hand = val;
                }
                break;
            case min:
                if (!isMinValidValue(val)) {
                    throw new SetTimeException("setMin: invalid value");
                } else {
                    min_hand = val;
                }
                break;
            default:
                throw new SetTimeException("not allowed type: " + t);
        }
    }

    public void setHour(int hour) {
        hour_hand = hour;
    }

    public void setMin(int min) {
        min_hand = min;
    }
    
    
    public HourMinClock(int hour_hand, int min_hand, float _cost, String _brand) {
        super(_cost, _brand);
        this.hour_hand = hour_hand;
        this.min_hand = min_hand;
    }

    public int getHour() {
        return hour_hand;
    }

    public int getMin() {
        return min_hand;
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
    public String toString() {
        return super.toString() + hour_hand + ":" + min_hand;
    }
    
    public void moveTimeForward(int val, SetType t) throws TimeForwardException {
        switch (t) {
            case hour:
                if (!isTimeForwardValidValue(val)) {
                    throw new TimeForwardException("hour: invalid value");
                } else {
                    moveHourForward(val);
                }
                break;
            case min:
                if (!isTimeForwardValidValue(val)) {
                    throw new TimeForwardException("min: invalid value");
                } else {
                    moveMinForward(val);
                }
                break;
            default:
                throw new TimeForwardException("not allowed type: " + t);
        }
    }

    public void moveMinForward(int min_incr) {
        this.min_hand += min_incr % 60;
        if (this.min_hand >= 60) {
            this.min_hand -= 60;
            moveHourForward(1);
        }
        moveHourForward(min_incr / 60);
    }
    
    public void moveHourForward(int hour_incr) {
        this.hour_hand += hour_incr % 12;
        if (this.hour_hand >= 12) {
            this.hour_hand -= 12;
        }
    }
    
    public boolean isTimeForwardValidValue(int time_incr) {
        if (time_incr < 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    
    
//    @Override
//    public void startClock(SetType change_interval) throws TimeForwardException {
//        try {
//            switch (change_interval) {
//                case hour:
//                    if (t == null) {
//                        t = new Thread() {
//                            @Override
//                            public void run() {
//                                while (true) {
//                                    Thread.sleep(1000 * 60 * 60);
//                                    moveTimeForward(1, change_interval);
//                                }
//                            }
//                        };
//                        t.start();
//                    }
//                    break;
//                case min:
//                    if (t == null) {
//                        t = new Thread() {
//                            @Override
//                            public void run() {
//                                while (true) {
//                                    Thread.sleep(1000 * 60);
//                                    moveTimeForward(1, change_interval);
//                                }
//                            }
//                        };
//                        t.start();
//                    }
//                    break;
//                default:
//                    break;
//            }
//        } catch (InterruptedException ex) {
//
//        } catch (TimeForwardException ex) {
//            System.out.println(ex);
//        }
//
//    }

    @Override
    public int getTime(SetType t) throws SetTimeException {
        if (t == SetType.hour) {
            return hour_hand;
        } else if (t == SetType.min) {
            return min_hand;
        } else {
            throw new SetTimeException("not allowed type: " + t);
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isPause() {
        return pause;
    }
    
    
}
