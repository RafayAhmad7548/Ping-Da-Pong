import java.awt.event.*;
import javax.swing.*;

public class Main implements MouseListener, KeyListener{

    private JFrame frame;
    private MainMenu mainMenu;
    private Game game;

    private boolean up, down, w, s;

    public Main(){

        frame = new JFrame("Ping Da Pong");
        mainMenu = new MainMenu();
        game = new Game();
    
        //-------------------------------------frame--------------------------------------//

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.addMouseListener(this);
        frame.addKeyListener(this);
        
        mainMenu();
       
        frame.setVisible(true);
        frame.pack();
    }

    public void mainMenu(){
        game.resetGame();
        frame.remove(game);
        frame.add(mainMenu);
        frame.repaint();
    }

    public void startGame(){
        frame.remove(mainMenu);
        frame.add(game);
        frame.repaint();
        game.revalidate();
        game.repaint();
        game.getCountDown().start();
    }

    public void mouseClicked(MouseEvent e){
        startGame();
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 38 :up = true;    //UP
            break;
            case 40 : down = true; //DOWN
            break;
            case 87 : w = true;    //W
            break;
            case 83 : s = true;    //S
            break;
        }
        if(up==true && game.getRedRacket().getY()>=0){
            game.getRedRacket().setLocation(975, game.getRedRacket().getY()-10);
        }else if(down==true && game.getRedRacket().getY()<=650){
            game.getRedRacket().setLocation(975, game.getRedRacket().getY()+10);
        }
        if(w==true && game.getBlueRacket().getY()>=0){
            game.getBlueRacket().setLocation(0, game.getBlueRacket().getY()-10);
        }else if(s==true && game.getBlueRacket().getY()<=650){
            game.getBlueRacket().setLocation(0, game.getBlueRacket().getY()+10);
        }
        if(e.getKeyCode()==27) mainMenu();
    }
    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case 38 :up = false;    //UP
            break;
            case 40 : down = false; //DOWN
            break;
            case 87 : w = false;    //W
            break;
            case 83 : s = false;    //S
            break;
        }
    }

    public static void main(String[] args){
        new Main();
    }

    
    //-----------------------------unused methods---------------------------------//

    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }

    public void keyTyped(KeyEvent e){   
    }
    


}
