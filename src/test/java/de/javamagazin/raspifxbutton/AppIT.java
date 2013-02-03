package de.javamagazin.raspifxbutton;

import org.junit.Test;

import de.javamagazin.raspifxbutton.App;


public class AppIT {
	
	@Test
	public void testRun() throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				App.main(new String[]{"--hw-controller=de.javamagazin.raspifxbutton.FakedHwController"});				
			}
		}).start();
		Thread.sleep(15000);
	}
	
}
