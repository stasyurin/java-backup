/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import Exceptions.SetTimeException;
import clock.IClock;
import clock.SetType;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author stani
 */
public class HMSAlarmChecker extends HMAlarmChecker {

    public HMSAlarmChecker(ArrayList<IAlarm> alarms, IClock clock) {
        super(alarms, clock);
    }
    
    @Override
    public void run() {
            while (true) {
                try {
                    for (Iterator<IAlarm> iterator = alarms.iterator(); iterator.hasNext();) {
                        IAlarm next = iterator.next();
                        if (clock.getTime(SetType.hour) == next.getTime(SetType.hour)
                                && clock.getTime(SetType.min) == next.getTime(SetType.min)
                                && clock.getTime(SetType.sec) == next.getTime(SetType.sec)) {

                            next.setAlarm_now(true);

                            Thread alarmTurnOffThread = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        next.setAlarm_now(false);
                                    } catch (InterruptedException e) {
                                        System.out.println(e);
                                    }
                                }
                            };
                            alarmTurnOffThread.start();
                        }
                    }
                } catch (SetTimeException e) {
                    System.out.println(e);
                }
            }
    }
}
