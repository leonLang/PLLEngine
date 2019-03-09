package com.PLLEngine.Game;

import java.awt.event.KeyEvent;

import com.PLLEngine.Control.Control;
import com.PLLEngine.Window.Window;
import com.fasterxml.jackson.annotation.JsonView;

public class SchriptGame implements GameBase{
	private String _comment,titel,version;
	private int spriteSize;
	@JsonView(Window.class)
	private Window window;
	
	private Control controller;
	

	public String get_comment() {
		return _comment;
	}

	public void set_comment(String _comment) {
		this._comment = _comment;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	@Override
	public void setup() {		
		this.controller = new Control(this);
	}

	@Override
	public void init() {
		//init GameWindow with given properties
		window.init();		
		window.setTitel(this.titel + " - " + this.version);
	}

	@Override
	public void preinit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lateupdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
