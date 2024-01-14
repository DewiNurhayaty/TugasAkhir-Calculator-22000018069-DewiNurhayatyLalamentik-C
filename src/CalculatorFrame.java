import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Simple Calculator");
        setLayout(new BorderLayout());

        CalculatorPanel calculatorPanel = new CalculatorPanel();
        add(calculatorPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
}