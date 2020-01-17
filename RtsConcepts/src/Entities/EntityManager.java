package Entities;

import java.awt.Graphics;
import java.util.ArrayList;

import Main.Handler;

public class EntityManager {
	private Handler handler;
	private ArrayList<Entity> _entities = new ArrayList<Entity>();
	public EntityManager(Handler handler) {
		this.handler = handler;
		
	}
  public void tick() {
	  
	  for(Entity e: _entities) {
		 
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
