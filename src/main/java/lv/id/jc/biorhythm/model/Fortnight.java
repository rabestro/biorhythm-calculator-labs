package lv.id.jc.biorhythm.model;

import java.time.temporal.*;

public class Fortnight implements TemporalField {
    @Override
    public TemporalUnit getBaseUnit() {
        return null;
    }

    @Override
    public TemporalUnit getRangeUnit() {
        return null;
    }

    @Override
    public ValueRange range() {
        return null;
    }

    @Override
    public boolean isDateBased() {
        return true;
    }

    @Override
    public boolean isTimeBased() {
        return false;
    }

    @Override
    public boolean isSupportedBy(TemporalAccessor temporal) {
        return false;
    }

    @Override
    public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
        return null;
    }

    @Override
    public long getFrom(TemporalAccessor temporal) {
        return 0;
    }

    @Override
    public <R extends Temporal> R adjustInto(R temporal, long newValue) {
        return null;
    }
}
