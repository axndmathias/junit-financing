package test.entitites;

import entities.Financing;
import test.factory.FinancingFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    final double VALID_TOTAL_AMOUNT = 100000.00;
    final double VALID_INCOME = 2000.00;
    final int VALID_MONTHS = 80;

    final double VALID_SET_TOTAL_AMOUNT = 99999.99;
    final double VALID_SET_INCOME = 2000.01;
    final int VALID_SET_MONTHS = 81;

    final double INVALID_TOTAL_AMOUNT = 1000000.00;
    final double INVALID_INCOME = 1;
    final int INVALID_MONTHS = 20;

    @Test
    public void constructorShouldCreateObjectsCorrectlyWhenValidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();

        Assertions.assertEquals(fin.getTotalAmount(), VALID_TOTAL_AMOUNT);
        Assertions.assertEquals(fin.getIncome(), VALID_INCOME);
        Assertions.assertEquals(fin.getMonths(), VALID_MONTHS);
    }

    @Test
    public void constructorShouldThrowsIllegalArgumentExceptionWhenInvalidData() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = FinancingFactory.createFinancingWithInvalidDatas();
        });
    }

    @Test
    public void setTotalAmountShouldUpdateTheValuesWhenValidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        fin.setTotalAmount(VALID_SET_TOTAL_AMOUNT);
        Assertions.assertEquals(fin.getTotalAmount(), VALID_SET_TOTAL_AMOUNT);

    }

    @Test
    public void setTotalAmountShouldThorwsIllegalArgumentExceptionWhenInvalidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setTotalAmount(INVALID_TOTAL_AMOUNT);
        });
    }

    @Test
    public void setIncomeShouldUpdateIncomeWhenValidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        fin.setIncome(VALID_SET_INCOME);
        Assertions.assertEquals(fin.getIncome(), VALID_SET_INCOME);
    }

    @Test
    public void setIncomeShouldThrowsIllegalArgumentsExceptionWhenInvalidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setIncome(INVALID_INCOME);
        });
    }

    @Test
    public void setMonthsShouldUpdateWhenValidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        fin.setMonths(VALID_SET_MONTHS);
        Assertions.assertEquals(fin.getMonths(), VALID_SET_MONTHS);
    }

    @Test
    public void setMonthsShouldThrowIllegalArgumentsExceptionsWhenValidData() {
        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setMonths(INVALID_MONTHS);
        });
    }

    @Test
    public void entryShouldCalculateCorrectlyTheEntryValue() {
        double entry = VALID_TOTAL_AMOUNT * 0.2;

        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        double newEntry = fin.entry();
        Assertions.assertEquals(newEntry, entry);
    }

    @Test
    public void quotaShouldCalculateCorretlyTheQuotaValue() {
        double quota = (VALID_TOTAL_AMOUNT - (VALID_TOTAL_AMOUNT * 0.2)) / VALID_MONTHS;

        Financing fin = FinancingFactory.createFinancingWithValidDatas();
        double newQuota = fin.quota();
        Assertions.assertEquals(newQuota, quota);
    }

}
