package com.sobes.meetup.evaluation;

/**
 * Класс описывает конкретные знания, навык которые могут проверяться.
 */
public class Skill {
    private final String name;
    private final String description;

    public Skill(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.name, this.description);
    }
}
