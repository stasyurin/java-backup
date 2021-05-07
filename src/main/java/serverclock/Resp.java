/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclock;

import clock.IClock;
import java.util.ArrayList;

/**
 *
 * @author stanislavyurin
 */
public class Resp {
    String clock;
    boolean alarm_now;

    public Resp(String clock, boolean alarm_now) {
        this.clock = clock;
        this.alarm_now = alarm_now;
    }

    public boolean isAlarm_now() {
        return alarm_now;
    }
    

    @Override
    public String toString() {
        return "Resp{" + "clock=" + clock + ", is_alarm_now=" + alarm_now + '}';
    }

    
    
    
    
    
    
}
