package vn.tinhh.workplan.controllers;

import vn.tinhh.workplan.entities.PartyLogin;

public interface PartyLoginController {
    PartyLogin getById(String id);

    PartyLogin create(PartyLogin party, String createBy);
}
