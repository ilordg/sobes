package com.sobes.meetup.evaluation;

import com.sobes.meetup.logging.Logging;
import com.sobes.meetup.other.TimeRightNow;
import org.slf4j.Logger;

/**
 * Класс описывает оценку кандидата по конкретному пункту собеседования по мнению руководителя.
 */
public class EvaluationResult {
    private final static Logger LOG = Logging.get(EvaluationResult.class);

    private boolean locked = false;
    private TimeRightNow commitTime = null;

    private final Lead issuer;
    private final Candidate candidate;
    private final Skill skill;
    // Результат проверки
    private Mark mark = Mark.PENDING;
    // Возможные комментарии к оценке
    private String notes = "";

    // + можно загрузку результата из БД с вставкой locked

    EvaluationResult(final Lead issuer, final Candidate candidate, final Skill skill) {
        this.issuer = issuer;
        this.candidate = candidate;
        this.skill = skill;
    }
    
    public void setNotes(final String notes) {
        if (!this.locked)
            this.notes = notes;
        else
            LOG.warn("Tried to set notes after result is committed");
    }
    
    public void changeMark(final Mark newMark) {
        if (!this.locked)
            this.mark = newMark;
        else
            LOG.warn("Tried to change mark after result is committed");
    }

    @Override
    public String toString() {
        return String.format("%s: Кандидат %s, навык \"%s\": %s", this.issuer.getShortFio(), this.candidate.getShortFio(), this.skill.getName(), this.mark);
    }

    public void commit() {
        if (!this.locked) {
            this.locked = true;
            this.commitTime = new TimeRightNow();
        } else {
            LOG.warn("Can't commit twice");
        }
    }
}
