package Main;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener{
public boolean leftClick,justPressed;
public int xMos, yMos;
public int startX,startY,width, height,x ,y;
public boolean dragging;
private Handler handler;
public Rectangle selector;
public MouseHandler(Handler handler) {
	this.handler = handler;
	selector = new Rectangle(0,0,0,0);
}


public void setStartPoint(int x, int y) {
   startX = x; startY = y;
   System.out.println(startX + "  "+ startY);
}


	@Override
	public void mouseDragged(MouseEvent e) {
		  xMos = e.getX();
		  yMos = e.getY();
		  selector.x = this.x;
		  selector.y = this.y;
		  selector.width = this.width;
		  selector.height = this.height;
		  if(xMos > startX) {
			  this.x = startX;
			  width = xMos - startX;
		  }else if(xMos<startX) {
			  
			  width = startX - xMos;
			  this.x = startX - width;
			  
		  }
		  
		  if(yMos > startY) {
			  this.y = startY;
			  height = yMos - startY;
		  }else if(yMos<startY) {
			  
			  height = startY - yMos;
			  this.y = startY - height;
			  
		  }
		  
	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		  
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON1 && leftClick == false) {
	    	   leftClick = true;
	    	
	    	   if(dragging == false) {
	    		x = e.getX();
	    		y = e.getY();
	    		width = 0;
	    		height = 0;
	    		selector.x = x;
	    		selector.y = y;
	    		selector.width = width;
	    		selector.height = height;
	    		
	    	   setStartPoint(e.getX(), e.getY());
	    	   dragging = true;
	    	  
	       }	
	    	   }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		  if(e.getButton() == MouseEvent.BUTTON1) {
	    	   leftClick = false;
	    	   dragging = false;
}	
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
