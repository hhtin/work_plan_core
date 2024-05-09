package vn.tinhh.workplan.bases;

public class BaseException extends Exception{
    private int code;

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }
}
