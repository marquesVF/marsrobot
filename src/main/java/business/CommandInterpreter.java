package business;

/**
 * Created by vinicius on 22/03/17.
 */
public class CommandInterpreter {
    public static boolean validateCommand(String command, Terrain terrain){
        boolean valid = true;
        for(final char c : command.toCharArray()){
            switch (c){
                case 'M':
                    valid = terrain.moveRobot();
                    break;
                case 'L':
                    terrain.getRobot().turnLeft();
                    break;
                case 'R':
                    terrain.getRobot().turnRight();
                    break;
                default:
                    valid = false;
                    break;
            }
            if(!valid){
                return false;
            }
        }
        return true;
    }
}
