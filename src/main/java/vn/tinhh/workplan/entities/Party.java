package vn.tinhh.workplan.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.tinhh.workplan.bases.BaseModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "party")
public class Party extends BaseModel {
    private String name;
}
