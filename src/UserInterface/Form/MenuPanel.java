package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;

public class MenuPanel extends JPanel {
    public  PatButton   
            btnHome     = new PatButton("Home"),
            // btnLogin    = new PatButton("Login"),
            btnClasificacion     = new PatButton("Clasificacion");
            // btnExobot= new PatButton("Exobot");
            // btnTest     = new PatButton("btnTest");

    public MenuPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        // add-logo
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add-botones
        add(btnHome);
        // add(btnLogin);
        add(btnClasificacion);
        // add(btnExobot);
        // add(btnTest);

        // add-copyright
        add(new JLabel("\u00A9 ANTBOT_Programacion II"));
    }
}
