package vn.tinhh.workplan.exception;

import vn.tinhh.workplan.bases.BaseException;
import vn.tinhh.workplan.enums.ExceptionEnum;

public class DuplicateRecordFound extends BaseException {
    public DuplicateRecordFound(String message) {
        super(message, ExceptionEnum.ErrorCode.DUPLICATE_RECORD_FOUND.code);
    }
}
