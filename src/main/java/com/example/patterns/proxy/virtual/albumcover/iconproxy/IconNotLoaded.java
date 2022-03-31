package com.example.patterns.proxy.virtual.albumcover.iconproxy;

import java.awt.*;

import javax.swing.ImageIcon;

class IconNotLoaded extends IconProxyState {
    private boolean isRetrievingIcon;

    IconNotLoaded(IconProxy proxy) {
        super(proxy);
    }

    @Override
    int getIconWidth() {
        return IconProxy.DEFAULT_ICON_WIDTH;
    }

    @Override
    int getIconHeight() {
        return IconProxy.DEFAULT_ICON_HEIGHT;
    }

    @Override
    void paintIcon(Component c, Graphics g, int x, int y) {
        if ( !isRetrievingIcon ) {
            isRetrievingIcon = true;
            g.drawString("Loading album cover, please wait...", x + 300, y + 190);
            retrieveIconWhenNotDoingIt(c);
        }
    }

    private void retrieveIconWhenNotDoingIt(Component c) {
        Thread retrievalThread = new Thread(() -> {
            try {
                proxy.setIcon(new ImageIcon(proxy.iconURL, "Album Cover"));
                proxy.currentState = proxy.iconLoaded;
                c.repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        retrievalThread.start();
    }
}