package com.harsh.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {


public Player() {
	w=200;
	h=200;
	x=30;
	y=550;
image = new ImageIcon(Player.class.getResource("player.gif"));//this is used to bring the image

}
public void move () {
	x=x+speed ;
	
}
public boolean outOfScreen() {
	return x>1500;
}
}
