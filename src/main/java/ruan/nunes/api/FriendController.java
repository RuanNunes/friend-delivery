package ruan.nunes.api;
import ruan.nunes.api.contract.FriendApi;
import ruan.nunes.domain.FriendEntity;
import javax.ws.rs.core.Response;
import java.util.List;

public class FriendController implements FriendApi {
    @Override
    public List<FriendEntity> get() {
        return FriendEntity.listAll();
    }

    @Override
    public FriendEntity findByName(String name) {
        return FriendEntity.findByName(name);
    }

    @Override
    public Response create(FriendEntity entity) {
        if(entity == null || entity.getName() == null){
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        if( FriendEntity.findByName(entity.getName()) != null){
            return Response.status(Response.Status.CONFLICT).build();
        }

        entity.persist();
        return Response.ok(entity).build();
    }

    @Override
    public Response update(String name, FriendEntity newEntity) {
        if(newEntity == null){
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        final var entity = FriendEntity.findByName(name);
        if(entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        FriendEntity.update(entity, newEntity);
        return Response.ok(entity).build();
    }

    @Override
    public Response delete(String name) {
        final var entity = FriendEntity.findByName(name);
        if (entity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }
}
