package vn.tinhh.workplan.controllers;

import vn.tinhh.workplan.entities.Party;

public interface PartyController {
    Party getById(String id);

    Party create(Party party, String createBy);
}
