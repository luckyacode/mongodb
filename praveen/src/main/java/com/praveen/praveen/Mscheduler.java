package com.praveen.praveen;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Mscheduler {
	
//	@Scheduled(fixedRate = 5000)
	@Scheduled(initialDelay=1000,fixedDelay = 3000)
	public void schedule(){
		SimpleDateFormat ft = new SimpleDateFormat("dd-mm-yyyy  HH:mm:ss");
		Date d = new Date();
		ft.format(d); 
		System.out.println("Praveen Prints Here :" +d);
	}

}
