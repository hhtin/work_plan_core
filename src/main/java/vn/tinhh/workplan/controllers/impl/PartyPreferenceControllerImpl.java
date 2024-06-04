package vn.tinhh.workplan.controllers.impl;

import org.springframework.stereotype.Service;
import vn.tinhh.workplan.bases.BaseController;
import vn.tinhh.workplan.controllers.PartyPreferenceController;
import vn.tinhh.workplan.entities.PartyPreference;
import vn.tinhh.workplan.manager.PartyPreferenceManager;

@Service
public class PartyPreferenceControllerImpl extends BaseController implements PartyPreferenceController {
    private final PartyPreferenceManager partyPreferenceManager;

    public PartyPreferenceControllerImpl(PartyPreferenceManager partyPreferenceManager) {
        this.partyPreferenceManager = partyPreferenceManager;
    }

    public PartyPreference getById(String id) {
        return partyPreferenceManager.getById(id);
    }

    public PartyPreference create(PartyPreference partyPreference, String createBy) {
        return partyPreferenceManager.create(partyPreference, createBy);
    }
}
