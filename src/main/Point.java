package main;

import game.Direction;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public static Point getNextPosition(Point p, Direction d)
	{
		int x = p.getX();
		int y = p.getY();
	
		if (d == Direction.UP)
				y = p.getY() -1;
		else if (d == Direction.DOWN)
				y = p.getY() + 1;
		else if (d == Direction.LEFT)
			x = p.getX() -1;
		else if (d == Direction.RIGHT)
				x = p.getX() +1;
		else
			return null;
		return new Point(x,y);
	}
	
	public static Point getPreviousPosition(Point p, Direction d)
	{
	
		if (d == Direction.UP)
			return getNextPosition(p, Direction.DOWN);
		else if (d == Direction.DOWN)
			return getNextPosition(p, Direction.UP);
		else if (d == Direction.LEFT)
			return getNextPosition(p, Direction.RIGHT);
		else if (d == Direction.RIGHT)
			return getNextPosition(p, Direction.LEFT);
		else
			return null;	
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public boolean equal(int x, int y) {
		return this.x == x && this.y == y;
	}

	public boolean equal(Point p) {
		return (equal(p.getX(), p.getY()));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
