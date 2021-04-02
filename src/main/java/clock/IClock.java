/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;


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
    //void startClock(SetType time_type);
}
