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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author stanislavyurin
 */

public class ServerClockClass {

    int port = 3124;
    InetAddress host;
    

    
    public ServerClockClass() {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerClockClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ServerSocket ss = new ServerSocket(port, 0, host);
            System.out.println("Server started");
            
            IClock hms_clock1 = new HourMinSecClock(0, 0, 0, 31.99f, "hms_clock1");
            IClockManager hms_clock1_manager = new ClockManager(hms_clock1);

//            IClock hms_clock2 = new HourMinSecClock(0, 0, 0, 26.99f, "hms_clock2");
//            IClockManager hms_clock2_manager = new ClockManager(hms_clock2);
//
//            IClock hm_clock = new HourMinClock(0, 0, 41.99f, "hm_clock");
//            IClockManager hm_clock_manager = new ClockManager(hm_clock);

            while (true) {

                Socket cs = ss.accept();

                System.out.println("Client connected");
                new WCS(cs, hms_clock1, hms_clock1_manager);
//                new WCS(cs, hms_clock2, hms_clock2_manager);
//                new WCS(cs, hm_clock, hm_clock_manager);

            }

        } catch (IOException ex) {
            Logger.getLogger(ServerClockClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    public static void main(String[] args) {
        new ServerClockClass();
    }
}
