package com.harsh.gaming;

import javax.swing.JFrame;
//this file is used to provide only the frame 
public class GameFrame extends JFrame {

public GameFrame(){
	Board board = new Board();
// THESE ARE THE FEATURES OF THE FRAME WHICH ARE IMPORTED WITH THE JFRAME 
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//AS WE PRESS CLOSE BUTTON IT WILL REMOVE FROM THE MEMORY AND IT WILL CLOSE 
setTitle("Game Dev in Java");
setSize(1500,920);
setResizable(false);//minimize option is removed
setLocationRelativeTo(null);// frame screen is in the center
add(board);
this.setVisible(true);	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new GameFrame();//here we are calling constructor 


	}

}
