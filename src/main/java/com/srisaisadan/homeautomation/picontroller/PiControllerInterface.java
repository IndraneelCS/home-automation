package com.srisaisadan.homeautomation.picontroller;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.exception.GpioPinExistsException;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public interface PiControllerInterface {

	
	public GpioPinDigitalInput getInputPin(Pin pin, String pinName) throws GpioPinExistsException;
	
	public GpioPinDigitalOutput getOutputPin(Pin pin, String pinName) throws GpioPinExistsException;
	
	public boolean flushPin(Pin pin);
	
}
