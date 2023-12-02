import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DragonCurve extends JPanel {
    private int order;
    
    public DragonCurve(int order) {
        this.order = order;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDragonCurve(g, order, 100, 200, 400, 200);
    }
    
    private void drawDragonCurve(Graphics g, int order, int x1, int y1, int x2, int y2) {
        if (order == 0) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            
            int dx = y2 - y1;
            int dy = x1 - x2;
            
            int x3 = midX + dx / 2;
            int y3 = midY + dy / 2;
            
            drawDragonCurve(g, order - 1, x1, y1, x3, y3);
            drawDragonCurve(g, order - 1, x2, y2, x3, y3);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dragon Curve");
        DragonCurve dragonCurve = new DragonCurve(10); // Cambia el valor para cambiar el orden del fractal
        
        frame.add(dragonCurve);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

