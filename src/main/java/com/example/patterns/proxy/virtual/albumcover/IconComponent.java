package com.example.patterns.proxy.virtual.albumcover;

import static com.example.patterns.proxy.virtual.albumcover.iconproxy.IconProxy.*;

import java.awt.Graphics;

import javax.swing.*;

class IconComponent extends JComponent {
    private Icon icon;

    public IconComponent(Icon icon) {
        this.icon = icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int x = (DEFAULT_ICON_WIDTH - iconWidth) / 2;
        int y = (DEFAULT_ICON_HEIGHT - iconHeight) / 2;
        icon.paintIcon(this, g, x, y);
    }
}