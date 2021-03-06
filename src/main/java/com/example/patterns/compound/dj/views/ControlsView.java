package com.example.patterns.compound.dj.views;

import java.awt.*;

import javax.swing.*;

import com.example.patterns.compound.dj.controllers.DJController;
import com.example.patterns.compound.dj.models.Bpm;

public class ControlsView {
    private DJController djController;
    private JButton setBpmBtn;
    private JButton increaseBpmBtn;
    private JButton decreaseBpmBtn;
    private JMenuItem startMenuItem;
    private JMenuItem stopMenuItem;
    private JTextField bpmTextField;
    
    public ControlsView(DJController djController) {
        this.djController = djController;
        initButtons();
        createFrame();
    }

    private void initButtons() {
        setBpmBtn = new JButton("Set");
        setBpmBtn.addActionListener(e -> djController.setBpm());
        increaseBpmBtn = new JButton(">>");
        increaseBpmBtn.addActionListener(e -> djController.increaseBpm());
        decreaseBpmBtn = new JButton("<<");
        decreaseBpmBtn.addActionListener(e -> djController.decreaseBpm());
    }

    private void createFrame() {
        JFrame frame = new JFrame("Controls View");
        frame.setJMenuBar(createMenuBar());
        frame.getContentPane().add(createControlsPanel(), BorderLayout.CENTER);
        frame.getRootPane().setDefaultButton(setBpmBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocation(300, 200);
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        startMenuItem = new JMenuItem("Start");
        startMenuItem.addActionListener(e -> djController.play());
        stopMenuItem = new JMenuItem("Stop");
        stopMenuItem.addActionListener(e -> djController.stop());
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(e -> System.exit(0));

        JMenu menu = new JMenu("DJ Control");
        menu.add(startMenuItem);
        menu.add(stopMenuItem);
        menu.add(exit);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createControlsPanel() {
        JPanel controlsPanel = new JPanel(new GridLayout(3, 1));
        controlsPanel.add(createBpmInputPanel());
        controlsPanel.add(setBpmBtn);
        controlsPanel.add(createFrequencyControlsPanel());
        return controlsPanel;
    }

    private JPanel createBpmInputPanel() {
        JLabel bpmInputLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        bpmInputLabel.setBorder(BorderFactory.createEmptyBorder(5 ,5 ,5 ,5));
        bpmTextField = new JTextField(2);
        
        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmInputLabel);
        enterPanel.add(bpmTextField);
        return enterPanel;
    }
    
    private JPanel createFrequencyControlsPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(decreaseBpmBtn);
        buttonPanel.add(increaseBpmBtn);
        return buttonPanel;
    }

    public int getBpmInputValue() {
        int bpm = Bpm.DEFAULT_VALUE;
        try { 
            int inputValue = Integer.parseInt(bpmTextField.getText());
            if (inputValue > 0) bpm = inputValue;
        } catch (RuntimeException e) { e.printStackTrace(); }
        bpmTextField.setText("");
        return bpm;
    }

    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }

    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

    public void enableSetBpmBtn() {
        setBpmBtn.setEnabled(true);
    }

    public void disableSetBpmBtn() {
        setBpmBtn.setEnabled(false);
    }

    public void enableIncreaseBpmBtn() {
        increaseBpmBtn.setEnabled(true);
    }

    public void disableIncreaseBpmBtn() {
        increaseBpmBtn.setEnabled(false);
    }

    public void enableDecreaseBpmBtn() {
        decreaseBpmBtn.setEnabled(true);
    }

    public void disableDecreaseBpmBtn() {
        decreaseBpmBtn.setEnabled(false);
    }
}