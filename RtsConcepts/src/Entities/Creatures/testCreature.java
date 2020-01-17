package Entities.Creatures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Entities.*;
import Main.Handler;
public class testCreature extends Creature{
	private Handler handler;
	public testCreature(Handler handler, int x, int y, int width, int height, int speed) {
		super(handler,x,y,width,height, true,speed);
	    isSelected = false;
	    this.handler = handler;
	}

	@Override
	public void tick() {
		setBounds(new Rectangle(x,y,width,height));
	    checkDrag();
	    checkCollisions();
	    move();
	    
//	   
//	  if(isSelected && handler.getMouseMngr().rightClick ) {
//		  doCommand("MOVE",handler.getMouseMngr().x,handler.getMouseMngr().y);
//		  
//	  }
//	    
	    
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		
		
		if(isSelected  == true) {
			g.setColor(Color.RED);
			g.fillRect(x+2, y+2, width-4, height-4);
			
		}
	
	}
	
	
	

}
