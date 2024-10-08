package com.sobes.meetup.evaluation;

/**
 * Класс описывает конкретного кандидата, которого оценивают
 */
public class Candidate {
    private final Fio fio;
    Candidate(final String name, final String lastName, final String patronym) {
        this.fio = new Fio(name, lastName, patronym);
    }

    // ОСТОРОЖНО, Персональные данные
    public String getFio() {
        return this.fio.toString();
    }

    // ОСТОРОЖНО, Персональные данные
    public String getShortFio() {
        return this.fio.shortForm();
    }
}
