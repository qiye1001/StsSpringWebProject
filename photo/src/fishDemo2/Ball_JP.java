package fishDemo2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
 
public class Ball_JP extends JPanel implements MouseMotionListener{      //实现监听鼠标的接口
	List<Ball> balls =new ArrayList<Ball>();         //存放所有的鱼
	public Ball_JP(){
		addMouseMotionListener(this);         //添加监听
		for(int i=0;i<50;i++)
			add_ball();
	}
	
	void add_ball(){                      //随机数产生鱼的初始坐标,大小,方向，颜色等
		int x=(int) (Math.random()*700);
		int y=(int) (Math.random()*500);
		int dir=(int) (Math.random()*4);
		int d=(int) (Math.random()*30);
		int r=(int) (Math.random()*255);
		int g=(int) (Math.random()*255);
		int b=(int) (Math.random()*255);
		int sp=(int) (Math.random()*1+1);
		Color col=new Color(r,g,b);
		balls.add(new Ball(x,y,dir,d,sp,col));
	}
	public void paint(Graphics g) {
		
		super.paint(g);
		setBackground(Color.white);                 //隐含this 设置画布的背景颜色
		for(int i=0;i<balls.size();i++){            //把所有的鱼画出来
			Ball b=balls.get(i);
			b.Draw(g);
		}
	}
	
	public void run_run(){
		new Thread(){
			public void run(){
				while(true){
					for(int i=1;i<balls.size();i++){               //所有鱼运动一次
						Ball b=balls.get(i);
						b.move();
					}
					for(int i=0;i<balls.size()-1;i++){           //两个for循环判断所有小球是否碰撞
						Ball b1=balls.get(i);
						for(int j=i+1;j<balls.size();j++){
							Ball b2=balls.get(j);
						BallandBall bab=new BallandBall();
							if(bab.balldestroy(b1, b2)==1){        //碰到了
								if(b1.d>=b2.d){
									b1.d+=b2.d/4;
									balls.remove(j);
									break;
								}
								else if(b1.d<b2.d){
									b2.d+=b1.d/4;
									balls.remove(i);
									break;
								}
							}
							
						}
					}
					repaint();                        //再次调用paint()
					try {
						Thread.sleep(30);            //休眠
					} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}.start();
	}
 
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Ball mb=balls.get(0);              //偷懒了     控制的只是第0号小球
		mb.x=e.getX()-mb.d/2;              //获得鼠标的坐标
		mb.y=e.getY()-mb.d/2;
	}
}
