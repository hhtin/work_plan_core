package vn.tinhh.workplan.controllers;

import vn.tinhh.workplan.entities.PartyGroup;

public interface PartyGroupController {
    PartyGroup getById(String id);

    PartyGroup create(PartyGroup party, String createBy);
}
