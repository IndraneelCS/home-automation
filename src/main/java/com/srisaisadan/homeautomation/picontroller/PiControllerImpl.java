package com.srisaisadan.homeautomation.picontroller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.exception.GpioPinExistsException;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class PiControllerImpl implements PiControllerInterface {

	@Override
	public GpioPinDigitalInput getInputPin(Pin pin, String pinName) throws GpioPinExistsException {
		GpioController gpio = Pi4JControllerSingleton.getPiControllerInstance();
		GpioPinDigitalInput inputButton = gpio.provisionDigitalInputPin(pin, pinName, PinPullResistance.PULL_DOWN);
		return inputButton;
	}

	@Override
	public GpioPinDigitalOutput getOutputPin(Pin pin, String pinName) throws GpioPinExistsException {
		GpioController gpio = Pi4JControllerSingleton.getPiControllerInstance();
		GpioPinDigitalOutput outputButton = gpio.provisionDigitalOutputPin(pin, pinName, PinState.LOW);
		return outputButton;
	}

	@Override
	public boolean flushPin(Pin pin) {
		return false;
	}

}
