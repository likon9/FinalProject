package by.epam.task.util;

import java.util.Objects;
import java.util.Random;

public class CodeGenerator {
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String NUMS = "0123456789";

    public static final String ALL_SYMBOL = UPPER  + NUMS;

    private Random random;

    private char[] symbols;

    private char[] buf;

    public CodeGenerator(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    public CodeGenerator(Random random) {
        this(5, random, ALL_SYMBOL);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */

}
