package com.poscoict.container.videosystem;

public class Avengers implements DigitalVideoDisc {
	private String studio = "MARVEL";
	private String title = "Avengers";
	
	public void play() {
		System.out.println("Playing Movie " + studio + "'s " + title);
	}
	
}
