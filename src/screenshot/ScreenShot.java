package screenshot;

/**
 *
 * @author hudson.sales
 */
public class ScreenShot {

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrMain().setVisible(true);
            }
        });
    }
}
