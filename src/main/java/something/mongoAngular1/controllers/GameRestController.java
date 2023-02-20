package something.mongoAngular1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Integral;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import something.mongoAngular1.models.Game;
import something.mongoAngular1.services.GameService;

@RestController
@RequestMapping(path = "/api/getbgg")
public class GameRestController {


    @Autowired GameService gameSvc;

    //GET METHOD 0 -- JUST FOR TESTING

    @GetMapping(path = "/justTesting")
    public ResponseEntity<String> randomJson(){

        JsonObjectBuilder myObjBuilder = Json.createObjectBuilder();

        JsonObject randomObject = myObjBuilder.add("you get this", "just for testing").build();


        return ResponseEntity.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(randomObject.toString());
    }

    //GET METHOD 3 -- get based on gameID and use gameID as the pathvariable
    @GetMapping (path = "/game/{gameId}")
    public ResponseEntity<String> searchByGameId(
        @PathVariable Integer gameId
    ){

        System.out.println("this is the gameID input>>>>>"+gameId);

        Game g = gameSvc.getGameById(gameId);

        //create an empty json object and add the values into the json object to be returned
        JsonObject myObject = Json.createObjectBuilder()
                                .add("gid", g.getGid())
                                .add("name", g.getName())
                                .add("year", g.getYear())
                                .add("ranking", g.getRanking())
                                .add("users_rated", g.getUsers_rated())
                                .add("url", g.getUrl())
                                .add("image", g.getImage())
                                .build();

                                return ResponseEntity.status(HttpStatus.OK)
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .body(myObject.toString());
    }

    //GET METHOD 4 -- get based on game ranking
    @GetMapping(path = "/rankingzxc")
    public ResponseEntity<String> getGameByRanking(
        @RequestParam(defaultValue = "7") Integer ranking
    ){

        Game g = gameSvc.getGameByRanking(ranking);

        JsonObject myJsonObject = Json.createObjectBuilder()
                                        .add("gid", g.getGid())
                                        .add("name", g.getName())
                                        .add("year", g.getYear())
                                        .add("ranking", g.getRanking())
                                        .add("users_rated", g.getUsers_rated())
                                        .add("url", g.getUrl())
                                        .add("image", g.getImage())
                                        .build();
        
        return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(myJsonObject.toString());
    }

    
}
