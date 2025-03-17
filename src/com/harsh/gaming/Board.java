package com.harsh.gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.harsh.gaming.sprites.Enemy;
import com.harsh.gaming.sprites.Player;
//this class 
public class Board extends JPanel {
	Timer timer ;
	BufferedImage backgroundImage;
 Player player;
 Enemy enemies []=new Enemy[3];
public Board() {
	setSize(1500,920); 
	loadBackgroundImage();
	player = new Player();
loadEnemies();
	gameLoop();
bindEvents();
setFocusable(true);
}
private void bindEvents(){
	addKeyListener(new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
			// Not used
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// Move the player when the key is pressed
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.speed = 12;
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.speed = -10;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Stop the player when the key is released
			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.speed = 0;
			}
		}
	});
}

private void gameOver(Graphics pen) {
	if(player.outOfScreen()) {
		pen.setFont(new Font("times",Font.BOLD,30));
		pen.setColor(Color.RED);
		pen.drawString("GAME WIN",1500/2,900/2);
		
	timer.stop();
	return ;
	}
	for(Enemy enemy : enemies) {
		if(isCollide(enemy)) {
			pen.setFont(new Font("times",Font.BOLD,30));
			pen.setColor(Color.RED);
			pen.drawString("GAME OVER",1500/2,900/2);
			
		timer.stop();
		}
	}
}
private boolean isCollide (Enemy enemy ) {
	  int xDistance = Math.abs(player.x- enemy.x);
	  int yDistance = Math.abs(player.y- enemy.y);
	  int maxH=Math.max(player.h,enemy.h);
	  int maxW=Math.max(player.w,enemy.w);
	  return xDistance <= maxW-80 && yDistance <=maxH-80;
}
//this function is used to load three objects for the enemy class as it has three spider in the screen 
private void loadEnemies() {
	int x=400;
	int gap= 400;
	int speed = 5;
	for(int i = 0; i<enemies.length;i++) {
		enemies [i] = new Enemy(x,speed);
		x=x+gap;
		speed=speed+5;
	}
}
private void printEnemies (Graphics pen) {
	for(Enemy enemy : enemies) {
		enemy.draw(pen);
		enemy.move();
	}
}
private void gameLoop() {
	//this function is repainting image after every 50 millisecond and there always appear a new image after the timer is over and results in a new image after every 50 millisecond  
	//and this will call paint component which is repainting the image again and again 
	timer = new Timer(50,(e)->repaint());//here e is a action listener and it is repainting the image 
timer.start();
}
private void loadBackgroundImage()  {
	try {

	backgroundImage=ImageIO.read(Board.class.getResource("game-bg.jpg"));
	}catch(IOException e) {
		System.out.println("Background Image not found .....");
		System.exit(1);//if it 1 then there is any problem in the displaying the image 
		e.printStackTrace();//it tells where the problem is 
	}
}
@Override
public void paintComponent(Graphics pen) {
	super.paintComponent(pen);//it is used to clean up 
	pen.drawImage(backgroundImage,0,0,1500,920,null);
	player.draw(pen);
	player.move();
	printEnemies(pen);
	gameOver(pen);
}
}
