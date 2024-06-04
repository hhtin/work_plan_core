package vn.tinhh.workplan.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tinhh.workplan.bases.BaseController;
import vn.tinhh.workplan.controllers.PartyController;
import vn.tinhh.workplan.entities.Party;
import vn.tinhh.workplan.manager.PartyManager;

@Service
public class PartyControllerImpl extends BaseController implements PartyController {

    private final PartyManager partyManager;

    @Autowired
    public PartyControllerImpl(PartyManager partyManager) {
        this.partyManager = partyManager;
    }

    public Party getById(String id) {
        return partyManager.getById(id);
    }

    public Party create(Party party, String createBy) {
        return partyManager.create(party,createBy);
    }
}
