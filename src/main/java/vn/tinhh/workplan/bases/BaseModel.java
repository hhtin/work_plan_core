package vn.tinhh.workplan.bases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    @Id
    private String id;
    private Date createdStamp;
    private Date updatedStamp;
    private String updatedBy;
    private String createdBy;
}
