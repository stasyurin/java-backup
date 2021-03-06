/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import alarm.IEventListener;
import java.util.ArrayList;
import serverclock.IObserver;


/**
 *
 * @author stani
 */
public interface IClock {
    void setTime(int val, SetType t) throws Exceptions.SetTimeException;
    void moveTimeForward(int val, SetType t) throws Exceptions.TimeForwardException;
    int getTime(SetType t) throws Exceptions.SetTimeException;
    boolean isPause();
    void setPause(boolean pause);
    void addEventListener(IEventListener event_listener);
    void addEventObserver(IObserver o);
    boolean isAlreadyInAll_o(IObserver o);
    public ArrayList<IEventListener> get_event_listeners();
    boolean isAlarm_now();
    void setAlarm_now(boolean alarm_now);
    void timeChanged();
    //void startClock(SetType time_type);
}
