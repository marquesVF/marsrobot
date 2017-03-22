package business;

/**
 * Created by vinicius on 22/03/17.
 */
public class MarsTerrain implements Terrain {
    private int max_width;      // The 'x'coordinate
    private int max_height;     // The 'y'coordinate
    private Robot robot;

    public MarsTerrain(int x, int y) {
        this.max_width = x;
        this.max_height = y;
    }

    public Robot getRobot() {
        return robot;
    }

    public boolean moveRobot() {
        boolean valid = true;
        Position position = this.robot.getCurrentPosition();
        switch (position.getDirection()){
            case 'N':
                if(position.getY() == this.max_height) {
                    valid = false;
                } else {
                    position.setY(position.getY() + 1);
                }
                break;
            case 'W':
                if(position.getX() == 0) {
                    valid = false;
                } else {
                    position.setX(position.getX()-1);
                }
                break;
            case 'S':
                if(position.getY() == 0) {
                    valid = false;
                } else {
                    position.setY(position.getY() -1);
                }
                break;
            case 'E':
                if(position.getX() == this.max_width) {
                    valid = false;
                } else {
                    position.setX(position.getX() + 1);
                }
                break;
        }
        return valid;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public int getMaxWidth() {
        return this.max_width;
    }

    public int getMaxHeight() {
        return this.max_height;
    }

}
