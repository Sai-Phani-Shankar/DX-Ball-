import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener,ActionListener {
 private boolean play=false;
 private int score=0;
private Timer timer;
 private int totalbricks=21;
 private int playerx=310;
 private int ballx=120;
 private int bally=350;
 private int ballxdir=-1;
 private int ballydir=-2;
 private Block b;
 public Game() 
 {
	 b=new Block(3,7);
	 this.addKeyListener(this);
	 setFocusable(true);
	 setFocusTraversalKeysEnabled(false);
	 timer=new Timer(5,this);
	 timer.start();
 }
 public void paint(Graphics g)
 {
	 g.setColor(Color.black);
	 g.fillRect(1, 1, 692,592);
	
	 g.setColor(Color.YELLOW);
	 g.fillRect(0,0,3,592);
	 g.fillRect(0,0,692,3);
	 g.fillRect(691,0,3,592);
	 
	 Graphics2D g2=(Graphics2D)g;
	 b.draw(g2);
	 
	 g.setColor(Color.GREEN);
	 g.fillRect(playerx, 550, 100,8);
	 
	 g.setColor(Color.BLUE);
	 g.fillOval(ballx,bally,20,20);
	 g.dispose();
 }
 public void actionPerformed(ActionEvent e) {
	 timer.start();
	 if(play==true)
	 { 
		 if(new Rectangle(ballx,bally,20,20).intersects(new Rectangle(playerx,550,100,8)))
		 {
			 ballydir=-ballydir;
		 }
		 
		 for(int i=0;i<b.map.length;i++)
		 {
			 for(int j=0;j<b.map.length;j++)
			 {
				 if(b.map[i][j]==1)
				 {
					 int bx=i*b.blockwidth+150;
					 int by=j*b.blockheight+50;
					 int brickwidth=b.blockwidth;
					 int brickheight=b.blockheight;
					 
					 Rectangle rect=new Rectangle(bx,by,brickwidth,brickheight);
					 Rectangle rect1=new Rectangle(ballx,bally,20,20);
					 if(rect1.intersects(rect))
					 {
                                             ballydir=-ballxdir;
                                             ballx=-ballxdir;
                                              ballxdir=-ballydir;
                                              bally=-ballydir;
                                         	 b.brick(0,i,j);
						 totalbricks--;
						 score+=5;
                                         					 }
				 }
			 }
		 }
		 
		 ballx+=ballxdir;
		 bally+=ballydir;
		 if(ballx<0) 
		 {
			 ballxdir=-ballxdir;
		 }
		 if(bally<0)
		 {
			 ballydir=-ballydir;
		 }
		 if(ballx>670)
		 {
			 ballxdir=-ballxdir;
		 }
		 if(bally>670)
		 {
			 ballydir=-ballydir;
		 }
	 }
	 repaint();
	}
public void keyPressed(KeyEvent e) {
	int c=e.getKeyCode();
	if(c==KeyEvent.VK_RIGHT)
	{ 
		if(playerx>=600) 
		{
			playerx=600; 
		}
		else
		{
			moveRight();
		}
	}
		if(c==KeyEvent.VK_LEFT)
		{
			if(playerx<10)
			{
				playerx=10;
			}
			else
			{
				moveLeft();
			}
		}
	}
public void moveRight()
{
	play=true;
	playerx+=20;
}
public void moveLeft()
{
	play=true;
	playerx-=20;
}
public void keyReleased(KeyEvent e) {}
public void keyTyped(KeyEvent e) {}
}
