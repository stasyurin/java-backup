/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeMovement;

/**
 *
 * @author stanislavyurin
 */
public interface IClockManager {
    void startTime();
    void stopTime();
    void freezeTime();
    void continueTime();
}
