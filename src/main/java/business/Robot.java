package business;

/**
 * Created by vinicius on 22/03/17.
 */
public interface Robot {
    void rotate(char side);
    Position getCurrentPosition();

    void turnLeft();
    void turnRight();
}
