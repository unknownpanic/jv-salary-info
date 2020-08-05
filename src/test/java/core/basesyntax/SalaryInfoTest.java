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
    private static final String[] exceptedReports = {
            "Отчёт за период 24.04.2019 - 24.04.2019\n" +
                    "Сергей - 0\n" +
                    "Андрей - 0\n" +
                    "София - 0",
            "Отчёт за период 24.04.2019 - 25.04.2019\n" +
                    "Сергей - 3000\n" +
                    "Андрей - 600\n" +
                    "София - 1000",
            "Отчёт за период 24.04.2019 - 26.04.2019\n" +
                    "Сергей - 3000\n" +
                    "Андрей - 1200\n" +
                    "София - 1900",
            "Отчёт за период 24.04.2019 - 27.04.2019\n" +
                    "Сергей - 3700\n" +
                    "Андрей - 2000\n" +
                    "София - 2140"
    };

    private static final String[] secondScriptArray = {
            "13.07.2019 Сергей 60 50",
            "15.07.2019 Андрей 3 200",
            "15.07.2019 София 10 100",

            "16.07.2019 Андрей 3 200",
            "16.07.2019 София 9 100",

            "10.08.2019 Сергей 7 100",
            "08.08.2019 София 3 80",
            "11.08.2019 Андрей 8 100"
    };
    private static final String[] secondDates = {
            "14.07.2019",
            "10.08.2019",
    };
    private static final String secondExceptedReports =
            "Отчёт за период 14.07.2019 - 10.08.2019\n" +
                    "Сергей - 700\n" +
                    "Андрей - 1200\n" +
                    "София - 2140";

    @Test
    public void getSalaryInfoByMonth() {
        SalaryInfo salary = new SalaryInfo();
        for (int i = 0; i < dates.length; i++) {
            String actualResult = salary.getSalaryInfo(roles, scriptArray, dates[0], dates[i]);
            String expectedResult = SalaryInfoTest.exceptedReports[i];

            Assert.assertEquals(
                    "Test failed from date " + dates[0] + " to " + dates[i]
                            + "\nactual: \n" + actualResult
                            + "\nexpected: \n" + expectedResult,
                    expectedResult,
                    actualResult);
        }
    }

    @Test
    public void getSalaryInfoByTwoMonths() {
        SalaryInfo salary = new SalaryInfo();
        String actualResult = salary.getSalaryInfo(roles, secondScriptArray,
                secondDates[0], secondDates[1]);
        String expectedResult = SalaryInfoTest.secondExceptedReports;

        Assert.assertEquals(
                "Test failed from date " + secondDates[0] + " to " + secondDates[1]
                        + "\nactual: \n" + actualResult
                        + "\nexpected: \n" + expectedResult,
                expectedResult,
                actualResult);
    }
}
