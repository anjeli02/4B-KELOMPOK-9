package jtextfield; // Samakan dengan package kamu

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelRounded extends JPanel {
    private int round = 25; // Tingkat kelengkungan

    public PanelRounded() {
        setOpaque(false); // Wajib agar sudut luar tidak berwarna putih
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(getBackground());
        // Menggambar panel yang melengkung
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
        
        g2.dispose();
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }
}