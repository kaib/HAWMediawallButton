package de.haw_hamburg.hawmediawallbutton;

import java.io.IOException;

import com.google.gson.Gson;

import de.haw.publisher.AndroidPublisher;


public class SendToActiveMQ {
	String url = "10.0.2.2",message = "blabla" ,queue = "test";
	int port = 12349;
	Gson g;
	public SendToActiveMQ() {
		new Thread(new Runnable() {
			
			public void run() {
				AndroidPublisher p = new AndroidPublisher(url ,port , queue);
				p.setMessage(message);
				try {
					p.publishToQueue();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	public SendToActiveMQ(final String url, final int port, final String queue, final String message){
		this.url = url;
		this.message = message;
		this.port = port;
	new Thread(new Runnable() {
		
		public void run() {
			AndroidPublisher p = new AndroidPublisher(url ,port , queue);
			p.setMessage(message);
			try {
				p.publishToQueue();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}).start();
}
	
}
