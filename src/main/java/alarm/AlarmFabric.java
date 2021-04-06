/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import Exceptions.SetTimeException;
import clock.Clock;
import clock.IClock;
import clock.SetType;
import java.util.ArrayList;

/**
 *
 * @author stani
 */
public class AlarmFabric {
    static public IEventListener hmAlarmCreate(int hour, int min) {
        return new HourMinAlarm(hour, min);
    }
    
    static public IEventListener hmsAlarmCreate(int hour, int min, int sec) {
        return new HourMinSecAlarm(hour, min, sec);
    }
    
    static public HMAlarmChecker hmAlarmCheckerCreate(ArrayList<IEventListener> alarms, IClock clock) {
        return new HMAlarmChecker(alarms, clock);
    }
    
    static public HMSAlarmChecker hmsAlarmCheckerCreate(ArrayList<IEventListener> alarms, IClock clock) {
        return new HMSAlarmChecker(alarms, clock);
    }
}
