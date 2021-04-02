/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import clock.SetType;
import Exceptions.SetTimeException;

/**
 *
 * @author stani
 */
public interface IAlarm {

    void setTime(int val, SetType t) throws Exceptions.SetTimeException;
    int getTime(SetType t) throws Exceptions.SetTimeException;
    void setAlarm_now(boolean alarm_now);
    boolean isAlarm_now();
}
