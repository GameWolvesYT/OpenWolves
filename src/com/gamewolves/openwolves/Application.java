package com.gamewolves.openwolves;

import org.lwjgl.opengl.GL11;

import com.gamewolves.openwolves.core.OpenWolvesApplication;
import com.gamewolves.openwolves.entities.gui.Rectangle;
import com.gamewolves.openwolves.shaders.Shader;

public class Application extends OpenWolvesApplication {
	
	Rectangle rect1;
	Shader shader;
	
	public void init(int width, int height, boolean resizable, String title) {
		super.init(this, width, height, resizable, title);
		
		rect1 = new Rectangle(0.5f, 0.5f);
		rect1.addTexture("res/smiley.png");
		shader = new Shader("res/shaders/basicShader/vertex.vert", null, "res/shaders/basicShader/fragment.frag", new String[] { "position", "uvCoords" });
		
		super.update();
		super.delete();
	}

	public void update() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.3f, 0.5f, 0.7f, 1.0f);
		
		shader.start();
		rect1.render();
		shader.stop();
	}

	
	public void delete() {
		shader.delete();
	}
	
}
