package ata.driverdisplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Main {

    public static void main(String[] args) {
        JFrame main = new JFrame("Driver Display");
        main.setLayout(new GridLayout(6, 3));
        main.setSize(500, 600);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);

        final JLabel[] labels = {new JLabel("1"), new JLabel("2"), new JLabel("3")};
        for (JLabel label : labels) {
            label.setFont(new Font(null, Font.PLAIN, 45));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            main.add(label);
        }

        final JButton[][] buttons = {
            {new JButton(), new JButton(), new JButton(),},
            {new JButton(), new JButton(), new JButton(),},
            {new JButton(), new JButton(), new JButton(),}
        };

        for (JButton b : buttons[0]) {
            b.setBackground(Color.blue);
        }
        for (JButton b : buttons[1]) {
            b.setBackground(Color.white);
        }
        for (JButton b : buttons[2]) {
            b.setBackground(Color.red);
        }

        for (JButton[] b : buttons) {
            for (final JButton b1 : b) {
                b1.setFont(new Font(null, Font.PLAIN, 45));
                b1.setForeground(Color.black);
                b1.setFocusable(false);
                b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        b1.setText("X");
                        check(buttons);
                    }
                });
                main.add(b1);
            }
        }

        final JButton truss = new JButton("Truss");
        truss.setBackground(Color.black);
        truss.setFocusable(false);
        truss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                truss.setBorder(new LineBorder(Color.yellow, 12));
            }
        });

        final JButton catc = new JButton("Catch");
        catc.setBackground(Color.black);
        catc.setFocusable(false);
        catc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catc.setBorder(new LineBorder(Color.yellow, 12));
            }
        });

        main.add(truss);
        main.add(new JLabel());
        main.add(catc);

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (JButton[] b : buttons) {
                    for (final JButton b1 : b) {
                        b1.setText("");
                        b1.setBorder(null);
                    }
                }
                truss.setBorder(null);
                catc.setBorder(null);
            }
        });

        main.add(new JLabel());
        main.add(reset);
        main.setVisible(true);
    }

    static void check(JButton[][] buttons) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                if (buttons[i][x].getText().equals("X") && !a.contains(x)) {
                    a.add(x);
                    break;
                }
            }
        }
        if (a.size() == 3) {
            for (int x = 0; x < 3; x++) {
                buttons[x][a.get(x)].setBorder(new LineBorder(Color.yellow, 12));
            }
        }
    }
}
