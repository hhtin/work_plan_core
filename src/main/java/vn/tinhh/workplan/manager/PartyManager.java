package vn.tinhh.workplan.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import vn.tinhh.workplan.bases.BaseManager;
import vn.tinhh.workplan.entities.Party;

@Repository
public class PartyManager extends BaseManager<Party> {
    @Autowired
    public PartyManager(MongoTemplate mongoTemplate) {
        super(mongoTemplate,"party",Party.class);
    }
}
