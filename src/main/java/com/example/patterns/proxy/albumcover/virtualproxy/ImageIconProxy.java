package com.example.patterns.proxy.albumcover.virtualproxy;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class ImageIconProxy implements Icon {
    public static final int DEFAULT_ICON_WIDTH = 800;
    public static final int DEFAULT_ICON_HEIGHT = 600;
    
    final URL imageURL;
    ImageIconProxyState imageLoaded;
    ImageIconProxyState imageNotLoaded;
    ImageIconProxyState currentState;
    
    private volatile ImageIcon imageIcon;
 
    public ImageIconProxy(URL imageURL) { 
        this.imageURL = imageURL;
        setInternalStates();
    }
    
    private void setInternalStates() {
        imageLoaded = new ImageLoaded(this);
        imageNotLoaded = new ImageNotLoaded(this);
        currentState = imageNotLoaded;
    }

    synchronized void setImageIcon(ImageIcon imageIcon) 
    throws NullPointerException {
        if (imageIcon == null) 
            throw new NullPointerException("Image icon is null!");
        this.imageIcon = imageIcon;
    }

    ImageIcon getImageIcon() {
        return imageIcon;
    }

    int getImageIconWidth() {
        return imageIcon.getIconWidth();
    }

    int getImageIconHeight() {
        return imageIcon.getIconHeight();
    }

    void paintImageIcon(Component c, Graphics g, int x, int y) {
        imageIcon.paintIcon(c, g, x, y);
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
}