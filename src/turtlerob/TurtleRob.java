package turtlerob;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class TurtleRob {
	static RegulatedMotor left = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor right = new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor pen = new EV3MediumRegulatedMotor(MotorPort.C);
	
	static {
		left.setAcceleration(10000);
		right.setAcceleration(10000);
		
		left.setSpeed(200);
		right.setSpeed(200);
	}
	
	static void sleep(int ms) {
		Delay.msDelay(ms);
	}
	
	static void penDown() {
		int start = pen.getTachoCount();
		pen.rotateTo(-20, true);
		sleep(200);
		pen.stop();
		int stop = pen.getTachoCount();
		LCD.drawString("D" + start + "->" + stop + " diff " + (stop-start), 0, 0);
		sleep(100);
		pen.stop();
	}
	
	static void penUp() {
		pen.resetTachoCount();
		int start = pen.getTachoCount();
		pen.rotateTo(20);		
		int stop = pen.getTachoCount();
		LCD.drawString("U" + start + "->" + stop + " diff " + (stop-start), 0, 1);
	}
	
	static void turn(double angle) {
		double factor = 2.47;
		left.rotate((int)(angle * -factor), true);
		right.rotate((int)(angle * factor), false);
		sleep(100);		
	}

	static void move(double distance) {
		double factor = 4.2;
		left.rotate((int)(distance * factor), true);
		right.rotate((int)(distance * factor), false);
		sleep(100);
	}
	
	static void fd(double distance) {
		move(distance);
	}
	
	static void lt(double angle) {
		turn(-angle);
	}
	
	static void rt(double angle) {
		turn(angle);
	}

}
