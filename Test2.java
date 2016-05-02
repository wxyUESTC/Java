package org.liky.game.test;




import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test2 extends JFrame implements MouseListener {
	
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	int x=0;
	int y=0;//定义x和y轴坐标，用于在鼠标点击时绘制棋子
	int [] []allchess=new int[15][15];
	//定义一个boolean变量判断当前所下棋子是黑还是白
	boolean isBlack=true;
//	int count=1;
	//保存所有棋子的坐标，棋盘为14*14，如果allchess=0，表示这个点没有棋子，1表示黑子，2表示白子
	public Test2()//设置窗体默认初始设置信息
	{
		this.setTitle("五子棋");
		this.setSize(506, 595);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocation(width, height);
		this.setLocation((width-516)/2, (height-615)/2);
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
		BufferedImage image=null;
		try{
		image=ImageIO.read(new File("C:/Users/Administrator/Desktop/11.jpg"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 8, 30, this);

		/*如果要保存之前下过的棋子则需要用数组或者集合保存,还有就是必须让点击时绘制的棋子在x和y轴的
		 相交点上。这个相交点在点离击位置最近。
		 下面两个for循环可以把所有的棋子都输出来
		 */
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{  
				if(allchess[i][j]==1)
				{//表示要在这个坐标上绘制黑子
					int tempx=i*32+10;
					//直接按圆的外切正方形的左上角顶点坐标绘制，所以tempx不需要再减去半径
					int tempy=j*32+102;
					g.fillOval(tempx, tempy, 32, 32);
				}
				if(allchess[i][j]==2)
				{
					int tempx=i*32+10;
					int tempy=j*32+102;
					g.setColor(Color.WHITE);
					g.fillOval(tempx, tempy, 32, 32);
					g.setColor(Color.BLACK);
					g.drawOval(tempx, tempy, 32, 32);
				}
				System.out.print(allchess[i][j]);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX()+" "+e.getY());
		x=e.getX();
		y=e.getY();//得到鼠标点击位置的坐标
		 
		 
	if(x>26 && x<478 && y>118 && y<585)
		
	{   System.out.println("在棋盘范围内");
	    x=(x-26)/32; //把的到的坐标化成数组并保存在数组中，以备输出 
	    y=(y-115)/32;
		
	    if(allchess[x][y]==0)
	    //判断坐标是否已经下过棋子
	    
	    {   //count++;
//	    	allchess[x][y]=count;
//	    	System.out.println(count);
	    if(isBlack==true)
	          {
	    allchess[x][y]=1;//如果当前下的棋子是黑色，那么把isBlack值赋值为false，则下一步就下白棋
	    isBlack=false;
	    System.out.println(allchess[x][y]);
	          }
	    else
	        {
	    allchess[x][y]=2;
	    isBlack=true;
	    System.out.println(allchess[x][y]);
	         }
	    
	    }
	    else{JOptionPane.showMessageDialog(this, "已有棋子！");}
	    this.repaint();//表示重新执行依稀paint方法
	}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test2 jf=new Test2();
		
	}
	

}
	

