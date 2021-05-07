/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarm;

import clock.SetType;
import Exceptions.SetTimeException;
import clock.IClock;

/**
 *
 * @author stani
 */
public interface IEventListener {
    void handleEvent(IClock clock);
    void setTime(int val, SetType t) throws Exceptions.SetTimeException;
    int getTime(SetType t) throws Exceptions.SetTimeException;
}
