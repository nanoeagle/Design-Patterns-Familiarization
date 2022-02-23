package com.example.patterns.compound.dj.views;

import java.awt.*;
import javax.swing.*;

import com.example.patterns.compound.dj.controllers.DJController;

public class BeatView extends DJGUI {
    private BeatBar beatBar;
    private JLabel bpmOutputLabel;

    public BeatView(DJController controller) {
        super(controller);
        beatBar = new BeatBar();
        initBpmOutputLabel();
        createFrame(createBpmPanel());
    }

    private void initBpmOutputLabel() {
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
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

    public void setBeatBarValue(int value) {
        beatBar.setValue(value);
    }

    public void setBpmOutputLabelValue(String value) {
        bpmOutputLabel.setText(value);
    }

    public void turnOnBeatBar() {
        beatBar.on();
    }

    public void turnOffBeatBar() {
        beatBar.off();
    }
}