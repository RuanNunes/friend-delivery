package ruan.nunes.api;

import ruan.nunes.api.contract.FriendApi;
import ruan.nunes.domain.FriendEntity;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;


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
        for (int x = 0; x < 20000000; x++) {
            final var newentity = entity;
            newentity.id = null;
            newentity.setName("" + entity.getName().concat(String.valueOf(x)));
            newentity.persist();
        }
        return Response.ok(entity).build();
    }

    @Override
    public Response update(String name, FriendEntity newEntity) {
        return null;
    }

    @Override
    public Response delete(String name) {
        return null;
    }
}
