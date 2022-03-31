package com.example.patterns.proxy.virtual.albumcover.iconproxy;

import java.awt.*;

abstract class IconProxyState {
    IconProxy proxy;

    IconProxyState(IconProxy proxy) {
        this.proxy = proxy;
    }

    abstract int getIconWidth();
    abstract int getIconHeight();
    abstract void paintIcon(Component c, Graphics g, int x, int y);
}