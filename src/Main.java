import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame calculatorFrame = new CalculatorFrame();
            calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calculatorFrame.setVisible(true);
        });
    }
}