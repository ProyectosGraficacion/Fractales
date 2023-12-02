import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalSierpinski extends JPanel {
    private int depth;

    public FractalSierpinski(int depth) {
        this.depth = depth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSierpinski(g, depth, 400, 50, 50, 750, 750, 750);
    }

    private void drawSierpinski(Graphics g, int n, int x1, int y1, int x2, int y2, int x3, int y3) {
        if (n == 0) {
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x3, y3, x1, y1);
        } else {
            int midX1 = (x1 + x2) / 2;
            int midY1 = (y1 + y2) / 2;
            int midX2 = (x2 + x3) / 2;
            int midY2 = (y2 + y3) / 2;
            int midX3 = (x1 + x3) / 2;
            int midY3 = (y1 + y3) / 2;

            drawSierpinski(g, n - 1, x1, y1, midX1, midY1, midX3, midY3);
            drawSierpinski(g, n - 1, midX1, midY1, x2, y2, midX2, midY2);
            drawSierpinski(g, n - 1, midX3, midY3, midX2, midY2, x3, y3);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal de Sierpinski");
        FractalSierpinski fractal = new FractalSierpinski(5); // Cambia la profundidad aquí

        frame.add(fractal);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

