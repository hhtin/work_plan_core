package vn.tinhh.workplan.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import vn.tinhh.workplan.controllers.PartyGroupController;
import vn.tinhh.workplan.entities.PartyGroup;
import vn.tinhh.workplan.enums.StatusEnum;

import java.util.Date;

@DgsComponent
public class PartyGroupResolver {

    @Autowired
    private PartyGroupController partyGroupController;

    @DgsQuery(field = "partyGroupGetById")
    public PartyGroup partyGroupGetById(@InputArgument String id) {
        return partyGroupController.getById(id);
    }

    @DgsMutation(field = "partyGroupCreate")
    public PartyGroup partyGroupCreate(@InputArgument String performerId,
                             @InputArgument String name,
                             @InputArgument String type,
                             @InputArgument String shortName,
                             @InputArgument String description) {
        return partyGroupController.create(PartyGroup.builder()
                        .name(name)
                        .type(type)
                        .shortName(shortName)
                        .description(description)
                        .status(StatusEnum.CommonStatus.ACTIVE.name())
                .build(), performerId);
    }
}
