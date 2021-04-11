package game;

public enum Direction {

	UP, DOWN, LEFT, RIGHT;
	
	public static Direction createDirection(int v) {
		if (v == 0)
			return Direction.RIGHT;
		else if (v == 1)
			return Direction.UP;
		else if (v == 2)
			return Direction.LEFT;
		else if (v == 3)
			return Direction.DOWN;
		else
		{
			System.out.println("probleme de direction!!");
			return null;
		}
	}
}
