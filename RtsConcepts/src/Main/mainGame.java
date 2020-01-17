package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;

import Entities.Creatures.testCreature;


public class mainGame {
	private keyManager keyM;
	private Handler handler;
	private Font font16;
	
	
public mainGame(keyManager KeyManager, Handler handler) {

	this.keyM = KeyManager;
	this.handler = handler;
	font16 = FontLoader.loadFont("pixel.ttf", 16);

	
	
}
//Tick and Render

public void tick() {
if(handler.getKeyMngr().space) {
	handler.getEntityManager().addEntity(new testCreature(handler,handler.getRandomNumber(0, 600),handler.getRandomNumber(0, 600),10,10));
	
}


};
	


public void render(Graphics g) {
	
	   g.setColor(Color.RED);
	  if(handler.getMouseMngr().dragging) {
		g.drawRect(handler.getMouseMngr().x,handler.getMouseMngr().y,handler.getMouseMngr().width,handler.getMouseMngr().height);
	 }
}

//Getters and Setters

}
