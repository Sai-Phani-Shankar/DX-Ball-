import javax.swing.JFrame;

public class Fir
{
			public static void main(String[] args)
			{
				JFrame f=new JFrame();
				Game g=new Game();
				f.setVisible(true);
				f.setSize(700,600);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.add(g);   
			} 
			
	}

