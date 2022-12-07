package lotto.utils;

public class DataExtractor {

    private static final String DECIMAL_POINT = ".";
    private static final String COMMA = ",";
    private static final int START_INDEX = 0;
    private static final int UNIT_OF_COMMA_TO_BE_APPENDED = 3;
    private static final int NEXT_STEP_OF_COMMA_TO_BE_APPENDED = 4;

    public String extractIntegerPart(double data) {
        int indexDecimalPoint = String.valueOf(data).indexOf(DECIMAL_POINT);
        StringBuilder integerPart = new StringBuilder(String.valueOf(data).substring(START_INDEX, indexDecimalPoint));

        int indexToAppendComma = calIndexOfCommaToBeAppended(integerPart.length());

        while (indexToAppendComma < integerPart.length() - 1) {
            integerPart.insert(indexToAppendComma, COMMA);
            indexToAppendComma += NEXT_STEP_OF_COMMA_TO_BE_APPENDED;
        }

        return integerPart.toString();
    }

    public String extractDecimalPart(double data) {
        int indexDecimalPoint = String.valueOf(data).indexOf(DECIMAL_POINT);

        return String.valueOf(data).substring(indexDecimalPoint);
    }

    private int calIndexOfCommaToBeAppended(int length) {
        int indexToAppendComma = length % UNIT_OF_COMMA_TO_BE_APPENDED;

        if (indexToAppendComma == 0) {
            indexToAppendComma = UNIT_OF_COMMA_TO_BE_APPENDED;
        }

        return indexToAppendComma;
    }

}
