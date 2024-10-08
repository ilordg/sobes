package com.sobes.meetup.evaluation;

public class Fio {
    private final String name;
    private final String lastName;
    private final String patronym;
    Fio(final String name, final String lastName, final String patronym) {
        this.name = name;
        this.lastName = lastName;
        this.patronym = patronym;
    }

    public String shortForm() {
        return String.format("%s %s.%s.",
                this.lastName,
                Character.toUpperCase(this.name.charAt(0)),
                Character.toUpperCase(this.patronym.charAt(0))
        );
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.lastName, this.name, this.patronym);
    }
}
