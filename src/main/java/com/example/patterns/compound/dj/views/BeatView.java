package com.example.patterns.compound.dj.views;

import java.awt.*;
import javax.swing.*;

public class BeatView {
    private BeatBar beatBar;
    private BpmOutputLabel bpmOutputLabel;

    public BeatView() {
        beatBar = new BeatBar();
        initBpmOutputLabel();
        createFrame(createBpmPanel());
    }

    private void initBpmOutputLabel() {
        bpmOutputLabel = new BpmOutputLabel("offline", SwingConstants.CENTER);
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private JPanel createBpmPanel() {
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        return bpmPanel;
    }

    private void createFrame(JPanel panel) {
        JFrame frame = new JFrame("Beat View");
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 100);
        frame.setLocation(630, 200);
        frame.setVisible(true);
    }

    public Observer getBeatObserver() {
        return beatBar;
    }

    public Observer getBpmObserver() {
        return bpmOutputLabel;
    }

    public void turnOn() {
        beatBar.on();
    }

    public void turnOff() {
        beatBar.off();
        bpmOutputLabel.setText("offline");
    }
}