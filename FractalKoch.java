import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalKoch extends JPanel {
    private int depth;

    public FractalKoch(int depth) {
        this.depth = depth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawKochSnowflake(g, depth, 100, 200, 500, 200);
    }

    private void drawKochSnowflake(Graphics g, int n, int x1, int y1, int x5, int y5) {
        if (n == 0) {
            g.drawLine(x1, y1, x5, y5);
        } else {
            int deltaX = x5 - x1;
            int deltaY = y5 - y1;

            int x2 = x1 + deltaX / 3;
            int y2 = y1 + deltaY / 3;

            int x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
            int y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

            int x4 = x1 + 2 * deltaX / 3;
            int y4 = y1 + 2 * deltaY / 3;

            drawKochSnowflake(g, n - 1, x1, y1, x2, y2);
            drawKochSnowflake(g, n - 1, x2, y2, x3, y3);
            drawKochSnowflake(g, n - 1, x3, y3, x4, y4);
            drawKochSnowflake(g, n - 1, x4, y4, x5, y5);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal de Koch");
        FractalKoch fractal = new FractalKoch(5); // Cambia la profundidad aquí

        frame.add(fractal);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
