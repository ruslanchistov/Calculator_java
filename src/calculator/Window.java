package calculator;

import javax.swing.*;

public class Window {
    public static void main(String[] args) {
        JFrame window = new JFrame("Калькулятор");
        window.setSize(400, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(new Panel());
    }

}
