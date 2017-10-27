package com.srisaisadan.homeautomation.picontroller.services;

import com.pi4j.io.gpio.Pin;
import com.srisaisadan.homeautomation.picontroller.PinCofig;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class GateController {

	private final Pin gateMotorPin = PinCofig.GATE_MOTOR_PIN;

	public boolean openGate() {

		return false;
	}

	public boolean closeGate() {

		return false;
	}
}
