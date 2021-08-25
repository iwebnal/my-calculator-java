import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class SimpleCalculator {

    // Объявление всех компонентов калькулятора.
    JPanel windowContent;
    JTextField displayField;
    JButton button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, buttonPoint, buttonEqual;
    JPanel pl;

    SimpleCalculator() {
        // Создаём панель
        windowContent = new JPanel();

        // Задаём схему для этой панели
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // Создаём и отображаем поле
        // Добавляем его в Северную область окна
        displayField = new JTextField(30);
        windowContent.add("North", displayField);

        // Создаём кнопки, используя конструктор
        // класса JButton, который принимает текст
        // кнопки в качестве параметра
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");

        // Создаём панель с GridLayout
        // которая содержит 12 кнопок - 10 кнопок с числами
        // и кнопки с точкой и знаком равно
        pl = new JPanel();
        GridLayout gl = new GridLayout(4,3);
        pl.setLayout(gl);

        // Добавляем кнопки на панель p1
        pl.add(button0);
        pl.add(button1);
        pl.add(button2);
        pl.add(button3);
        pl.add(button4);
        pl.add(button5);
        pl.add(button6);
        pl.add(button7);
        pl.add(button8);
        pl.add(button9);
        pl.add(buttonPoint);
        pl.add(buttonEqual);

        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", pl);

        //Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);

        // делаем размер окна достаточным
        // для того, чтобы вместить все компоненты
        frame.pack();

        // отображаем окно
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        // навешиваем событие на кнопки
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
    }
}
