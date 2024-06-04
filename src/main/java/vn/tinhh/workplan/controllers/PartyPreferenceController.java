package vn.tinhh.workplan.controllers;

import vn.tinhh.workplan.entities.PartyPreference;

public interface PartyPreferenceController {
    PartyPreference getById(String id);

    PartyPreference create(PartyPreference party, String createBy);
}
