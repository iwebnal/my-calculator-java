import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    SimpleCalculator parent; // Ссылка на SimpleCalculator

    CalculatorEngine(SimpleCalculator parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        JTextField myDisplayField = null;
        JButton clickedButton = null;

        Object eventSource = e.getSource();

        if(eventSource instanceof JButton) {
            // Получаем источник события (текущего действия)
            // Приводим тип возвращаемого Object к
            // типу JButton, размещая тип в скобках перед именем метода
            clickedButton = (JButton) eventSource;
        }else if(eventSource instanceof JTextField) {
            myDisplayField = (JTextField) eventSource;
        }

        // Получаем надпись на кнопке
        String clickedButtonLabel = clickedButton.getText();

        // Получить текущий текст из поля вывода (“дисплея”)
        // калькулятора
        String dispFieldText = parent.displayField.getText();

        parent.displayField.setText(dispFieldText + clickedButtonLabel);

        // Добавляем надпись на кнопке к тексту окна сообщения
        JOptionPane.showConfirmDialog(
                null,
                "You pressed " +
                clickedButtonLabel,
                "Just a test",
                JOptionPane.PLAIN_MESSAGE
        );
    }

}
