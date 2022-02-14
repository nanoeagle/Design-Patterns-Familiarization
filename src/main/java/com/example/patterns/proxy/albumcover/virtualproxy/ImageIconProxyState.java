package com.example.patterns.proxy.albumcover.virtualproxy;

import java.awt.*;

abstract class ImageIconProxyState {
    ImageIconProxy proxy;

    ImageIconProxyState(ImageIconProxy proxy) {
        this.proxy = proxy;
    }

    abstract int getIconWidth();
    abstract int getIconHeight();
    abstract void paintIcon(Component c, Graphics g, int x, int y);
}