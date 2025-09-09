package Ball_Worlds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallWorld extends JFrame {

    public static final int FrameWidth = 600;
    public static final int FrameHeight = 400;

    private Ball aBall;
    private int counter = 0;

    public BallWorld (Color ballColor) {
        setSize(FrameWidth, FrameHeight);
        setTitle("Ball World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aBall = new Ball(100, 100, 20, ballColor);
        aBall.setMotion(3.0, 4.0);

        BallPanel panel = new BallPanel();
        panel.setPreferredSize(new Dimension(FrameWidth, FrameHeight));
        add(panel);
        pack();
        setLocationRelativeTo(null);

        Timer timer = new Timer(16, e -> {
            if(panel.getWidth() > 0 && panel.getHeight() > 0){
                aBall.move(panel.getWidth(), panel.getHeight());
            }
            panel.repaint();

            counter++;
            if (counter >= 2000) {
                System.out.println("Fim da simulação após " + counter + " frames.");
                System.exit(0);
            }
        });
        timer.start();
    }

    private class BallPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
        }
        
    }

    public static void main(String[] args) {
        BallWorld world = new BallWorld(Color.RED);
        world.setVisible(true);
    }
}

class Ball{
    private double x, y;
    private int radius;
    private Color color;
    private double dx, dy;

    public Ball(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void setColor(Color c){
        this.color = c;
    }

    public void setMotion(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void move(int width, int height){
        x += dx;
        y += dy;

        if (x < 0 || x + radius > width){
            dx = -dx;
        }

        if (y < 0 || y + radius > height){
            dy = -dy;
        }
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        int drawX = (int) Math.round(x - radius);
        int drawY = (int) Math.round(y - radius);

        int diameter = radius * 2;
        g2d.fillOval(drawX, drawY, drawY, diameter);
    }

}
