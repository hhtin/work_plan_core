package vn.tinhh.workplan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.tinhh.workplan.controllers.IPartyController;
import vn.tinhh.workplan.entities.Party;

@SpringBootTest
class WorkPlanCoreApplicationTests {
    @Autowired
    private IPartyController iPartyController;

    @Test
    void contextLoads() {
        iPartyController.create(Party.builder().name("test2").build(), "SYSTEM");
    }

}
