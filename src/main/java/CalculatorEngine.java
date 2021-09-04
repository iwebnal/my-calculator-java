import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    SimpleCalculator parent; // Ссылка на SimpleCalculator (на окно калькулятора)

    char selectedAction = ' '; // +, -, / или *
    double currentResult = 0;

    CalculatorEngine(SimpleCalculator parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

        // Получить текущий текст из поля вывода (“дисплея”)
        // калькулятора
        String dispFieldText = parent.displayField.getText();


            double displayValue = 0;

            // Получить число из дисплея калькулятора,
            // если он не пустой
            if(!"".equals(dispFieldText)) {
                displayValue = Double.parseDouble(dispFieldText);
            }

            Object src = e.getSource();

            if(src == parent.buttonPlus) {
                selectedAction = '+';
                currentResult = displayValue;
                parent.displayField.setText("");
            } else if(src == parent.buttonMinus) {
                selectedAction = '-';
                currentResult = displayValue;
                parent.displayField.setText("");
            } else if(src == parent.buttonDivide) {
                selectedAction = '/';
                currentResult  = displayValue;
                parent.displayField.setText("");
            } else if(src == parent.buttonMultiply) {
                selectedAction = '*';
                currentResult = displayValue;
                parent.displayField.setText("");
            } else if (src == parent.buttonClear) {
                selectedAction = 'C';
                parent.displayField.setText("");
            } else if(src == parent.buttonPoint) {
                selectedAction = '0';
                currentResult = 0;
                parent.displayField.setText("");
            } else if(src == parent.buttonEqual) {
                // Совершить арифметическое действие, в зависимости
                // от selectedAction, обновить переменную currentResult
                // и показать результат на дисплее
                if(selectedAction == '+') {
                    currentResult += displayValue;
                    // Сконвертировать результат в строку, добавляя его
                    // к пустой строке и показать его
                    parent.displayField.setText("" + currentResult);
                } else if(selectedAction == '-') {
                    currentResult -= displayValue;
                    parent.displayField.setText("" + currentResult);
                } else if(selectedAction == '/') {
                    if(displayValue == 0) {
                        // Добавляем надпись на кнопке к тексту окна сообщения
                        JOptionPane.showConfirmDialog(
                                null,
                                "You can't divide by zero!",
                                "Information window",
                                JOptionPane.PLAIN_MESSAGE
                        );
                        parent.displayField.setText("");
                        return;
                    }
                    currentResult /= displayValue;
                    parent.displayField.setText("" + currentResult);
                } else if(selectedAction == '*') {
                    currentResult *= displayValue;
                    parent.displayField.setText("" + currentResult);
                } else if(src == parent.buttonClear) {
                    parent.displayField.setText("");
                }
            } else {
                // Получаем надпись на кнопке
                String clickedButtonLabel = clickedButton.getText();
                parent.displayField.setText(dispFieldText + clickedButtonLabel);
            }
        }

    }
