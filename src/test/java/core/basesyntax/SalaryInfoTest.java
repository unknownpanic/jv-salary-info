package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class SalaryInfoTest {
    private static final String[] roles = {"Сергей", "Андрей", "София"};
    private static final String[] scriptArray = {
            "25.04.2019 Сергей 60 50",
            "25.04.2019 Андрей 3 200",
            "25.04.2019 София 10 100",

            "26.04.2019 Андрей 3 200",
            "26.04.2019 София 9 100",

            "27.04.2019 Сергей 7 100",
            "27.04.2019 София 3 80",
            "27.04.2019 Андрей 8 100"
    };
    private static final String[] dates = {
            "24.04.2019",
            "25.04.2019",
            "26.04.2019",
            "27.04.2019"
    };
    private static final String[] correctResult = {
            "Отчёт за период 24.04.2019 - 24.04.2019\n" +
                    "Сергей - 0\n" +
                    "Андрей - 0\n" +
                    "София - 0\n",
            "Отчёт за период 24.04.2019 - 25.04.2019\n" +
                    "Сергей - 3000\n" +
                    "Андрей - 600\n" +
                    "София - 1000\n",
            "Отчёт за период 24.04.2019 - 26.04.2019\n" +
                    "Сергей - 3000\n" +
                    "Андрей - 1200\n" +
                    "София - 1900\n",
            "Отчёт за период 24.04.2019 - 27.04.2019\n" +
                    "Сергей - 3700\n" +
                    "Андрей - 2000\n" +
                    "София - 2140\n"
    };

    @Test
    public void getSalaryInfo() {
        SalaryInfo salary = new SalaryInfo();
        for (int i = 0; i < dates.length; i++) {
            String actualResult = salary.getSalaryInfo(roles, scriptArray, dates[0], dates[i]);
            String expectedResult = correctResult[i];

            Assert.assertEquals(
                    "Test failed from date " + dates[0] + " to " + dates[i]
                            + "\nactual: \n" + actualResult
                            + "\nexpected: \n" + expectedResult,
                    expectedResult,
                    actualResult);
        }

        String actualResult = salary.getSalaryInfo(roles, scriptArray, dates[1], dates[0]);
        String expectedResult = null;
        Assert.assertEquals(
                "Test failed from date " + dates[1] + " to " + dates[0]
                        + "\nactual: \n" + actualResult
                        + "\nexpected: \n" + expectedResult,
                expectedResult,
                actualResult);
    }
}
