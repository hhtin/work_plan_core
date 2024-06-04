package vn.tinhh.workplan.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import vn.tinhh.workplan.bases.BaseManager;
import vn.tinhh.workplan.entities.Party;
import vn.tinhh.workplan.entities.PartyGroup;

@Repository
public class PartyGroupManager extends BaseManager<PartyGroup> {

    @Autowired
    public PartyGroupManager(MongoTemplate mongoTemplate) {
        super(mongoTemplate, "party_group", PartyGroup.class);
    }
}
