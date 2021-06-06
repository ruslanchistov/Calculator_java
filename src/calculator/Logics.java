package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Logics extends JPanel {
    private static Double number_1, number_2, result;
    private static String str_1, str_2, str;

    public Logics() {
        Logics.add_num();
        Logics.serv_button();
        Logics.operators();
    }
//  функция получения чисел из строки с экрана
    private static String before_calc() {
        Logics.str_1 = "";
        Logics.str_2 = "";
        Logics.str = Panel.screen.getText();
        int pos_operate = 0;
        String op;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '/' && str.charAt(i) != '*' && str.charAt(i) != '-' && str.charAt(i) != '+') {
                str_1 += str.charAt(i);
                pos_operate = i + 1;
            } else {
                break;
            }
        }
        str_2 = str.substring(pos_operate + 1);
        op = "" + str.charAt(pos_operate);
        number_1 = Double.parseDouble(str_1);
        number_2 = Double.parseDouble(str_2);
        return op;
    }

    //  функция вычисления арифметических операций
    private static void calculation() {
        String op = Logics.before_calc();
        Map<String, Double> map = new HashMap<>() {{
            put("/", number_1 / number_2);
            put("*", number_1 * number_2);
            put("-", number_1 - number_2);
            put("+", number_1 + number_2);
        }};

        result = map.get(op);
        Panel.screen.setText(null);
        Panel.screen.setText("" + result);
    }

    //  функция извлечения квадратного корня
    private static void sqr() {
        Logics.str = Panel.screen.getText();
        if (str.length() > 0) {
            Logics.number_1 = Double.parseDouble(str);
            if (Logics.number_1 >= 0) {
                Logics.result = Math.sqrt(number_1);
                Panel.screen.setText(null);
                Panel.screen.setText("" + result);
            } else {
                Panel.screen.setText(null);
                Panel.screen.setText("ERROR");
            }
        }
    }

    //  функция арифметических клавиш
    private static void operators() {
        ActionListener operate = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            Logics.str = Panel.screen.getText();
            if (str.length() > 0) {
                if (!str.contains("-") && !str.contains("+") && !str.contains("/") && !str.contains("*")) {
                    Panel.screen.setText(Panel.screen.getText() + b.getText());
                } else {
                    Logics.calculation();
                }
            }
        };
        int[] pos_num = {7, 11, 15, 19};
        for (int p : pos_num) {
            Panel.button[p].addActionListener(operate);
        }
    }

    //  функция клавиши удаление справа
    private static void backspace() {
        Logics.str = Panel.screen.getText();
        if (str.length() > 0) {
            Panel.screen.setText(str.substring(0, str.length() - 1));
        }
    }

    //  функция клавиши "точка"
    private static void dec_point() {
        Logics.str = Panel.screen.getText();
        if (str.length() == 0) {
            Panel.screen.setText("0.");
        } else if (!str.contains(".")) {
            Panel.screen.setText(str + ".");
        }
    }

    //  функция обработки цифровых клавиш
    private static void add_num() {
        ActionListener num = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            Panel.screen.setText(Panel.screen.getText() + b.getText());
        };
        int[] pos_num = {4, 5, 6, 8, 9, 10, 12, 13, 14, 16};
        for (int p : pos_num) {
            Panel.button[p].addActionListener(num);
        }
    }

    //  функция обработки сервисных клавиш
    private static void serv_button() {
        ActionListener serv = (ActionEvent e) -> {
//            нажатие клавиши "сброс"
            if (e.getSource() == Panel.button[0]) {
                Panel.screen.setText(null);
            }
//            нажатие клавиши "стирание справа"
            if (e.getSource() == Panel.button[1]) {
                Logics.backspace();
            }
//            нажатие клавиши "десятичная точка"
            if (e.getSource() == Panel.button[17]) {
                Logics.dec_point();
            }
//            нажатие клавиши "квадратный корень"
            if (e.getSource() == Panel.button[2]) {
                Logics.sqr();
            }
//            нажатие клавиши "равно"
            if (e.getSource() == Panel.button[18]) {
                Logics.calculation();
            }
            if (e.getSource() == Panel.button[3]) {
                Logics.percent();
            }
        };
        // массив номеров сервисных клавиш
        int[] pos_serv = {0, 1, 2, 3, 7, 11, 15, 17, 18, 19};
        for (int p : pos_serv) {
            Panel.button[p].addActionListener(serv);
        }
    }

    //  функция вычисления процентов
    private static void percent() {
        str = Panel.screen.getText();
        int last_symbol = str.length() - 1;
        if (str.length() > 0 &&
                (str.contains("-") || str.contains("+") || str.contains("/") || str.contains("*")) &&
                (str.charAt(last_symbol) != '/' && str.charAt(last_symbol) != '*' &&
                        str.charAt(last_symbol) != '-' && str.charAt(last_symbol) != '+')) {
            String op = Logics.before_calc();
            Map<String, Double> map = new HashMap<>() {{
                put("/", number_1 / number_2 * 100);
                put("*", number_1 * number_2 / 100);
                put("-", number_1 - number_1 * number_2 / 100);
                put("+", number_1 + number_1 * number_2 / 100);
            }};
            result = map.get(op);
            Panel.screen.setText(null);
            Panel.screen.setText("" + result);
        }
    }
}


