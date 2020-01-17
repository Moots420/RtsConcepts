package Entities;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import Main.Handler;


public abstract class Creature extends Entity{
	private Handler handler;
	private  int xDest, yDest,xDir,yDir;
	public Boolean hitting;
	private int speed,selected;
	public Creature(Handler handler,int x, int y,int width, int height,boolean isActive, int speed) {
		 super(handler,x,y,width,height,isActive,0,0);
		 this.speed = speed;
		 this.handler = handler;
		 hitting = false;
		 xDest = x;
		 yDest = y;
	}
	public void doCommand(String type,int xDest, int yDest) {
	switch(type) {
	case "MOVE": this.xDest = xDest ; this.yDest = yDest ; break;		
	}
	isSelected = false;
	}
    
	public static final double calcAngleBetweenPoints(Point2D.Double p1, Point2D.Double p2)
    {
        return Math.toDegrees( Math.atan2( p2.getY()-p1.getY(), p2.getX()-p1.getX() ) );
    }
    
    
	public void move() {
		
        Point2D.Double currentPosition = new Point2D.Double(x,y);
     Point2D.Double destinationPosition = new Point2D.Double(xDest, yDest);
     float angle = (float)(calcAngleBetweenPoints(currentPosition, destinationPosition));
  // angle = (float) (angle * (180/Math.PI));
	       
	        if(angle>0) {
	        	
	       // System.out.println(angle);
	        }
	        if(angle<0) {
	        	angle = angle+360;
	        }
	        
	        if(x>xDest+5 || x<xDest-5) {
	        	
	        x += Math.cos(Math.toRadians(angle))*speed;
	        }
	        if(y>yDest+5 || y<yDest-5) {
	        y += Math.sin(Math.toRadians(angle))*speed;
	        }
	        checkCollisions();
		if(hitting) {
			handler.getEntityManager().correctCollision(handler.getEntityManager().entA, handler.getEntityManager().entB);

		}
		}
	
	public void checkCollisions() {
	
	if(handler.getEntityManager().checkEntityCollisions(this)) {
		hitting = true;
	  //  System.out.println("hit");
	} else {
		hitting = false;
	}
	}
	
	
	public void checkDrag() {	
		if(handler.getMouseMngr().dragging) {
			if(handler.getMouseMngr().selector.intersects(bounds)) {
				isSelected = true;
				handler.getEntityManager().selected += 1;
		    
			}else if(handler.getKeyMngr().shift==false){isSelected = false;}

		}
	}


	public void die() {
		if(isActive == true) {
			isActive = false;
		}
	}


	

}
