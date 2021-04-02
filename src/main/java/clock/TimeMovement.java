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
public class TimeMovement implements Runnable {
    IClock clock;

    public TimeMovement(IClock clock) {
        this.clock = clock;
    }
    
    @Override
    public void run() {
        try {
            if (clock.getClass().getName() == "clock.ourMinClock") {
                while (true) {
                    if (clock.isPause()) {
                        synchronized (this) {
                            this.wait();
                        }
                        clock.setPause(false);
                    }
                    Thread.sleep(1000 * 60);
                    clock.moveTimeForward(1, SetType.min);
                }
            } else if (clock.getClass().getName() == "clock.HourMinSecClock") {
                while (true) {
                    if (clock.isPause()) {
                        synchronized(this) {
                            this.wait();
                        }
                        clock.setPause(false);
                    }
                    Thread.sleep(1000);
                    clock.moveTimeForward(1, SetType.sec);
                }
            }
        } catch (InterruptedException ex) {

        } catch (TimeForwardException ex) {
            System.out.println(ex);
        }
        
    }
    
    
    
}
