package org.katch.hwidgetter;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static JLabel status = new JLabel();
    private static JPanel panel = new JPanel();
    private static JButton button = new JButton("Copy");
    private static JFrame gui = new JFrame("HWID Getter");

    public void showGui(){
        gui.setVisible(true);
        gui.setSize(HWIDGetter.getHwid().length() * 10 + 100, 100);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);
        gui.add(panel);
        panel.setBackground(Color.black);
        panel.add(status);
        status.setText("Your HWID: " + HWIDGetter.getHwid());
        status.setForeground(Color.lightGray);
        panel.setLayout(null);
        panel.add(button);
        status.setBounds(new Rectangle(new Point(5, 20), status.getPreferredSize()));
        button.setBounds(new Rectangle(new Point(HWIDGetter.getHwid().length() * 10 + 15, 15), button.getPreferredSize()));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(HWIDGetter.getHwid());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                status.setText("Copied to clipboard!");

            }
        });

    }

}
