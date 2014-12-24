package painters;

import java.awt.Point;
import java.awt.geom.GeneralPath;

public class Turtle {

	private double x, y, angle;
	
	private GeneralPath g;
	
	public Turtle(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.angle = 0;
		
		
		g = new GeneralPath();
		g.moveTo(x, y);
	}
	
	public Turtle forward(double length)
	{
		double xa = x +length*Math.cos(Math.toRadians(angle));
		double ya = y+ length*Math.sin(Math.toRadians(angle));
		g.lineTo(xa, ya);
		x = xa; y = ya;
		
		return this;
	}
	
	public Turtle backward(double length)
	{
		double xa = x - length*Math.cos(Math.toRadians(angle));
		double ya = y -  length*Math.sin(Math.toRadians(angle));
		g.lineTo(xa, ya);
		x = xa; y = ya;
		
		return this;
	}
	
	public Turtle turnLeft(double angle)
	{
		this.angle += angle;
		return this;
	}
	
	public Turtle turnRight(double deg)
	{
		this.angle -= deg;
		return this;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public GeneralPath getG() {
		return g;
	}

	public void setG(GeneralPath g) {
		this.g = g;
	}
	
	public Point getCurrPoint()
	{
		return new Point((int)x, (int)y);
	}
	

}
