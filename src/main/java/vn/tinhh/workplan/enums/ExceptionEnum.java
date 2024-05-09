package vn.tinhh.workplan.enums;

public class ExceptionEnum {


    public enum ErrorCode {
        NOT_FOUND_EXCEPTION(404),
        DUPLICATE_RECORD_FOUND(591);

        public final int code;

        private ErrorCode(int code) {
            this.code = code;
        }
    }
}
