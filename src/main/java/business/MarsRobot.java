package business;

/**
 * Created by vinicius on 22/03/17.
 */
public class MarsRobot implements Robot {
    private Position position;

    public MarsRobot() {
        this.position = new Position(0, 0, Position.NORTH);
    }

    public void rotate(char side) {
        this.position.rotate(side);
    }

    public Position getCurrentPosition() {
        return this.position;
    }

    public void turnLeft() {
        this.position.rotate(Position.TURN_LEFT);
    }

    public void turnRight() {
        this.position.rotate(Position.TURN_RIGHT);
    }
}
