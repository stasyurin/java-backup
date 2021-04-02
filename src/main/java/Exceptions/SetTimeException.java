/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author stani
 */
public class SetTimeException extends Exception {
    String message;

    public SetTimeException(String str) {
        message = str;
    }
    
    public String toString() {
        return "setTime: " + message;
    }
}
