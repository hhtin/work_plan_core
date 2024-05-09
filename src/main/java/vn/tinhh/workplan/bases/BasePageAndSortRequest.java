package vn.tinhh.workplan.bases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePageAndSortRequest extends BasePageRequest{
    protected List<BaseSort> sort;
}
