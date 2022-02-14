package com.example.patterns.proxy.albumcover.virtualproxy;

import java.awt.*;

class ImageLoaded extends ImageIconProxyState {
    ImageLoaded(ImageIconProxy proxy) {
        super(proxy);
    }

    @Override
    int getIconWidth() {
        return proxy.getImageIconWidth();
    }

    @Override
    int getIconHeight() {
        return proxy.getImageIconHeight();
    }

    @Override
    void paintIcon(Component c, Graphics g, int x, int y) {
        proxy.paintImageIcon(c, g, x, y);
    }
}