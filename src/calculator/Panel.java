package calculator;

import javax.swing.*;

public class Panel extends JPanel {
    final JButton[] number = new JButton[10];

    public Panel() {
        setLayout(null);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                number[x * 3 + y + 1] = new JButton("" + (x * 3 + y + 1));
                number[x * 3 + y + 1].setBounds(y * 80 + 10, x * 80 + 90, 70, 70);
                add(number[x * 3 + y + 1]);
            }
        }
    }
}
