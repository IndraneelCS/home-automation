package com.srisaisadan.homeautomation.picontroller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class Pi4JControllerSingleton {

	private Pi4JControllerSingleton() {
	}

	private static final GpioController controllerInstance = GpioFactory.getInstance();

	public static final GpioController getPiControllerInstance() {

		return controllerInstance;
	}
}
