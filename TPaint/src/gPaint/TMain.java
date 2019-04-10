package gPaint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import gPaint.DrawPanel;

public class TMain extends JFrame{
	public static final int  tWidth = 600;
	public static final int tHeight = 500;
	
	private ToolBox toolBox;
	private DrawPanel drawPanel;
	public InfoPanel infoPanel;
	
	public TMain(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("Hiiiiii");
		this.setBounds(10,10,tWidth,tHeight);
		infoPanel = new InfoPanel();		
		drawPanel = new DrawPanel(infoPanel);
		toolBox = new ToolBox(this.drawPanel);
		//add toolBox
		this.add(toolBox);
		//add drawPanel
		this.add(drawPanel);
		//add InfoPanel
		this.add(infoPanel);
		
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new TMain();

	}

}
