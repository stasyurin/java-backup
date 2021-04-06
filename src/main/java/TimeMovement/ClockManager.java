/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeMovement;

import clock.IClock;

/**
 *
 * @author stanislavyurin
 */
public class ClockManager implements IClockManager {
    
    IClock clock;
    ClockState clock_state;
    Runnable r;
    Thread tread;

    public ClockManager(IClock clock) {
        this.clock = clock;
        r = new TimeMovement(clock);
    }

    public void set_clock_state(ClockState clock_state) {
        this.clock_state = clock_state;
    }

    public ClockState get_clock_state() {
        return clock_state;
    }

    @Override
    public void startTime() {
        if (tread == null) {
            tread = new Thread(r);
            tread.start();
        }
    }
    
    @Override
    public void stopTime() {
        if (tread != null) {
            tread.interrupt();
            tread = null;
        }
    }

    @Override
    public void freezeTime() {
        clock.setPause(true);
    }

    @Override
    public void continueTime() {
        synchronized (clock) {
            clock.notifyAll();
        }
    }
    
}
