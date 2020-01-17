package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Main.Handler;

public class EntityManager {
	private Handler handler;
	private ArrayList<Entity> _entities = new ArrayList<Entity>();
	private ArrayList<Entity> selectedEnt = new ArrayList<Entity>();
	public int selected = 0;
	public Entity entA,entB;
	public EntityManager(Handler handler) {
		this.handler = handler;
		
	}
	public void correctCollision(Entity a, Entity b) {
		//System.out.println("corret");
		 if(a.x<b.x-5) {
			 a.x -= 5;
			 b.x += 5;
		 }else if(a.x>b.x) {
			 a.x += 5;
			 b.x -= 5;
		 }
		 if(a.y<b.y) {
			 a.y -= 5;
			 b.y += 5;
		 }else if(a.y>b.y) {
			 a.y += 5;
			 a.y -= 5;
		 }
		 

	
	}
	public int getSelectedUnits() {
		int amount = 0;
		for(int i = 0; i<_entities.size(); i++) {
			if(_entities.get(i).isSelected) {
				amount += 1;
			}
		}
		return amount;
		
	}
	 public  boolean checkEntityCollisions(Entity ent) {
			for(int i = 0; i< _entities.size();i++) {
				if(_entities.get(i) != ent && ent != null && _entities.get(i) != null) {
				Rectangle a = new Rectangle(ent.x,ent.y,ent.width,ent.height);
				Rectangle b = new Rectangle(_entities.get(i).x,_entities.get(i).y,_entities.get(i).width,_entities.get(i).height);
				entA = ent;
				entB = _entities.get(i);
				if(a.intersects(b)) {
				
					return true;
				}else {
					return false;
				}
					
				
				}
				
				
			}
					return false;
			}
	public void commandSelected(int startX, int startY) {
		
		float angleDiv = 360/getSelectedUnits();
		float angle = 0;
		float distance = getSelectedUnits()*8;
	    int xDest, yDest;
//	    xDest = (int) (startX + Math.cos(angle)*distance);
//        yDest = (int) (startY + Math.tan(angle)*distance);
	    xDest = startX;
	    yDest = startY;
	    
        
        System.out.println(xDest +"  "+yDest);
		for (int i =0 ;i<_entities.size(); i++) {
			if(_entities.get(i).isSelected) {
				System.out.println(angle);
				angle += angleDiv;
				xDest=(int) Math.round(startX + (Math.cos(Math.toRadians(angle))*distance));
		        yDest=(int) Math.round(startY + (Math.sin(Math.toRadians(angle))*distance));
		        _entities.get(i).doCommand("MOVE", xDest, yDest);
			}
		}
	}
	
  public void tick() {
	  if(getSelectedUnits() > 0) {
		  if(handler.getMouseMngr().rightClick) {
			  commandSelected(handler.getMouseMngr().x,handler.getMouseMngr().y);
		  }
	  }

	  for(int i = 0; i<_entities.size(); i++) {
	

		  
		  _entities.get(i).tick();
		 
	   if(_entities.get(i).isActive == false) {
			  _entities.remove(i);
		  }
	  }
	  
  }
  public Entity getEntity(int index) {
	  return _entities.get(index);
	  
  }
  public boolean getSelected(int i) {
	  return _entities.get(i).isSelected;
  }

  public void render(Graphics g) {
	  for(int i = 0; i<_entities.size(); i++) {
		  _entities.get(i).render(g);
	  }
	  
  }
  
  
  public void addEntity(Entity e) {
	  _entities.add(e);
	  
  }
public ArrayList<Entity> get_entities() {
	return _entities;
}
}
