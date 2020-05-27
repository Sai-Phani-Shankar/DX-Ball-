import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Block {
	 int map[][];
int blockheight;
int blockwidth;
public Block(int row,int col)
{
	map=new int[row][col];
	for(int i=0;i<map.length;i++)
	{
		for(int j=0;j<map.length;j++)
		{
			map[i][j]=1;
		}
	}
	blockwidth=540/col;
	blockheight=150/row;
}
public void draw(Graphics2D g)
{
	for(int i=0;i<map.length;i++)
	{
		for(int j=0;j<map.length;j++)
		{
			if(map[i][j]==1)
			{
				g.setColor(Color.WHITE);
				g.fillRect(i*blockwidth+150,j*blockheight+40 , blockwidth, blockheight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(i*blockwidth+150,j*blockheight+40 , blockwidth, blockheight);
			}
		}
}
}
public void brick(int value,int row,int col)
{
	map[row][col]=value;
}
}
