/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeMovement;

import Exceptions.SetTimeException;
import Exceptions.TimeForwardException;
import clock.IClock;
import clock.SetType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stani
 */
public class TimeMovement implements Runnable {
    IClock clock;
    // IClockManager clock_manager;

    public TimeMovement(IClock clock/*, IClockManager clock_manager*/) {
        this.clock = clock;
        // this.clock_manager = clock_manager;
    }
    
    @Override
    public void run() {
        try {
            if ("clock.ourMinClock".equals(clock.getClass().getName())) {
                while (true) {
                    if (clock.isPause()) {
                        synchronized (clock) {
                            clock.wait();
                        }
                        clock.setPause(false);
                    }
                    Thread.sleep(1000 * 60);
                    clock.moveTimeForward(1, SetType.min);
                }
            } else if ("clock.HourMinSecClock".equals(clock.getClass().getName())) {
                while (true) {
                    if (clock.isPause()) {
                        synchronized(clock) {
                            clock.wait();
                        }
                        clock.setPause(false);
                    }
                    Thread.sleep(1000);
                    clock.moveTimeForward(1, SetType.sec);
                }
            }
        } catch (InterruptedException ex) {
            clock.setPause(false);
            try {
                clock.setTime(0, SetType.hour);
                clock.setTime(0, SetType.min);
                clock.setTime(0, SetType.sec);
            } catch (SetTimeException e) {
                System.out.println(e);
            }
        } catch (TimeForwardException ex) {
            System.out.println(ex);
        }
        
    }
    
    
    
}
