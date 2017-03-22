package business;

/**
 * Created by vinicius on 22/03/17.
 */
public interface Terrain {
    void setRobot(Robot robot);
    Robot getRobot();

    boolean moveRobot();
}
