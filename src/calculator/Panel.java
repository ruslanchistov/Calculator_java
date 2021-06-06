package calculator;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
//    создаём массив клавиш калькулятора
    static final JButton[] button = new JButton[20];
    final String[] liter = {"C", "<", "SQ", "%", "1", "2", "3", "-", "4", "5",
            "6", "+", "7", "8", "9", "/", "0", ".", "=", "*"};
    final Font font = new Font("SanSerif", Font.BOLD, 20);
    static final JTextField screen = new JTextField();

    public Panel() {
//        отрисовываем клавиши и экран на панель
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
//        добавляем клавишам логику работы
        add(new Logics());
    }
}


