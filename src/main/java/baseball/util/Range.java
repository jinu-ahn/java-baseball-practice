package baseball.util;

public class Range {

    public enum Number {
        LOWER_RANGE(1),
        UPPER_RANGE(9);

        private final int range;

        Number(int range) {
            this.range = range;
        }

        public int getRange() {
            return this.range;
        }
    }

    public enum REGEXP {
        REGEXP("^[1-9]{3}$");

        private final String regexp;
        REGEXP(String regexp) {
            this.regexp = regexp;
        }

        public String getRegexp() {return this.regexp;}
    }
}
