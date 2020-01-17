package Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;


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

	
};
	


public void render(Graphics g) {
	
	    g.setColor(Color.RED);
	  if(handler.getMouseMngr().dragging) {
		g.drawRect(handler.getMouseMngr().x,handler.getMouseMngr().y,handler.getMouseMngr().width,handler.getMouseMngr().height);
	 }
}

//Getters and Setters

}
