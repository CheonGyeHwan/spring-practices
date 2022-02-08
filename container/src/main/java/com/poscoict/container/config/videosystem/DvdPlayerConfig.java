package com.poscoict.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.poscoict.container.videosystem.Avengers;
import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

@Configuration
public class DvdPlayerConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	// 주입(Injection) 하기1
	// Bean 생성 메서드를 직접 호출하는 방법
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdplayer01() {
		return new DVDPlayer(avengers());
	}
	
	// 주입(Injection) 하기2
	// 파라미터로 빈 전달하기
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdplayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// 주입(Injection) 하기3
	// 파라미터로 빈 전달하기
	// setter 주입
	@Bean
	public DVDPlayer dvdplayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
	
	// 같은 타입의 빈을 생성할 경우
	@Bean(name="dvdPlayer04")
	public DVDPlayer dvdplayer04(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
}
