package calculator;

import javax.swing.*;

public class Window {
    public static void main(String[] args) {
//        создаём окно калькулятора
        JFrame window = new JFrame("Калькулятор");
        window.setSize(345, 530);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
//        добавляем панель с клавишами в наше окно
        window.add(new Panel());
    }
}

