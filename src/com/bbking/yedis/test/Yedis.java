package com.bbking.yedis.test;

import javax.swing.*;
import java.awt.*;

public class Yedis extends JFrame {
    public void drawFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("大宝,生日快乐");
        this.setLocation(200, 200);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.MAGENTA);
        JLabel jLabel = new JLabel("I love you,baby!");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(jLabel);
        this.setResizable(true);
        this.pack();
    }

    public static void main(String[] args) {
        Yedis yedis = new Yedis();
        yedis.drawFrame();
    }
}
