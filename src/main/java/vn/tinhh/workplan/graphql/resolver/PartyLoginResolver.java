package vn.tinhh.workplan.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import vn.tinhh.workplan.controllers.PartyController;
import vn.tinhh.workplan.controllers.PartyLoginController;
import vn.tinhh.workplan.entities.Party;
import vn.tinhh.workplan.entities.PartyLogin;
import vn.tinhh.workplan.enums.StatusEnum;
import vn.tinhh.workplan.enums.TypeEnum;

import java.util.Date;

@DgsComponent
public class PartyLoginResolver {

    @Autowired
    private PartyLoginController partyLoginController;

    @DgsQuery(field = "partyLoginGetById")
    public PartyLogin partyLoginGetById(@InputArgument String id) {
        return partyLoginController.getById(id);
    }

    @DgsMutation(field = "partyLoginCreate")
    public PartyLogin partyLoginCreate(@InputArgument String performerId,
                             @InputArgument String userName,
                             @InputArgument String password,
                             @InputArgument String preferenceId,
                             @InputArgument String preferenceType) {
        return partyLoginController.create(PartyLogin.builder()
                        .userName(userName)
                        .password(password)
                        .preferenceId(preferenceId)
                        .preferenceType(preferenceType)
                        .status(StatusEnum.CommonStatus.ACTIVE.name())
                .build(), performerId);
    }
}
