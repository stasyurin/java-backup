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
public class HMAlarmChecker implements Runnable {
    ArrayList<IEventListener> alarms = new ArrayList<>();
    IClock clock;

    public HMAlarmChecker(ArrayList<IEventListener> alarms, IClock clock) {
        this.alarms = alarms;
        this.clock = clock;
    }
    
    
    
    @Override
    public void run() {
//        while (true) {
//            try {
//                for (IEventListener alarm : alarms) {
//                    if (clock.getTime(SetType.min) == alarm.getTime(SetType.min)
//                            && clock.getTime(SetType.hour) == alarm.getTime(SetType.hour)) {
//                        alarm.setAlarm_now(true);
//
//                        Thread alarmTurnOffThread;
//                        alarmTurnOffThread = new Thread() {
//                            @Override
//                            public void run() {
//                                try {
//                                    Thread.sleep(3000);
//                                    alarm.setAlarm_now(false);
//                                } catch (InterruptedException e) {
//                                    System.out.println(e);
//                                }
//                            }
//                        };
//                        alarmTurnOffThread.start();
//                    }
//                }
//            } catch (SetTimeException e) {
//                System.out.println(e);
//            }
//        }
    }
}
