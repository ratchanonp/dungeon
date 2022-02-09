package com.dungeon;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;

    private BufferedImage img;
    private Graphics2D g;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if(thread == null){
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init() {
        running = true;

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
    }


    public void run() {
        init();

        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000; // Time Before Update

        final int MUBR = 5; // Must Update Before Render
        double lastUpdate = System.nanoTime();


        while (running) {
            update();
            render();
            draw();
        }
    }

    public void update() {}

    public void render(){
        if(g != null){
            g.setColor(new Color(0,0,0));
            g.fillRect(0,0,width,height);
        }
    }

    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0,0,null);
        g2.dispose();
    }
}
