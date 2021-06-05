package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    final JButton[] button = new JButton[20];
    final String[] liter = {"C", "<", "SQ", "%", "1", "2", "3", "--", "4", "5",
            "6", "+", "7", "8", "9", "/", "0", ".", "=", "*"};
    final Font font = new Font("SanSerif", Font.BOLD, 20);
    final JTextField screen = new JTextField();

    public Panel() {
        setLayout(null);
        screen.setBounds(10, 10, 310, 70);
        screen.setEditable(false);
        screen.setFont(font);
        add(screen);
        int i = 0;
        for (int y = 90; y <= 410; y += 80) {
            for (int x = 10; x <= 250; x += 80) {
                button[i] = new JButton(liter[i]);
                button[i].setBounds(x, y, 70, 70);
                button[i].setFont(font);
                add(button[i]);
                i++;
            }
        }
        ActionListener num = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            screen.setText(screen.getText() + b.getText());
        };
        int[] pos_num = {4, 5, 6, 8, 9, 10, 12, 13, 14, 16};
        for (int p : pos_num) {
            button[p].addActionListener(num);
        }
        ActionListener serv = (ActionEvent e) -> {
//            нажатие клавиши "сброс"
            if (e.getSource() == button[0]) {
                screen.setText(null);
            }
//            нажатие клавиши "стирание справа"
            if (e.getSource() == button[1]) {
                String str = screen.getText();
                if (str.length() > 0) {
                    screen.setText(str.substring(0, str.length() - 1));
                }
            }
//            нажатие клавиши "десятичная точка"
            if(e.getSource()==button[17]){
                String str = screen.getText();
                if (str.length()==0){
                    screen.setText("0.");
                }
                else if(! str.contains(".")){
                    screen.setText(str+".");
                }
            }
        };
        int[] pos_serv = {0, 1, 2, 3, 7, 11, 15, 17, 18, 19};
        for (int p : pos_serv) {
            button[p].addActionListener(serv);
        }
    }
}


