import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Game extends JPanel implements ActionListener{

    private Random random;
    private Timer timer;
    private Timer countDown;

    private JLabel blueRacket;
    private JLabel redRacket;
    private JLabel ball;

    private int ballX = 485;
    private int ballY = 360;
    private int vX;
    private int vY;

    private JLabel counter;
    private int count = 4;

    private int blueScore;
    private int redScore;
    private JLabel bScore;
    private JLabel rScore;
    

    public Game(){

        random = new Random();
        timer = new Timer(10, this);
        vX = 6;

        //-------------------------------------blue racket---------------------------------//

        blueRacket = new JLabel();
        blueRacket.setOpaque(true);
        blueRacket.setBackground(Color.BLUE);
        blueRacket.setSize(25, 100);
        blueRacket.setLocation(0, 325);

        //-------------------------------------red racket----------------------------------//

        redRacket = new JLabel();
        redRacket.setOpaque(true);
        redRacket.setBackground(Color.RED);
        redRacket.setSize(25, 100);
        redRacket.setLocation(975, 325);

        //---------------------------------------ball--------------------------------------//

        ball = new JLabel(new ImageIcon("lib/ball.png"));
        ball.setSize(30, 30);
        ball.setLocation(ballX, ballY);

        //--------------------------------------count down timer--------------------------//

        countDown = new Timer(1000, this);
        counter = new JLabel("3");

        countDown.setInitialDelay(0);
        countDown.setRepeats(true);

        counter.setFont(new Font(null, Font.PLAIN, 80));
        counter.setBounds(0, 0, 1000, 250);
        counter.setHorizontalAlignment(SwingConstants.CENTER);
        counter.setForeground(Color.WHITE);

        //-------------------------------------score stuff---------------------------------//

        bScore = new JLabel(String.valueOf(blueScore));
        rScore = new JLabel(String.valueOf(redScore));

        bScore.setBounds(400, 0, 100, 100);
        rScore.setBounds(500, 0, 100, 100);
        bScore.setForeground(Color.BLUE);
        rScore.setForeground(Color.RED);
        bScore.setHorizontalAlignment(SwingConstants.CENTER);
        rScore.setHorizontalAlignment(SwingConstants.CENTER);
        bScore.setFont(new Font(null, Font.PLAIN, 40));
        rScore.setFont(new Font(null, Font.PLAIN, 40));

        //-------------------------------------game panel stuff----------------------------//

        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 750));

        this.add(blueRacket);
        this.add(redRacket);
        this.add(ball);
        this.add(counter);
        this.add(bScore);
        this.add(rScore);

    }

    public void moveBall(){
        //move the ball
        ballX += vX;
        ballY += vY;
        if(ballX<=25 || ballX+30>=975){
            changeSpeed();
            if(ballX+30>=975) vX *= -1;
        }
        if(ballY<=0 || ballY+30>=750){
            vY *= -1;
            if(ballY<=0) ballY = 1;
            if(ballY+30>=750) ballY = 720;
        }

        //racket hit check
        if(ballX<=25 && (ballY<blueRacket.getY() || ballY>blueRacket.getY()+100))
            redScores();
        if(ballX+30>=975 && (ballY<redRacket.getY() || ballY>redRacket.getY()+100))
            blueScores();
        
        ball.setLocation(ballX, ballY);
    }

    public void countDown(){
        vY = 0;
        count--;
        counter.setText(String.valueOf(count));
        if(count==0){
            countDown.stop();
            this.remove(counter);
            this.repaint();
            timer.start();
        }
    }

    public void changeSpeed(){
        vX = 5;
        vY = random.nextInt(6)+3;
        if(random.nextBoolean()==true){
            vY *= -1;
        }
        
    }

    public void blueScores(){
        blueScore++;
        bScore.setText(String.valueOf(blueScore));
        timer.stop();
        ballX = 485;
        ballY = 360;
        count = 4;
        this.add(counter);
        countDown.start();
    }

    public void redScores(){
        redScore++;
        rScore.setText(String.valueOf(redScore));
        timer.stop();
        ballX = 485;
        ballY = 360;
        count = 4;
        this.add(counter);
        countDown.start();
    }

    public void resetGame(){
        timer.stop();
        countDown.stop();
        count = 4;
        redScore = 0;
        blueScore = 0;
        rScore.setText(String.valueOf(redScore));
        bScore.setText(String.valueOf(blueScore));
        blueRacket.setLocation(0, 325);
        redRacket.setLocation(975, 325);
        ball.setLocation(485, 360);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==countDown)
            countDown();
        if(e.getSource()==timer)
            moveBall();
    }

    public Timer getCountDown(){
        return countDown;
    }
    public JLabel getBlueRacket(){
        return blueRacket;
    }
    public JLabel getRedRacket(){
        return redRacket;
    }
    public int getBlueScore(){
        return blueScore;
    }
    public int getRedScore(){
        return redScore;
    }

}
