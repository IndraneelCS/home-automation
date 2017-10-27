package com.srisaisadan.homeautomation.picontroller.services;

import com.pi4j.io.gpio.Pin;
import com.srisaisadan.homeautomation.picontroller.PinCofig;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class MainDoorController {

	private final Pin mainDoorMotorPin = PinCofig.MAIN_DOOR_MOTOR_PIN;

	public boolean openDoor() {

		return false;
	}

	public boolean closeDoor() {

		return false;
	}
}
