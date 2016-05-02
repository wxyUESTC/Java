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
	int y=0;//����x��y�����꣬�����������ʱ��������
	int [] []allchess=new int[15][15];
	//����һ��boolean�����жϵ�ǰ���������Ǻڻ��ǰ�
	boolean isBlack=true;
//	int count=1;
	//�����������ӵ����꣬����Ϊ14*14�����allchess=0����ʾ�����û�����ӣ�1��ʾ���ӣ�2��ʾ����
	public Test2()//���ô���Ĭ�ϳ�ʼ������Ϣ
	{
		this.setTitle("������");
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

		/*���Ҫ����֮ǰ�¹�����������Ҫ��������߼��ϱ���,���о��Ǳ����õ��ʱ���Ƶ�������x��y���
		 �ཻ���ϡ�����ཻ���ڵ����λ�������
		 ��������forѭ�����԰����е����Ӷ������
		 */
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{  
				if(allchess[i][j]==1)
				{//��ʾҪ����������ϻ��ƺ���
					int tempx=i*32+10;
					//ֱ�Ӱ�Բ�����������ε����ϽǶ���������ƣ�����tempx����Ҫ�ټ�ȥ�뾶
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
		y=e.getY();//�õ������λ�õ�����
		 
		 
	if(x>26 && x<478 && y>118 && y<585)
		
	{   System.out.println("�����̷�Χ��");
	    x=(x-26)/32; //�ѵĵ������껯�����鲢�����������У��Ա���� 
	    y=(y-115)/32;
		
	    if(allchess[x][y]==0)
	    //�ж������Ƿ��Ѿ��¹�����
	    
	    {   //count++;
//	    	allchess[x][y]=count;
//	    	System.out.println(count);
	    if(isBlack==true)
	          {
	    allchess[x][y]=1;//�����ǰ�µ������Ǻ�ɫ����ô��isBlackֵ��ֵΪfalse������һ�����°���
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
	    else{JOptionPane.showMessageDialog(this, "�������ӣ�");}
	    this.repaint();//��ʾ����ִ����ϡpaint����
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
	

