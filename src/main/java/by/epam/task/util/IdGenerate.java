package by.epam.task.util;

import java.util.Random;

import static java.lang.Math.abs;

public class IdGenerate {
    public static Long generateId()
    {
        Random random = new Random();
        return abs(random.nextLong());
    }
}