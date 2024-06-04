package vn.tinhh.workplan.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tinhh.workplan.bases.BaseController;
import vn.tinhh.workplan.controllers.PartyLoginController;
import vn.tinhh.workplan.entities.PartyLogin;
import vn.tinhh.workplan.manager.PartyLoginManager;

@Service
public class PartyLoginControllerImpl extends BaseController implements PartyLoginController {
    private final PartyLoginManager partyLoginManager;

    @Autowired
    public PartyLoginControllerImpl(PartyLoginManager partyLoginManager) {
        this.partyLoginManager = partyLoginManager;
    }

    public PartyLogin getById(String id) {
        return partyLoginManager.getById(id);
    }

    public PartyLogin create(PartyLogin partyLogin, String createBy) {
        return partyLoginManager.create(partyLogin, createBy);
    }
}
