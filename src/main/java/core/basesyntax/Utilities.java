package core.basesyntax;

public class Utilities {
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] parseLine(String line) {
        return line.split(" ");
    }

    public int indexOfName(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public int[] parseDate(String date) {
        int[] result = new int[3];
        String[] splittedArray = date.split("\\.");

        for (int i = 0; i < splittedArray.length; i++) {
            result[i] = Integer.parseInt(splittedArray[i]);
        }

        return result;
    }

    private int toComparableInt(int[] dateParts) {
        int day = dateParts[0];
        int month = dateParts[1];
        int year = dateParts[2];

        return year * 10000 + month * 100 + day;
    }

    public boolean isDateInBound(String dateFrom, String dateTo, String currentDate) {
        int from = toComparableInt(parseDate(dateFrom));
        int to = toComparableInt(parseDate(dateTo));
        int current = toComparableInt(parseDate(currentDate));

        return current >= from && current <= to;
    }
}
