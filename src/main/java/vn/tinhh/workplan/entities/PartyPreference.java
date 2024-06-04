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
@Document(collection = "party_preference")
public class PartyPreference extends BaseModel {
    private String preferenceId; // ID lien quan // personId // loginId
    private String partyId;
    private String typePref; // FORGET_PASSWORD // VERIFY_SMS
    private String status;
    private String confirmValue; // PASSWORD can nhap
    private Date expiredDate;

}
