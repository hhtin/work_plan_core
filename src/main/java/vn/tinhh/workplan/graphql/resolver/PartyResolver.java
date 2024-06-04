package vn.tinhh.workplan.graphql.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import vn.tinhh.workplan.controllers.IPartyController;
import vn.tinhh.workplan.entities.Party;
import vn.tinhh.workplan.enums.TypeEnum;

import java.util.Date;
import java.util.List;
import java.util.Map;

@DgsComponent
public class PartyResolver {

    @Autowired
    private IPartyController iPartyController;

    @DgsQuery(field = "partyGetById")
    public Party partyGetById(@InputArgument String id) {
        return iPartyController.getById(id);
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
        return iPartyController.create(Party.builder()
                .partyGroupId(partyGroupId)
                .fullName(fullName)
                .status(TypeEnum.PartyType.ACTIVE.name())
                .gentle(gentle)
                .phone(phone)
                .email(email)
                .address(address)
                .dob(dob)
                .build(), performerId);
    }
}
