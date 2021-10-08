package by.epam.task.command;

import by.epam.task.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request) throws CommandException;
}
