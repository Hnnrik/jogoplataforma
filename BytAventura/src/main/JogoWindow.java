package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class JogoWindow {
  private JFrame jframe;

  public JogoWindow(JogoPanel JogoPanel) {

    jframe = new JFrame();

    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.add(JogoPanel);

    jframe.setResizable(false);
    jframe.pack();
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
    jframe.addWindowFocusListener(new WindowFocusListener() {

      @Override
      public void windowLostFocus(WindowEvent e) {
        JogoPanel.getJogo().windowFocusLost();
      }

      @Override
      public void windowGainedFocus(WindowEvent e) {
        // TODO Auto-generated method stub

      }
    });

  }

}