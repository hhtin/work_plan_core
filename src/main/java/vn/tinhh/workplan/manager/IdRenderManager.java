package vn.tinhh.workplan.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import vn.tinhh.workplan.entities.IdRender;

@Repository
@Getter
@Setter
@NoArgsConstructor
public class IdRenderManager {
    @Autowired
    private MongoTemplate mongoTemplate;
    protected String collectionName = "idRender";
    private String prefix = "10.";

    public String renderIdForAdd(String collection) {
        IdRender idRender = getById(collection);
        if (!ObjectUtils.isEmpty(idRender)) {
            long newSequence = idRender.getSequence() + 1L;
            Update update = new Update();
            update.set("sequence", newSequence);
            this.mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(collection)), update, this.collectionName);
            return prefix + newSequence;
        } else {
            this.mongoTemplate.insert(IdRender.builder().id(collection).sequence(1L).build(), this.collectionName);
            return prefix + 1;
        }
    }

    public IdRender getById(String id) {
        return this.mongoTemplate.findById(id, IdRender.class, this.collectionName);
    }


}
