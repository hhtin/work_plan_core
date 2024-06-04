package vn.tinhh.workplan.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import vn.tinhh.workplan.controllers.PartyController;
import vn.tinhh.workplan.entities.Party;
import vn.tinhh.workplan.enums.StatusEnum;
import vn.tinhh.workplan.enums.TypeEnum;

import java.util.Date;

@DgsComponent
public class PartyResolver {

    @Autowired
    private PartyController partyController;

    @DgsQuery(field = "partyGetById")
    public Party partyGetById(@InputArgument String id) {
        return partyController.getById(id);
    }

    @DgsMutation(field = "partyCreate")
    public Party partyCreate(@InputArgument String performerId,
                             @InputArgument String partyGroupId,
                             @InputArgument String fullName,
                             @InputArgument String gentle,
                             @InputArgument String phone,
                             @InputArgument String email,
                             @InputArgument String address,
                             @InputArgument Date dob) {
        return partyController.create(Party.builder()
                .partyGroupId(partyGroupId)
                .fullName(fullName)
                .status(StatusEnum.CommonStatus.ACTIVE.name())
                .gentle(gentle)
                .phone(phone)
                .email(email)
                .address(address)
                .dob(dob)
                .build(), performerId);
    }
}
