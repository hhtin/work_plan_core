package vn.tinhh.workplan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.tinhh.workplan.controllers.PartyController;

@SpringBootTest
class WorkPlanCoreApplicationTests {
    @Autowired
    private PartyController partyController;

    @Test
    void contextLoads() {
    }

}
