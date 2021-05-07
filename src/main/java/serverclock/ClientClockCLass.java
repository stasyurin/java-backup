/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverclock;

import TimeMovement.ClockManager;
import TimeMovement.IClockManager;
import clock.HourMinClock;
import clock.HourMinSecClock;
import clock.IClock;
import clock.MainFrame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanislavyurin
 */
public class ClientClockCLass extends Thread {
    
    int port = 3124;
    InetAddress host;

    Socket cs;

    InputStream is;
    OutputStream os;

    DataInputStream dis;
    DataOutputStream dos;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    String hms_clock1;
//    String hms_clock2;
//    String hm_clock;
    
    int alarm_hour;
    int alarm_min;
    int alarm_sec;

    
    MainFrame frame;
    
    Thread t;
    
    public ClientClockCLass(String hms_clock1, /*String hms_clock2,
                            String hm_clock,*/ MainFrame frame) {
        this.cs = cs;
        this.hms_clock1 = hms_clock1;
//        this.hms_clock2 = hms_clock2;
//        this.hm_clock = hm_clock;
        this.frame = frame;
        
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientClockCLass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cs = new Socket(host, port);

            os = cs.getOutputStream();
            dos = new DataOutputStream(os);

        } catch (IOException ex) {
            Logger.getLogger(ClientClockCLass.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.setDLabelText("из конструктора");
        
        this.start();
        
    }
    
    public void setHms_clock1(String hms_clock1) {
        this.hms_clock1 = hms_clock1;
    }

//    public void setHms_clock2(String hms_clock2) {
//        this.hms_clock2 = hms_clock2;
//    }
//
//    public void setHm_clock(String hm_clock) {
//        this.hm_clock = hm_clock;
//    }

    public void setAlarm_hour(int alarm_hour) {
        this.alarm_hour = alarm_hour;
    }

    public void setAlarm_min(int alarm_min) {
        this.alarm_min = alarm_min;
    }

    public void setAlarm_sec(int alarm_sec) {
        this.alarm_sec = alarm_sec;
    }
    
    public void addAlarm_msg(int alarm_hour, int alarm_min, int alarm_sec) {
        try {
            Msg alarm_msg = new Msg();
            
            alarm_msg.setAlarm_hour(alarm_hour);
            alarm_msg.setAlarm_min(alarm_min);
            alarm_msg.setAlarm_sec(alarm_sec);
            
            String s_string = gson.toJson(alarm_msg);
            dos.writeUTF(s_string);
        } catch (IOException ex) {
            Logger.getLogger(ClientClockCLass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addOp_msg(Operation op) {
        try {
            Msg op_msg = new Msg();

            op_msg.setOp(op);

            String s_string = gson.toJson(op_msg);
            dos.writeUTF(s_string);
        } catch (IOException ex) {
            Logger.getLogger(ClientClockCLass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {

            is = cs.getInputStream();
            dis = new DataInputStream(is);

            System.out.println("run запустился (консоль)");
            frame.setDLabelText("run запустился (форма)");

            while (true) {

                
                // System.out.println("serverclock.ClientClockCLass.run()");
                
                String s = dis.readUTF();
                // !!!условие, что s не пустая
                Resp r = gson.fromJson(s, Resp.class);

                // System.out.println(r.toString());

                setHms_clock1(r.clock);
                // System.out.println(hms_clock1);
                frame.changeClockValue(WhatClockEnum.hms_clock1, hms_clock1);
//                frame.changeClockValue(WhatClockEnum.hms_clock2, hms_clock2);
//                frame.changeClockValue(WhatClockEnum.hm_clock, hm_clock);
                
                frame.setAlarmLabelVisible(r.isAlarm_now());

                // условие, что s не пустая!!!
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientClockCLass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
