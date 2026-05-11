package jtextfield;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonRounded extends JButton {
    private int round = 15;
    private Color colorHover = new Color(0, 153, 255); // Warna saat kursor di atas tombol
    private Color colorClick = new Color(0, 102, 204); // Warna saat diklik
    private Color colorNormal;

    public ButtonRounded() {
        colorNormal = getBackground();
        setOpaque(false);
        setContentAreaFilled(false); // Menghilangkan background standar JButton
        setBorderPainted(false);     // Menghilangkan border standar
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Mengubah kursor jadi tangan

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(colorHover);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
        
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (colorNormal == null) colorNormal = bg;
    }
}