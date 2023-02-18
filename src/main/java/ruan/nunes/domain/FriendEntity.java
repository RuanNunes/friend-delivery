package ruan.nunes.domain;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@MongoEntity(collection = "friend")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendEntity extends PanacheMongoEntity {
    private String name;
    private String nick_name;
    private String email;
    private String phone;
    private String slack_id;
    private String address;
//    public List<String> preferences;
//    public List<String> cant_be;
    public static FriendEntity findByName(String name){
        return find("name", name).firstResult();
    }
    public static void update(FriendEntity entity, FriendEntity newEntity){
        entity.setName(newEntity.getName() == null ? entity.getName() : newEntity.getName());
        entity.setEmail(newEntity.getEmail() == null ? entity.getEmail() : newEntity.getEmail());
        entity.setAddress(newEntity.getAddress() == null ? entity.getAddress() : newEntity.getAddress());
        entity.setPhone(newEntity.getPhone() == null ? entity.getPhone() : newEntity.getPhone());
        entity.setSlack_id(newEntity.getSlack_id() == null ? entity.getSlack_id() : newEntity.getSlack_id());
        entity.update();
    }
}
