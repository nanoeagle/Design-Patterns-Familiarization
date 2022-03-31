package com.example.patterns.proxy.virtual.albumcover.iconproxy;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class IconProxy implements Icon {
    public static final int DEFAULT_ICON_WIDTH = 800;
    public static final int DEFAULT_ICON_HEIGHT = 600;
    
    final URL iconURL;
    IconProxyState iconNotLoaded;
    IconProxyState iconLoaded;
    IconProxyState currentState;
    
    private volatile Icon icon;
 
    public IconProxy(URL iconURL) { 
        this.iconURL = iconURL;
        setInternalStates();
    }
    
    private void setInternalStates() {
        iconNotLoaded = new IconNotLoaded(this);
        iconLoaded = new IconLoaded(this);
        currentState = iconNotLoaded;
    }

    @Override
    public int getIconWidth() {
        return currentState.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return currentState.getIconHeight();
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        currentState.paintIcon(c, g, x, y);
    }

    synchronized void setIcon(Icon icon) 
    throws NullPointerException {
        if (icon == null) throw new NullPointerException("Icon is null!");
        this.icon = icon;
    }

    Icon getIcon() {
        return icon;
    }

    int getTheIconWidth() {
        return icon.getIconWidth();
    }

    int getTheIconHeight() {
        return icon.getIconHeight();
    }

    void paintTheIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c, g, x, y);
    }
}