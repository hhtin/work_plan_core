package vn.tinhh.workplan.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.tinhh.workplan.bases.BaseModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "party_group")
public class PartyGroup extends BaseModel {
    private String name;
    private String type;
    private String shortName;
    private String description;
    private String status;
}
