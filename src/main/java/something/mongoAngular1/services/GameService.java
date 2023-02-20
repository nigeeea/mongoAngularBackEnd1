package something.mongoAngular1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import something.mongoAngular1.models.Game;
import something.mongoAngular1.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepo;


    //GET METHOD 3
    public Game getGameById(Integer gameId){
        return gameRepo.getGameById(gameId);
    }

    //GET METHOD 4
    public Game getGameByRanking(Integer ranking){
        return gameRepo.getByRanking(ranking);
    }
    
}
