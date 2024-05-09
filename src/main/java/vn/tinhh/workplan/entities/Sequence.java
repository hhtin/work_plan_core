package vn.tinhh.workplan.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.tinhh.workplan.bases.BaseModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sequence extends BaseModel {
    private long sequence;
}
