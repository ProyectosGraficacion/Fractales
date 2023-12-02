import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FractalJulia extends JPanel {
    private int width, height;
    private BufferedImage image;
    private double zx, zy, cX, cY, tmp;
    private int maxIterations;

    public FractalJulia(int width, int height, int maxIterations) {
        this.width = width;
        this.height = height;
        this.maxIterations = maxIterations;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.cX = -0.7;
        this.cY = 0.27015;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        createJuliaSet();
        g.drawImage(image, 0, 0, this);
    }

    private void createJuliaSet() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                zx = 1.5 * (x - width / 2) / (0.5 * width);
                zy = (y - height / 2) / (0.5 * height);
                int iteration = maxIterations;
                while (zx * zx + zy * zy < 4 && iteration > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iteration--;
                }
                int color = Color.HSBtoRGB((maxIterations / (float) iteration) % 1, 1, 1);
                image.setRGB(x, y, iteration | (color << 8));
            }
        }
    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        int maxIterations = 200;

        JFrame frame = new JFrame("Conjunto de Julia");
        FractalJulia fractal = new FractalJulia(width, height, maxIterations);

        frame.add(fractal);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
