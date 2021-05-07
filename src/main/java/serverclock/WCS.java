/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclock;

import TimeMovement.ClockManager;
import TimeMovement.IClockManager;
import alarm.AlarmFabric;
import alarm.IEventListener;
import clock.HourMinClock;
import clock.HourMinSecClock;
import clock.IClock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanislavyurin
 */
public class WCS extends Thread implements IObserver {
    
    Socket cs;

    InputStream is;
    OutputStream os;

    DataInputStream dis;
    DataOutputStream dos;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
//    IClock hms_clock1 = new HourMinSecClock(0, 0, 0, 31.99f, "hms_clock1");
//    IClockManager hms_clock1_manager = new ClockManager(hms_clock1);
//    
//    IClock hms_clock2 = new HourMinSecClock(0, 0, 0, 26.99f, "hms_clock2");
//    IClockManager hms_clock2_manager = new ClockManager(hms_clock2);
//
//    IClock hm_clock = new HourMinClock(0, 0, 41.99f, "hm_clock");
//    IClockManager hm_clock_manager = new ClockManager(hm_clock);
    
    IClock cur_clock;
    IClockManager cur_clock_manager;

    public WCS(Socket cs, IClock cur_clock, IClockManager cur_clock_manager) {
        this.cs = cs;
        this.cur_clock = cur_clock;
        this.cur_clock_manager = cur_clock_manager;
        
        try {
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }
        cur_clock.addEventObserver(this);
//        hms_clock1.addEventObserver(this);
//        hms_clock2.addEventObserver(this);
//        hm_clock.addEventObserver(this);
//        
//        hms_clock1_manager.startTime();
//        
//        System.out.println(hms_clock1);

        // cur_clock_manager.startTime();
        

        
        this.start();
        
    }
    
    @Override
    public void run() {
        try {
            is = cs.getInputStream();
            dis = new DataInputStream(is);
            
            while (true) {
                
                String obj = dis.readUTF();
                Msg msg = gson.fromJson(obj, Msg.class);
                
                int hour = msg.getAlarm_hour();
                int min = msg.getAlarm_min();
                int sec = msg.getAlarm_sec();
                
                // System.out.println(msg.toString());
                
                
                IEventListener alarm = AlarmFabric.hmsAlarmCreate(hour, min, sec);
                cur_clock.addEventListener(alarm);
                                
                if (null != msg.op) switch (msg.op) {
                    case op_start:
                        cur_clock_manager.startTime();
                        break;
                    case op_freeze:
                        cur_clock_manager.freezeTime();
                        break;
                    case op_continue:
                        cur_clock_manager.continueTime();
                        break;
                    case op_stop:
                        cur_clock_manager.stopTime();
                        break;
                    default:
                        break;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update() {
        try {
            Resp r = new Resp(cur_clock.toString(), cur_clock.isAlarm_now());
            
            String s = gson.toJson(r);
            System.out.println(s);
            dos.writeUTF(s);
        } catch (IOException ex) {
            Logger.getLogger(WCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
