package com.dungeon;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280,720));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
