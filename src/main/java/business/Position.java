package business;

/**
 * Created by vinicius on 22/03/17.
 */
public class Position {
    /*
     * Directions
     */
    public static char NORTH = 'N';
    public static char SOUTH = 'S';
    public static char WEST = 'W';
    public static char EAST = 'E';

    /*
     * Rotations
     */
    public static char TURN_LEFT = 'L';
    public static char TURN_RIGHT = 'R';

    private int y;
    private int x;
    private char direction;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void rotate(char side){
        if (side == TURN_LEFT){
            switch (this.direction){
                case 'N':
                    this.direction = WEST;
                    break;
                case 'W':
                    this.direction = SOUTH;
                    break;
                case 'S':
                    this.direction = EAST;
                    break;
                case 'E':
                    this.direction = NORTH;
                    break;
            }
        } else if (side == TURN_RIGHT){
            switch (this.direction){
                case 'N':
                    this.direction = EAST;
                    break;
                case 'W':
                    this.direction = NORTH;
                    break;
                case 'S':
                    this.direction = WEST;
                    break;
                case 'E':
                    this.direction = SOUTH;
                    break;
            }
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null || Position.class.isAssignableFrom(obj.getClass())) {
            final Position position = (Position) obj;
            if (position.getX() == this.x && position.getY() == this.y && position.direction == this.direction){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("(%s, %s, %s)", this.x, this.y, this.direction);
    }
}
