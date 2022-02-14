package com.example.patterns.proxy.albumcover.virtualproxy;

import java.awt.*;

import javax.swing.ImageIcon;

class ImageNotLoaded extends ImageIconProxyState {
    private boolean isRetrievingImageIcon;

    ImageNotLoaded(ImageIconProxy proxy) {
        super(proxy);
    }

    @Override
    int getIconWidth() {
        return ImageIconProxy.DEFAULT_ICON_WIDTH;
    }

    @Override
    int getIconHeight() {
        return ImageIconProxy.DEFAULT_ICON_HEIGHT;
    }

    @Override
    void paintIcon(Component c, Graphics g, int x, int y) {
        if ( !isRetrievingImageIcon ) {
            isRetrievingImageIcon = true;
            g.drawString("Loading album cover, please wait...", x + 300, y + 190);
            retrieveImageIconIfNotDoingIt(c);
        }
    }

    private void retrieveImageIconIfNotDoingIt(Component c) {
        Thread retrievalThread = new Thread(() -> {
            try {
                proxy.setImageIcon(new ImageIcon(proxy.imageURL, "Album Cover"));
                proxy.currentState = proxy.imageLoaded;
                c.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        retrievalThread.start();
    }
}