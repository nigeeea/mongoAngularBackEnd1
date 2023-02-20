package something.mongoAngular1.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import something.mongoAngular1.models.Game;

@Repository
public class GameRepository {

    @Autowired MongoTemplate myMongoTemplate;

    //GET METHOD 1 
    //GET METHOD 2


    //GET METHOD 3
    public Game getGameById(Integer gameId){
        Query query = new Query();
        query.addCriteria(Criteria.where("gid").is(gameId));
        org.bson.Document d = myMongoTemplate.findOne(query, org.bson.Document.class, "game");
        Game gameObject = new Game();

        gameObject.setGid(d.getInteger("gid"));
        gameObject.setImage(d.getString("image"));
        gameObject.setName(d.getString("name"));
        gameObject.setRanking(d.getInteger("ranking"));
        gameObject.setUrl(d.getString("url"));
        gameObject.setUsers_rated(d.getInteger("users_rated"));
        gameObject.setYear(d.getInteger("year"));

        return gameObject;

    }

    //GET BASED ON GAME RANKING - e.g. ?ranking=3
    public Game getByRanking(Integer ranking){
        Query query = new Query();
        query.addCriteria(Criteria.where("ranking").is(ranking));
        org.bson.Document d = myMongoTemplate.findOne(query, org.bson.Document.class, "game");
        Game gameObject = new Game();

        gameObject.setGid(d.getInteger("gid"));
        gameObject.setImage(d.getString("image"));
        gameObject.setName(d.getString("name"));
        gameObject.setRanking(d.getInteger("ranking"));
        gameObject.setUrl(d.getString("url"));
        gameObject.setUsers_rated(d.getInteger("users_rated"));
        gameObject.setYear(d.getInteger("year"));

        return gameObject;

    }
    
}
