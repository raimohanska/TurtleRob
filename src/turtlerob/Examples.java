package turtlerob;
import static turtlerob.TurtleRob.*;

public class Examples {
	static void lookAround() {
		fd(100);
		lt(90);
		sleep(1000);
		rt(180);
		sleep(1000);
		lt(90);
	}
	
	static void rotationTest() {
		penDown();
		turn(360);
		penUp();
	}

	static void lineTest() {
		penDown();
		move(100);
		penUp();
		sleep(50000);
	}

	static void square(int distance) {
		polygon(4, distance);
	}
	
	static void polygon(int edges, int distance) {
		int angle = 360 / edges;
		for (int i = 0; i < edges; i++) {
			move(distance);
			turn(angle);
			sleep(200);
		}
	}
}
