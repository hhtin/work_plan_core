package vn.tinhh.workplan.enums;

public class TypeEnum {

    public static enum LogActionType {
        CREATE("Tạo mới", 1),
        UPDATE("Cập nhật", 10),
        DELETE("Xóa", -1);

        private final String description;
        private final int code;

        public String getDescription() {
            return this.description;
        }

        public int getCode() {
            return this.code;
        }

        private LogActionType(final String description, final int code) {
            this.description = description;
            this.code = code;
        }
    }

    public enum PartyType{
        ACTIVE,
        INACTIVE
    }
}
