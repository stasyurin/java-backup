/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import TimeMovement.TimeMovement;
import Exceptions.SetTimeException;
import TimeMovement.ClockManager;
import TimeMovement.IClockManager;
import alarm.HMAlarmChecker;
import alarm.HMSAlarmChecker;
import alarm.HourMinAlarm;
import alarm.AlarmFabric;
import alarm.HourMinSecAlarm;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import alarm.IEventListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stani
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        alarmLabel1.setVisible(false);
        alarmLabel2.setVisible(false);
        alarmLabel3.setVisible(false);
        // alarmThread.start();
    }
    
    IClock hms_clock1 = new HourMinSecClock(0, 0, 0, 31.99f, "hms_clock1");
    IClockManager hms_clock1_manager = new ClockManager(hms_clock1);
    
    IClock hms_clock2 = new HourMinSecClock(0, 0, 0, 26.99f, "hms_clock2");
    IClockManager hms_clock2_manager = new ClockManager(hms_clock2);
    
    IClock hm_clock = new HourMinClock(0, 0, 41.99f, "hm_clock");
    IClockManager hm_clock_manager = new ClockManager(hm_clock);
        
//    ArrayList <IEventListener> alarms = new ArrayList<>();
//    
//    Runnable alarmChecker = new HMSAlarmChecker(alarms, hms_clock1);
//    Thread alarmThread = new Thread(alarmChecker);
    
    boolean alarm1_now = false;
    boolean alarm2_now = false;
    boolean alarm3_now = false;

    Thread repaintingThread;
    
    // Runnable r1 = new TimeMovement(hms_clock1);
    // Runnable r2 = new TimeMovement(hms_clock2);
    // Runnable r3 = new TimeMovement(hm_clock);
    Thread hms_clock1Thread;
    Thread hms_clock2Thread;
    Thread hm_clockThread;
    
    
    public void startTime() {
//        if (hms_clock1Thread == null) {
//            hms_clock1Thread = new Thread(r1);
//            hms_clock1Thread.start();
//        }
        hms_clock1_manager.startTime();
        hms_clock2_manager.startTime();
        hm_clock_manager.startTime();
//        if (hms_clock2Thread == null) {
//            hms_clock2Thread = new Thread(r2);
//            hms_clock2Thread.start();
//        }
//        if (hm_clockThread == null) {
//            hm_clockThread = new Thread(r3);
//            hm_clockThread.start();
//        }
        
       
        if (repaintingThread == null) {
            repaintingThread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            TimeLabel1.setText("" + hms_clock1);
                            TimeLabel2.setText("" + hms_clock2);
                            TimeLabel3.setText("" + hm_clock);
                            
                            // int alarms_now_num = 0;
                            for (IEventListener alarm : hms_clock1.get_event_listeners()) {
                                if (alarm.isAlarm_now()) {
                                    alarm1_now = true;
                                    // alarms_now_num++;
                                    // alarmLabel1.setText("ALARM " + alarms_now_num);
                                    alarmLabel1.setVisible(true);
                                    break;
                                } else {
                                    alarm1_now = false;
                                }
                            }
                            if (!alarm1_now) {
                                alarmLabel1.setVisible(false);
                            }
                            
                            for (IEventListener alarm : hms_clock2.get_event_listeners()) {
                                if (alarm.isAlarm_now()) {
                                    alarm2_now = true;
                                    // alarms_now_num++;
                                    // alarmLabel1.setText("ALARM " + alarms_now_num);
                                    alarmLabel2.setVisible(true);
                                    break;
                                } else {
                                    alarm2_now = false;
                                }
                            }
                            if (!alarm2_now) {
                                alarmLabel2.setVisible(false);
                            }
                            
                            for (IEventListener alarm : hm_clock.get_event_listeners()) {
                                if (alarm.isAlarm_now()) {
                                    alarm3_now = true;
                                    // alarms_now_num++;
                                    // alarmLabel1.setText("ALARM " + alarms_now_num);
                                    alarmLabel3.setVisible(true);
                                    break;
                                } else {
                                    alarm3_now = false;
                                }
                            }
                            if (!alarm3_now) {
                                alarmLabel3.setVisible(false);
                            }
                            
                            
                            repaint();
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            
                        }
                    }
                }
            };
            repaintingThread.start();
        }
    }
 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TimeLabel1 = new javax.swing.JLabel();
        startTimeButton = new javax.swing.JButton();
        commentLabel = new javax.swing.JLabel();
        TimeLabel2 = new javax.swing.JLabel();
        freezeTimeButton1 = new javax.swing.JButton();
        createAlarmButton1 = new javax.swing.JButton();
        hourTextField1 = new javax.swing.JTextField();
        alarmLabel1 = new javax.swing.JLabel();
        secTextField1 = new javax.swing.JTextField();
        minTextField1 = new javax.swing.JTextField();
        createAlarmButton2 = new javax.swing.JButton();
        continueTimeButton1 = new javax.swing.JButton();
        dLabel = new javax.swing.JLabel();
        setFClockTimeButton = new javax.swing.JButton();
        hourTextField2 = new javax.swing.JTextField();
        minTextField2 = new javax.swing.JTextField();
        secTextField2 = new javax.swing.JTextField();
        freezeTimeButton2 = new javax.swing.JButton();
        continueTimeButton2 = new javax.swing.JButton();
        stopTimeButton1 = new javax.swing.JButton();
        stopTimeButton2 = new javax.swing.JButton();
        alarmLabel2 = new javax.swing.JLabel();
        TimeLabel3 = new javax.swing.JLabel();
        alarmLabel3 = new javax.swing.JLabel();
        hourTextField3 = new javax.swing.JTextField();
        minTextField3 = new javax.swing.JTextField();
        createAlarmButton3 = new javax.swing.JButton();
        freezeTimeButton3 = new javax.swing.JButton();
        continueTimeButton3 = new javax.swing.JButton();
        stopTimeButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TimeLabel1.setText("TimeLabel1");

        startTimeButton.setText("Start time");
        startTimeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startTimeButtonMouseClicked(evt);
            }
        });
        startTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeButtonActionPerformed(evt);
            }
        });

        commentLabel.setText("commentLabel");

        TimeLabel2.setText("TimeLabel2");

        freezeTimeButton1.setText("Freeze time clock1");
        freezeTimeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freezeTimeButton1ActionPerformed(evt);
            }
        });

        createAlarmButton1.setText("Create alarm clock1");
        createAlarmButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAlarmButton1ActionPerformed(evt);
            }
        });

        hourTextField1.setText("0");

        alarmLabel1.setForeground(new java.awt.Color(255, 0, 51));
        alarmLabel1.setText("ALARM!");

        secTextField1.setText("1");

        minTextField1.setText("0");

        createAlarmButton2.setText("Create alarm clock2");
        createAlarmButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAlarmButton2ActionPerformed(evt);
            }
        });

        continueTimeButton1.setText("Continue time clock1");
        continueTimeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueTimeButton1ActionPerformed(evt);
            }
        });

        dLabel.setText("Debug");

        setFClockTimeButton.setText("setFClockTime");
        setFClockTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFClockTimeButtonActionPerformed(evt);
            }
        });

        hourTextField2.setText("0");

        minTextField2.setText("0");

        secTextField2.setText("1");

        freezeTimeButton2.setText("Freeze time clock2");
        freezeTimeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freezeTimeButton2ActionPerformed(evt);
            }
        });

        continueTimeButton2.setText("Continue time clock2");
        continueTimeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueTimeButton2ActionPerformed(evt);
            }
        });

        stopTimeButton1.setText("Stop time clock1");
        stopTimeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopTimeButton1ActionPerformed(evt);
            }
        });

        stopTimeButton2.setText("Stop time clock2");
        stopTimeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopTimeButton2ActionPerformed(evt);
            }
        });

        alarmLabel2.setForeground(new java.awt.Color(255, 0, 51));
        alarmLabel2.setText("ALARM!");

        TimeLabel3.setText("TimeLabel3");

        alarmLabel3.setForeground(new java.awt.Color(255, 0, 51));
        alarmLabel3.setText("ALARM!");

        hourTextField3.setText("0");

        minTextField3.setText("0");

        createAlarmButton3.setText("Create alarm clock3");
        createAlarmButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAlarmButton3ActionPerformed(evt);
            }
        });

        freezeTimeButton3.setText("Freeze time clock3");
        freezeTimeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freezeTimeButton3ActionPerformed(evt);
            }
        });

        continueTimeButton3.setText("Continue time clock3");
        continueTimeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueTimeButton3ActionPerformed(evt);
            }
        });

        stopTimeButton3.setText("Stop time clock3");
        stopTimeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopTimeButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(commentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startTimeButton)
                                .addGap(189, 189, 189)
                                .addComponent(setFClockTimeButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alarmLabel1)
                            .addComponent(continueTimeButton1)
                            .addComponent(stopTimeButton1)
                            .addComponent(TimeLabel1)
                            .addComponent(createAlarmButton1)
                            .addComponent(freezeTimeButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hourTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TimeLabel2)
                                    .addComponent(alarmLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(hourTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(secTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(continueTimeButton2)
                                        .addComponent(freezeTimeButton2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(createAlarmButton2)
                                    .addComponent(stopTimeButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(hourTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(continueTimeButton3)
                                    .addComponent(freezeTimeButton3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(createAlarmButton3)
                                .addComponent(stopTimeButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TimeLabel3)
                                    .addComponent(alarmLabel3))
                                .addGap(78, 78, 78)))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimeLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alarmLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimeLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alarmLabel1)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hourTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createAlarmButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(freezeTimeButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(continueTimeButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopTimeButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hourTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createAlarmButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(freezeTimeButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(continueTimeButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stopTimeButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimeLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alarmLabel3)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hourTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createAlarmButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(freezeTimeButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(continueTimeButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stopTimeButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(dLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setFClockTimeButton)
                    .addComponent(startTimeButton))
                .addGap(2, 2, 2)
                .addComponent(commentLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startTimeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startTimeButtonMouseClicked
        this.startTime();
    }//GEN-LAST:event_startTimeButtonMouseClicked

    private void startTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTimeButtonActionPerformed

    private void createAlarmButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAlarmButton2ActionPerformed
        int hour = Integer.parseInt(hourTextField2.getText());
        int min = Integer.parseInt(minTextField2.getText());
        int sec = Integer.parseInt(secTextField2.getText());

        IEventListener alarm = AlarmFabric.hmsAlarmCreate(hour, min, sec);
        hms_clock2.addEventListener(alarm);
    }//GEN-LAST:event_createAlarmButton2ActionPerformed

    private void setFClockTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFClockTimeButtonActionPerformed
        
    }//GEN-LAST:event_setFClockTimeButtonActionPerformed

    private void freezeTimeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freezeTimeButton2ActionPerformed
        hms_clock2_manager.freezeTime();
    }//GEN-LAST:event_freezeTimeButton2ActionPerformed

    private void continueTimeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueTimeButton2ActionPerformed
        hms_clock2_manager.continueTime();
    }//GEN-LAST:event_continueTimeButton2ActionPerformed

    private void createAlarmButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAlarmButton3ActionPerformed
        int hour = Integer.parseInt(hourTextField3.getText());
        int min = Integer.parseInt(minTextField3.getText());

        IEventListener alarm = AlarmFabric.hmAlarmCreate(hour, min);
        hm_clock.addEventListener(alarm);
    }//GEN-LAST:event_createAlarmButton3ActionPerformed

    private void freezeTimeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freezeTimeButton3ActionPerformed
        hm_clock_manager.freezeTime();
    }//GEN-LAST:event_freezeTimeButton3ActionPerformed

    private void continueTimeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueTimeButton3ActionPerformed
        hm_clock_manager.continueTime();
    }//GEN-LAST:event_continueTimeButton3ActionPerformed

    private void stopTimeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopTimeButton1ActionPerformed
        hms_clock1_manager.stopTime();
    }//GEN-LAST:event_stopTimeButton1ActionPerformed

    private void continueTimeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueTimeButton1ActionPerformed
        hms_clock1_manager.continueTime();
    }//GEN-LAST:event_continueTimeButton1ActionPerformed

    private void freezeTimeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freezeTimeButton1ActionPerformed
        hms_clock1_manager.freezeTime();
    }//GEN-LAST:event_freezeTimeButton1ActionPerformed

    private void createAlarmButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAlarmButton1ActionPerformed
        int hour = Integer.parseInt(hourTextField1.getText());
        int min = Integer.parseInt(minTextField1.getText());
        int sec = Integer.parseInt(secTextField1.getText());

        IEventListener alarm = AlarmFabric.hmsAlarmCreate(hour, min, sec);
        hms_clock1.addEventListener(alarm);
    }//GEN-LAST:event_createAlarmButton1ActionPerformed

    private void stopTimeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopTimeButton2ActionPerformed
        hms_clock2_manager.stopTime();
    }//GEN-LAST:event_stopTimeButton2ActionPerformed

    private void stopTimeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopTimeButton3ActionPerformed
        hm_clock_manager.stopTime();
    }//GEN-LAST:event_stopTimeButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TimeLabel1;
    private javax.swing.JLabel TimeLabel2;
    private javax.swing.JLabel TimeLabel3;
    private javax.swing.JLabel alarmLabel1;
    private javax.swing.JLabel alarmLabel2;
    private javax.swing.JLabel alarmLabel3;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JButton continueTimeButton1;
    private javax.swing.JButton continueTimeButton2;
    private javax.swing.JButton continueTimeButton3;
    private javax.swing.JButton createAlarmButton1;
    private javax.swing.JButton createAlarmButton2;
    private javax.swing.JButton createAlarmButton3;
    private javax.swing.JLabel dLabel;
    private javax.swing.JButton freezeTimeButton1;
    private javax.swing.JButton freezeTimeButton2;
    private javax.swing.JButton freezeTimeButton3;
    private javax.swing.JTextField hourTextField1;
    private javax.swing.JTextField hourTextField2;
    private javax.swing.JTextField hourTextField3;
    private javax.swing.JTextField minTextField1;
    private javax.swing.JTextField minTextField2;
    private javax.swing.JTextField minTextField3;
    private javax.swing.JTextField secTextField1;
    private javax.swing.JTextField secTextField2;
    private javax.swing.JButton setFClockTimeButton;
    private javax.swing.JButton startTimeButton;
    private javax.swing.JButton stopTimeButton1;
    private javax.swing.JButton stopTimeButton2;
    private javax.swing.JButton stopTimeButton3;
    // End of variables declaration//GEN-END:variables
}
