raspi-fx-button
===============

Demo Application for the Raspberry Pi which integrates a hardware button into a JavaFX application
using the GPIO Pins.

This is the source code for the article "Himbeerkuchen mit Kaffe" published in [issue 5.2013 of the JavaMagazin.](http://it-republik.de/jaxenter/java-magazin-ausgaben/JavaFX-000544.html).

Run
---

The use of GPIO pins requires root access. Build with Maven and copy the resulting jar to your RaspberryPi. Login to your RPi and
start the application.

	sudo java -Djavafx.platform=eglfb -cp ./'*':/opt/java/jdk1.8.0/jre/lib/jfxrt.jar:/opt/pi4j/lib/'*' de.javamagazin.raspifxbutton.App

Install pi4j
------------

	wget http://pi4j.googlecode.com/files/pi4j-0.0.5-SNAPSHOT.deb
	sudo dpkg -i pi4j-0.0.5-SNAPSHOT.deb 

Install Java8
-------------

	wget http://www.java.net/download/JavaFXarm/jdk-8-ea-b36e-linux-arm-hflt-29_nov_2012.tar.gz
	tar xvzf ~/jdk-8-ea-b36e-linux-arm-hflt-29_nov_2012.tar.gz
	sudo mkdir -p -v /opt/java
	sudo mv -v ~/jdk1.8.0 /opt/java
	sudo update-alternatives --install "/usr/bin/java" "java" "/opt/java/jdk1.8.0/bin/java" 1
	sudo update-alternatives --set java /opt/java/jdk1.8.0/bin/java
	java -version


Author
------

[Thomas Scheuchzer](http://www.java-adventures.com/)

