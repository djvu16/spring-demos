package org.example.patterncommand.cmd;

import org.example.patterncommand.receiver.PerfectMatchDeleter;

public class PerfectMatchDeleteCommand implements Command{
    private final String name;
    private final PerfectMatchDeleter perfectMatchDeleter;

    public PerfectMatchDeleteCommand(String name, PerfectMatchDeleter perfectMatchDeleter) {
        this.name = name;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
        this.perfectMatchDeleter.delete(this.name);
    }
}
