package com.example.patterns.proxy.albumcover.virtualproxy;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class ImageIconProxy implements Icon {
    public static final int DEFAULT_ICON_WIDTH = 800;
    public static final int DEFAULT_ICON_HEIGHT = 600;

    private final URL imageURL;
    private volatile ImageIcon imageIcon;
    private boolean isRetrievingImageIcon;
 
    public ImageIconProxy(URL imageURL) { this.imageURL = imageURL; }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) return imageIcon.getIconWidth();
        return DEFAULT_ICON_WIDTH;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) return imageIcon.getIconHeight();
        return DEFAULT_ICON_HEIGHT;
    }

    public synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) imageIcon.paintIcon(c, g, x, y);
        else {
            g.drawString("Loading album cover, please wait...", x + 300, y + 190);
            retrieveImageIconIfNotDoingIt(c, g, x, y);
        }
    }

    private void retrieveImageIconIfNotDoingIt(Component c, Graphics g, int x, int y) {
        if ( !isRetrievingImageIcon ) {
            isRetrievingImageIcon = true;
            new Thread(() -> {
                try {
                    setImageIcon(new ImageIcon(imageURL, "Album Cover"));
                    c.repaint();
                } catch (Exception e) {
                    g.drawString("Errors occur, can not load album cover.", x + 300, y + 190);
                    e.printStackTrace();
                }
            }).start();
        }
    }
}