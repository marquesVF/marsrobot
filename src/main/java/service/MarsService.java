package service;

import business.CommandInterpreter;
import business.MarsRobot;
import business.MarsTerrain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vinicius on 22/03/17.
 */

@Controller
@EnableAutoConfiguration
public class MarsService {
    private MarsTerrain terrain;
    private MarsRobot robot;

    @RequestMapping(value = "/rest/mars/{command}")
    @ResponseBody
    public String moveRobot(@PathVariable String command){
        terrain = new MarsTerrain(5, 5);
        robot = new MarsRobot();
        terrain.setRobot(robot);

        if(CommandInterpreter.validateCommand(command, terrain)){
            return terrain.getRobot().getCurrentPosition().toString();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).getBody();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MarsService.class, args);
    }
}
