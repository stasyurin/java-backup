/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Exceptions.SetTimeException;
import Exceptions.TimeForwardException;
import clock.IClock;
import clock.Clock;
import clock.HourMinClock;
import clock.HourMinSecClock;
import java.util.Scanner;
import clock.SetType;

/**
 *
 * @author stani
 */
public class Main {
    public static void main(String[] args) {
        
        Clock clock = new Clock(11.50f, "clockBrand");
        
        System.out.println(clock);
        
        System.out.println();
        
        
        
        IClock hour_min_clock = new HourMinClock(0, 0, 14.30f, "hour_min_clock_brand");
        
        System.out.println(hour_min_clock);
        System.out.println();
             
        System.out.println("setTime call");
        try {
            hour_min_clock.setTime(9, SetType.hour);
            hour_min_clock.setTime(30, SetType.min);
            hour_min_clock.setTime(10, SetType.sec);
        } catch (SetTimeException e) {
            System.out.println(e);
        }

        System.out.println();
        
        System.out.println(hour_min_clock);
        System.out.println();
        
        
        System.out.println("moveTimeForward call");
        try {
            hour_min_clock.moveTimeForward(50, SetType.min);
        } catch (TimeForwardException e) {
            System.out.println(e);
        }

        System.out.println();
        
        System.out.println(hour_min_clock);
        System.out.println();
        
        
        System.out.println();
        
        
        
        
        
        IClock hour_min_sec_clock = new HourMinSecClock(0, 0, 0, 14.30f, "hour_min_sec_clock_brand");
        
        System.out.println(hour_min_sec_clock);
        System.out.println();
             
        System.out.println("setTime call");
        try {
            hour_min_sec_clock.setTime(9, SetType.hour);
            hour_min_sec_clock.setTime(30, SetType.min);
            hour_min_sec_clock.setTime(10, SetType.sec);
        } catch (SetTimeException e) {
            System.out.println(e);
        }

        System.out.println();
        
        System.out.println(hour_min_sec_clock);
        System.out.println();
        
        
        System.out.println("moveTimeForward call");
        try {
            hour_min_sec_clock.moveTimeForward(50, SetType.min);
        } catch (TimeForwardException e) {
            System.out.println(e);
        }

        System.out.println();
        
        System.out.println(hour_min_sec_clock);
        System.out.println();
        
        
    }
}
