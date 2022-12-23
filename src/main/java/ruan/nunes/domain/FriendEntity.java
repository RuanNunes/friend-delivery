package ruan.nunes.domain;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@MongoEntity(collection = "friend")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendEntity extends PanacheMongoEntity {
    private String name;
    private String email;
    private String phone;
    private String slack_id;
    private String address;
//    public List<String> preferences;
//    public List<String> cant_be;
    public static FriendEntity findByName(String name){
        return find("name", name).firstResult();
    }
}
