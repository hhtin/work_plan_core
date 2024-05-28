package vn.tinhh.workplan.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;

@DgsComponent
public class LoginResolver {

    @DgsQuery(field = "testQuery")
    public String testQuery(@InputArgument String a) {
        return "a";
    }

    @DgsMutation(field = "testMutation")
    public String changeServiceName(@InputArgument String a) {
        return "a";
    }
}
