package Hometask_12_06_2020;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void creation() {
        calculator = new Calculator();
    }

    @Test
    public void min() {
        int exRes = 5;
        int acRes = calculator.min(15, 10);
        Assert.assertEquals(exRes, acRes);
    }

    @Test
    public void sum() {
        int exRes = 25;
        int acRes = calculator.sum(10, 15);
        Assert.assertEquals(exRes, acRes);
    }

    @Test
    public void dev() {
        int exRes = 1;
        int acRes = calculator.dev(10, 10);
        Assert.assertEquals(exRes, acRes);
    }

    @Test
    public void mul() {
        int exRes = 25;
        int acRes = calculator.mul(5, 5);
        Assert.assertEquals(exRes, acRes);
    }

    @Test
    public void manyActions() {
        int exRes = 16;
        int acRes = calculator.manyActions(3, 2);
        Assert.assertEquals(exRes, acRes);
    }

    @AfterClass
    public void report(){
        System.out.println("Report is ready");
    }
}