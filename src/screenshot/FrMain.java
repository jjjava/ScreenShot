package screenshot;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hudson.sales
 */
public class FrMain extends javax.swing.JFrame {

    public FrMain() {
        super("ScreenShot");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/image_24.png")));
        this.setLocation(860, 400);
        this.initComponents();
    }

    private BufferedImage cropImage(BufferedImage src, int x1, int y1, int x2, int y2) {
        BufferedImage dest = src.getSubimage(x1, y1, x2, y2);
        return dest;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btStart = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btStart.setText("Start");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        btOpen.setText("Open");
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btStart, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btStart)
                    .addComponent(btOpen))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        this.setVisible(false);
        Robot robot;
        try {
            robot = new Robot();
            robot.delay(300);
            robot.mouseMove(500, 500);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            robot.delay(3000);

            robot.mouseWheel(1);
            robot.delay(500);
            BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            robot.delay(300);

            File file1 = new File("screencapture.png");
            ImageIO.write(cropImage(screencapture, 218, 218, 430, 468), "png", file1);
            // ImageIO.write(screencapture, "png", file);

            robot.delay(500);
            robot.mouseWheel(4);
            robot.delay(300);

            BufferedImage screencapture2 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            robot.delay(300);

            File file2 = new File("screencapture2.png");
            ImageIO.write(cropImage(screencapture2, 218, 280, 430, 470), "png", file2);
            robot.delay(500);

            robot.delay(500);
            robot.mouseWheel(3);
            robot.delay(300);

            BufferedImage screencapture3 = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            robot.delay(300);

            File file3 = new File("screencapture3.png");
            ImageIO.write(cropImage(screencapture3, 218, 446, 430, 85), "png", file3);
            robot.delay(500);

            File file4 = new File("final.png");
            BufferedImage part1 = ImageIO.read(file1);
            BufferedImage part2 = ImageIO.read(file2);
            BufferedImage part3 = ImageIO.read(file3);
            BufferedImage image = new BufferedImage(
                    part1.getWidth(), part1.getHeight() + part2.getHeight() + part3.getHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics2D g2 = image.createGraphics();

            g2.drawImage(part1, 0, 0, null);
            g2.drawImage(part2, 0, part1.getHeight() - 2, null);
            g2.drawImage(part3, 0, part1.getHeight() + part2.getHeight() - 2, null);

            ImageIO.write(image, "png", file4);
            robot.delay(100);

            robot.mouseWheel(-7);
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);

            Runtime.getRuntime().exec("mspaint final.png");
            robot.delay(4000);
            this.setVisible(true);
        } catch (AWTException ex) {
            System.err.println("Can't start Robot: " + ex);
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Can't take a picture: " + ex);
            System.exit(2);
        }
    }//GEN-LAST:event_btStartActionPerformed

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenActionPerformed
        try {
            Runtime.getRuntime().exec("mspaint final.png");
        } catch (IOException ex) {
            System.err.println("Can't open a picture: " + ex);
        }
    }//GEN-LAST:event_btOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btStart;
    // End of variables declaration//GEN-END:variables
}
