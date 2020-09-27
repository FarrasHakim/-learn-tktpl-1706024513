package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MainActivityUnitTest {
    @Test
    public void testGreetUserFunctoin() {
        String greeting = StaticFunctions.greetUser("Testy");
        assertEquals(greeting, "Hello there Testy!");
    }
}
