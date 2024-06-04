package vn.tinhh.workplan.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.tinhh.workplan.bases.BaseModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "party_login")
public class PartyLogin extends BaseModel {
    private String userName;
    private String password;
    private String preferenceId; // ID cua chu account
    private String preferenceType; // loai cua chu account (party or organization)
    private String status;
}
