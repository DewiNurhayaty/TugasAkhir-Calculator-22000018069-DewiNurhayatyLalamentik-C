import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JTextField display;
    private double currentResult;
    private String currentOperator;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton source = (JButton) event.getSource();
            String buttonText = source.getText();

            if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
                display.replaceSelection(buttonText);
            } else {
                performOperation(buttonText);
            }
        }

        private void performOperation(String operator) {
            if (currentOperator != null) {
                double value = Double.parseDouble(display.getText());
                switch (currentOperator) {
                    case "+":
                        currentResult += value;
                        break;
                    case "-":
                        currentResult -= value;
                        break;
                    case "*":
                        currentResult *= value;
                        break;
                    case "/":
                        if (value != 0) {
                            // Avoid division by zero
                            currentResult /= value;
                        } else {
                            // Handle division by zero gracefully
                            display.setText("Error");
                            currentResult = 0;
                        }
                        break;
                    case "=":
                        currentResult = value;
                        break;
                }

                if (operator.equals("/") && value != 0) {
                    display.setText(String.valueOf(currentResult));
                } else {
                    display.setText(String.valueOf(Math.round(currentResult)));
                }
            } else {
                currentResult = Double.parseDouble(display.getText());
            }

            if (!operator.equals("=")) {
                currentOperator = operator;
            } else {
                currentOperator = null;
            }

            display.selectAll();
        }
    }
}
