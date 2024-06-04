package vn.tinhh.workplan.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tinhh.workplan.bases.BaseController;
import vn.tinhh.workplan.controllers.PartyGroupController;
import vn.tinhh.workplan.entities.PartyGroup;
import vn.tinhh.workplan.manager.PartyGroupManager;

@Service
public class PartyGroupControllerImpl extends BaseController implements PartyGroupController {

    private final PartyGroupManager partyGroupManager;

    @Autowired
    public PartyGroupControllerImpl(PartyGroupManager partyGroupManager) {
        this.partyGroupManager = partyGroupManager;
    }

    public PartyGroup getById(String id) {
        return partyGroupManager.getById(id);
    }

    public PartyGroup create(PartyGroup partyGroup, String createBy) {
        return partyGroupManager.create(partyGroup, createBy);
    }
}
