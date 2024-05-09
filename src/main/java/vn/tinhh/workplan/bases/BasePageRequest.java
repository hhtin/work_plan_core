package vn.tinhh.workplan.bases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePageRequest {
    protected Integer pageNumber = 0;
    protected Integer pageSize = 10;
}
