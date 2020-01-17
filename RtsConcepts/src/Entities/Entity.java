package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;

public abstract class Entity {
	protected boolean isActive, isSelected;
	protected int x,y,width,height,xDir,yDir;
	protected Rectangle bounds;
    private Handler handler;
    
	 public Entity(Handler handler,int x, int y,int width, int height, boolean isActive,int xDir,int yDir) {
	   	 this.isActive = isActive;
	     this.handler = handler;
		 this.x = x; this.y = y;
		 this.width = width; this.height = height;
		 this.xDir = xDir; this.yDir = yDir;
		 
	 }
	 public Rectangle getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle r) {
		 bounds = r;
		 
	 }

	 protected abstract void tick();
	 protected abstract void render(Graphics g);
	 protected abstract void doCommand(String type,int xDest, int yDest);
			

}
