package test;

import driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}