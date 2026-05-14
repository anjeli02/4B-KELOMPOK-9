package View; // harus sama dengan package DataKaryawan

import java.awt.*;
import javax.swing.*;

public class WrapLayout extends FlowLayout {
    public WrapLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        return layoutSize(target, true);
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return layoutSize(target, false);
    }

    private Dimension layoutSize(Container target, boolean preferred) {
        synchronized (target.getTreeLock()) {
            int targetWidth = target.getSize().width;
            if (targetWidth == 0) targetWidth = Integer.MAX_VALUE;

            int hgap = getHgap();
            int vgap = getVgap();
            Insets insets = target.getInsets();
            int maxWidth = targetWidth - (insets.left + insets.right + hgap * 2);

            int x = 0, y = insets.top + vgap, rowHeight = 0;

            for (int i = 0; i < target.getComponentCount(); i++) {
                Component c = target.getComponent(i);
                if (!c.isVisible()) continue;
                Dimension d = preferred ? c.getPreferredSize() : c.getMinimumSize();
                if (x + d.width > maxWidth && x > 0) {
                    y += rowHeight + vgap;
                    x = 0;
                    rowHeight = 0;
                }
                x += d.width + hgap;
                rowHeight = Math.max(rowHeight, d.height);
            }
            y += rowHeight + vgap + insets.bottom;
            return new Dimension(targetWidth, y);
        }
    }
}