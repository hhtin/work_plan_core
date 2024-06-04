package vn.tinhh.workplan.enums;

public class StatusEnum {

    public static enum RelatedObjectsStatus {
        ACTIVE(1),
        INACTIVE(0);

        final int value;

        private RelatedObjectsStatus(final int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CommonStatus{
        ACTIVE,
        INACTIVE
    }

}
