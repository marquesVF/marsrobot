package business;

/**
 * Created by vinicius on 22/03/17.
 */
public class CommandInterpreter {
    public static boolean validadeCommand(String command, Terrain terrain){
        boolean valid = true;
        for(final char c : command.toCharArray()){
            switch (c){
                case 'M':
                    valid = terrain.moveRobot();
                    break;
                case 'L':
                    terrain.getRobot().rotate(Position.TURN_LEFT);
                    break;
                case 'R':
                    terrain.getRobot().rotate(Position.TURN_RIGHT);
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
