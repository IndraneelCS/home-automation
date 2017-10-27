package com.srisaisadan.homeautomation.picontroller;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class PinCofig {

	public static final Pin GATE_MOTOR_PIN = RaspiPin.GPIO_01;
	public static final Pin MAIN_DOOR_MOTOR_PIN = RaspiPin.GPIO_02;
	public static final Pin TANK_LOWER_SENSOR_PIN = RaspiPin.GPIO_03;
	public static final Pin TANK_UPPER_SENSOR_PIN = RaspiPin.GPIO_04;
	public static final Pin TANK_MOTOR_PIN = RaspiPin.GPIO_05;

}
