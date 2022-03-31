package com.example.patterns.proxy.virtual.albumcover.iconproxy;

import java.awt.*;

class IconLoaded extends IconProxyState {
    IconLoaded(IconProxy proxy) {
        super(proxy);
    }

    @Override
    int getIconWidth() {
        return proxy.getTheIconWidth();
    }

    @Override
    int getIconHeight() {
        return proxy.getTheIconHeight();
    }

    @Override
    void paintIcon(Component c, Graphics g, int x, int y) {
        proxy.paintTheIcon(c, g, x, y);
    }
}