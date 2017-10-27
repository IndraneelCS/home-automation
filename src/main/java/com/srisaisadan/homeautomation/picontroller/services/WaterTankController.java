package com.srisaisadan.homeautomation.picontroller.services;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.exception.GpioPinExistsException;
import com.srisaisadan.homeautomation.picontroller.PiControllerImpl;
import com.srisaisadan.homeautomation.picontroller.PiControllerInterface;
import com.srisaisadan.homeautomation.picontroller.PinCofig;

/**
 * @author Indraneel C S
 *
 * Mail to me @ indraneelcs@gmail.com
 */
public class WaterTankController {

	private static Pin tankBottomLevelSensor = PinCofig.TANK_LOWER_SENSOR_PIN;
	private static Pin tankTopLevelSensor = PinCofig.TANK_UPPER_SENSOR_PIN;
	private static Pin tankOutputPin = PinCofig.TANK_MOTOR_PIN;

	PiControllerInterface piController = new PiControllerImpl();

	public void controlMotor() {

		final InputSensors inputSensors = configureTankInputPin();
		final GpioPinDigitalOutput motor = configureTankOutputPin();

		while (true) {

			inputSensors.getBottomLevelSensor().addListener(new GpioPinListenerDigital() {
				@Override
				public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

					if (event.getState().isHigh() && motor.isLow()) {
						motor.high();
						try {
							Thread.sleep(100000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						while (inputSensors.getTopLevelSensor().getState().isLow()) {
							motor.low();
							return;
						}
					}

				}
			});
		}
	}

	private InputSensors configureTankInputPin() {

		InputSensors inputSensors = new InputSensors();
		GpioPinDigitalInput bottomLevelSensor = null;
		GpioPinDigitalInput topLevelSensor = null;

		try {
			bottomLevelSensor = piController.getInputPin(tankBottomLevelSensor, "Water Tank bottom level sensor");
			topLevelSensor = piController.getInputPin(tankTopLevelSensor, "Water Tank Top level sensor");
			inputSensors.setBottomLevelSensor(bottomLevelSensor);
			inputSensors.setTopLevelSensor(topLevelSensor);
		} catch (GpioPinExistsException e) {
			e.printStackTrace();
		}
		return inputSensors;
	}

	private GpioPinDigitalOutput configureTankOutputPin() {

		GpioPinDigitalOutput motor = null;

		try {
			motor = piController.getOutputPin(tankOutputPin, "Water Tank Output Pin");
		} catch (GpioPinExistsException e) {
			e.printStackTrace();
		}
		return motor;
	}

	private class InputSensors {

		GpioPinDigitalInput bottomLevelSensor;
		GpioPinDigitalInput topLevelSensor;

		InputSensors() {

		}

		public GpioPinDigitalInput getBottomLevelSensor() {
			return bottomLevelSensor;
		}

		public void setBottomLevelSensor(GpioPinDigitalInput bottomLevelSensor) {
			this.bottomLevelSensor = bottomLevelSensor;
		}

		public GpioPinDigitalInput getTopLevelSensor() {
			return topLevelSensor;
		}

		public void setTopLevelSensor(GpioPinDigitalInput topLevelSensor) {
			this.topLevelSensor = topLevelSensor;
		}

	}
}
