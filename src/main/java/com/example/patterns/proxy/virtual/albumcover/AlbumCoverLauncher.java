package com.example.patterns.proxy.virtual.albumcover;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.swing.*;

import com.example.patterns.proxy.virtual.albumcover.iconproxy.IconProxy;

class AlbumCoverLauncher {
    private static final String INITIAL_ALBUM_NAME = "Selected Ambient Works, Vol. 2";

    private Map<String, String> albums;
    private IconComponent iconComponent;
    private JFrame frame;
    
    public static void main (String[] args) { new AlbumCoverLauncher(); }
    
    AlbumCoverLauncher() {
        initializeAlbums();
        initializeIconComponent();
        initializeFrame();
    }

    private void initializeAlbums() {
        albums = new HashMap<>();
        albums.put("Buddha Bar",
            "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        albums.put("Ima",
            "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        albums.put("Karma",
            "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        albums.put("MCMXC a.D.",
            "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        albums.put("Northern Exposure",
            "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        albums.put(INITIAL_ALBUM_NAME,
            "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
    }

    private void initializeIconComponent() {
        URL initialURL = getAlbumUrlBy(INITIAL_ALBUM_NAME);
        Icon initialIcon = new IconProxy(initialURL);
        iconComponent = new IconComponent(initialIcon);
    }

    private URL getAlbumUrlBy(String albumName) {
        try { return new URL(albums.get(albumName)); } 
        catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initializeFrame() {
        frame = new JFrame("Album Cover Viewer");
        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(iconComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(IconProxy.DEFAULT_ICON_WIDTH, 
            IconProxy.DEFAULT_ICON_HEIGHT + 50);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = createFavoriteAlbumsMenu();
        menuBar.add(menu);
        return menuBar;
    }

    private JMenu createFavoriteAlbumsMenu() {
        JMenu menu = new JMenu("Favorite Albums");
        createItemsFor(menu);
        return menu;
    }

    private void createItemsFor(JMenu menu) {
        for (String albumName : albums.keySet()) {
            JMenuItem menuItem = new JMenuItem(albumName);
            menu.add(menuItem); 
            addActionListenerTo(menuItem);
        }
    }

    private void addActionListenerTo(JMenuItem menuItem) {
        menuItem.addActionListener(event -> {
            String albumName = event.getActionCommand();
            URL albumUrl = getAlbumUrlBy(albumName);
            iconComponent.setIcon(new IconProxy(albumUrl));
            frame.repaint();
        });
    }
}