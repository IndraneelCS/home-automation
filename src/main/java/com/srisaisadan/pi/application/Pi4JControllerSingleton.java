package com.srisaisadan.pi.application;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public class Pi4JControllerSingleton {

	private Pi4JControllerSingleton() {
	}

	private static final GpioController controllerInstance = GpioFactory.getInstance();

	public static final GpioController getPiControllerInstance() {

		return controllerInstance;
	}
}
