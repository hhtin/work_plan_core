package vn.tinhh.workplan.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import vn.tinhh.workplan.bases.BaseManager;
import vn.tinhh.workplan.entities.PartyGroup;
import vn.tinhh.workplan.entities.PartyLogin;

@Repository
public class PartyLoginManager extends BaseManager<PartyLogin> {

    @Autowired
    public PartyLoginManager(MongoTemplate mongoTemplate) {
        super(mongoTemplate, "party_login", PartyLogin.class);
    }
}
