import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{

    private JLabel title;
    private JLabel racketBall;
    private JLabel start;


    public MainMenu(){

        //-------------------------------------title--------------------------------------//

        title = new JLabel("Ping Pong");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Segoe Print", Font.PLAIN, 120));
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(1000, 350));

        //-------------------------------------racketBall---------------------------------//

        racketBall = new JLabel(new ImageIcon("lib/racketBall.png"));
        racketBall.setPreferredSize(new Dimension(250, 150));

        //--------------------------------------start------------------------------------//

        start = new JLabel("Click anywhere to start the game");
        start.setPreferredSize(new Dimension(1000, 100));
        start.setFont(new Font("Segoe Print", Font.PLAIN, 25));
        start.setHorizontalAlignment(SwingConstants.CENTER);
        
        //--------------------------------------main menu stuff----------------------------//

        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1000, 750));

        this.add(title);
        this.add(racketBall);
        this.add(start);


    }

}
