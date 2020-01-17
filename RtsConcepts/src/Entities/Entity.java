package Entities;

import java.awt.Graphics;

public abstract class Entity {
	boolean isActive;
	 public Entity() {
		 isActive = false;
		 
		 
	 }
	 public abstract void tick();
	 public abstract void render(Graphics g);

}
