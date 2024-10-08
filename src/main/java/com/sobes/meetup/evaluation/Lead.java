package com.sobes.meetup.evaluation;

/**
 * Класс описывает конкретного руководителя, который даёт оценку.
 */
public class Lead {
    private final Fio fio;
    Lead(final String name, final String lastName, final String patronym) {
        this.fio = new Fio(name, lastName, patronym);
    }

    // ОСТОРОЖНО, Персональные данные сотрудника Сбер
    public String getFio() {
        return this.fio.toString();
    }

    // ОСТОРОЖНО, Персональные данные сотрудника Сбер
    public String getShortFio() {
        return this.fio.shortForm();
    }
}
