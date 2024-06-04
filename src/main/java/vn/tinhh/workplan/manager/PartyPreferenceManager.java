package vn.tinhh.workplan.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import vn.tinhh.workplan.bases.BaseManager;
import vn.tinhh.workplan.entities.PartyLogin;
import vn.tinhh.workplan.entities.PartyPreference;

@Repository
public class PartyPreferenceManager extends BaseManager<PartyPreference> {

    @Autowired
    public PartyPreferenceManager(MongoTemplate mongoTemplate) {
        super(mongoTemplate, "party_preference", PartyPreference.class);
    }
}
