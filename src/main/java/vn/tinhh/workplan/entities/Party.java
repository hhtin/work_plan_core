package vn.tinhh.workplan.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.tinhh.workplan.bases.BaseModel;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "party")
public class Party extends BaseModel {
    private String partyGroupId; //Id cua to chuc
    private String fullName;
    private String status;
    private String gentle;
    private String phone;
    private String email;
    private String address;
    private Date dob;
    private String description;
}
