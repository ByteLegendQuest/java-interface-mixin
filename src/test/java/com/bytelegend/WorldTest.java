package com.bytelegend;

import com.github.blindpirate.extensions.CaptureSystemOutput;
import com.github.hcsp.test.helper.ClassInspector;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorldTest {
    @Test
    @CaptureSystemOutput
    public void test1(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("Turtle is walking"));
        new Turtle("Turtle").walk();
    }

    @Test
    @CaptureSystemOutput
    public void test2(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("Turtle is swimming"));
        new Turtle("Turtle").swim();
    }

    @Test
    @CaptureSystemOutput
    public void test3(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("Fish is swimming"));
        new Fish("Fish").swim();
    }

    @Test
    @CaptureSystemOutput
    public void test4(CaptureSystemOutput.OutputCapture capture) {
        capture.expect(Matchers.containsString("Cat is walking"));
        new Cat("Cat").walk();
    }

    @Test
    public void mixedIn() {
        Assertions.assertTrue(Swimming.class.isAssignableFrom(Fish.class));
        Assertions.assertTrue(Walking.class.isAssignableFrom(Cat.class));
        Assertions.assertTrue(Swimming.class.isAssignableFrom(Turtle.class));
        Assertions.assertTrue(Walking.class.isAssignableFrom(Turtle.class));
    }

    @Test
    public void noExtraMethodsOrFields() {
        ClassInspector.assertNoDeclaredFields(Turtle.class);
        ClassInspector.assertNoDeclaredFields(Cat.class);
        ClassInspector.assertNoDeclaredFields(Fish.class);

        assertNoDeclaredMethods(Turtle.class);
        assertNoDeclaredMethods(Cat.class);
        assertNoDeclaredMethods(Fish.class);
    }

    private void assertNoDeclaredMethods(Class<?> clazz) {
        Assertions.assertEquals(0, clazz.getDeclaredMethods().length);
    }
}
