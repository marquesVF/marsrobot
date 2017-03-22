import business.*;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by vinicius on 22/03/17.
 */
public class RobotTests {
    private MarsTerrain terrain;
    private MarsRobot robot;

    @Before
    public void init_test(){
        terrain = new MarsTerrain(5, 5);
        robot = new MarsRobot();
        terrain.setRobot(robot);
    }

    @Test
    public void test_assert_equal_positions(){
        Position p1 = new Position(3, 3, Position.NORTH);
        Position p2 = new Position(3, 5, Position.NORTH);
        assertNotEquals(p1, p2);
        p2.setY(3);
        assertEquals(p1,p2);
    }

    @Test
    public void test_robot_valid_rotation(){
        MarsRobot robot = new MarsRobot();

        robot.turnLeft();
        robot.turnLeft();
        assertEquals(robot.getCurrentPosition().getDirection(), Position.SOUTH);
        robot.turnRight();
        assertEquals(robot.getCurrentPosition().getDirection(), Position.WEST);
        robot.turnRight();
        robot.turnRight();
        assertEquals(robot.getCurrentPosition().getDirection(), Position.EAST);
    }

    @Test
    public void test_robot_initial_valid_moves(){
        assertTrue(terrain.moveRobot());
        assertTrue(terrain.moveRobot());
        robot.rotate(Position.TURN_LEFT);
        Position final_position = new Position(0, 2, Position.WEST); // (0, 2, W)
        assertEquals(robot.getCurrentPosition(), final_position);
    }

    @Test
    public void test_valid_command_interpreter_MML(){
        assertTrue(CommandInterpreter.validadeCommand("MML", terrain));;
    }

    @Test
    public void test_valid_command_interpreter_MMMMRMMLM(){
        boolean valid = CommandInterpreter.validadeCommand("MMMMRMMLM", terrain);
        assertTrue(valid);
        assertEquals(terrain.getRobot().getCurrentPosition(), new Position(2, 5, Position.NORTH));
    }

    @Test
    public void test_invalid_outofbounderies_command_interpreter_MMMMRMMLMM(){
        boolean valid = CommandInterpreter.validadeCommand("MMMMRMMLMM", terrain);
        assertFalse(valid);
        assertEquals(terrain.getRobot().getCurrentPosition(), new Position(2, 5, Position.NORTH));
    }

}
