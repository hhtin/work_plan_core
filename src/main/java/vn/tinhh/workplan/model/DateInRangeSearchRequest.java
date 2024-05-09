package vn.tinhh.workplan.model;

import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DateInRangeSearchRequest {
    private Date date;
    private String fromDateField;
    private String toDateField;
}
