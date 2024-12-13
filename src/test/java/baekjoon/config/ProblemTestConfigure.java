package baekjoon.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class ProblemTestConfigure {

    protected abstract void test(String input, String actual) throws IOException;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    protected final void run(String input, String actual, ProblemInterface problemInterface)
        throws IOException {
        setInput(input);
        problemInterface.solution(null);
        assertEquals(removeSpaces(actual), removeSpaces(outContent.toString()));
    }

    protected final void run(
        String input,
        String actual,
        ProblemInterface problemInterface,
        double tolerance
    ) throws IOException {
        setInput(input);
        problemInterface.solution(null);
        assertEquals(Double.parseDouble(removeSpaces(actual)),
            Double.parseDouble(removeSpaces(outContent.toString())),
            tolerance);
    }

    private void setInput(String input) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(
            input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inContent);
    }

    private String removeSpaces(String input) {
        return input
            .lines()
            .map(String::stripTrailing)
            .reduce((s1, s2) -> s1 + "\n" + s2)
            .orElse("")
            .stripTrailing();
    }
}
