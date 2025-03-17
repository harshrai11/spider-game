package com.harsh.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {

public Enemy(int x,int speed ) {
	y=20;
	this.speed=speed;
	this.x = x;
	//this means that the value of x is coming from the parents as there are three spider on the screen and every of them is on a specific gap 
	w=150;
	h=250;
	image = new ImageIcon(Enemy.class.getResource("spider-enemy.gif"));
}
public void move () {
	if(y>920) {
		y=0;//this condition is used when the spider is passing from all the way down so it has to return back to the place 
	}
	y=y+speed;
}
}
