package ru.fantasy.client;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class application {
    public static void main(String[] args) {
 //       try {
   //         UIManager.setLookAndFeel(new NimbusLookAndFeel());
     //   } catch (UnsupportedLookAndFeelException e) {
       //     System.out.println("Error: NimbusLookAndFeel");
      //  }
        MainFrame frame = new MainFrame();
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
