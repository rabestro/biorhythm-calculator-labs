# Summary Biorhythms Report

## Sample 1

```text
> Task :SummaryRunner.main()

Today's Biorhythm Summary Report

Physical      -98%
Emotional     -62%
Intellectual   37%

Physical

Your are in a negative physical cycle, but it coming to an
end on Thursday, May 24th (5 days)! Work on improving your
endurance, strength, toughness and coordination as you near
your next positive cycle!

Emotional

Your are in a negative cycle for your emotional attributes,
which ends on Wednesday, May 30th (11 days). Your mood,
sensitivity and creativity may not be at their highest, so
it is a good opportunity to work on them!

Intellectual

Your are progressing in a positive cycle for your
intellectual attributes, and this will last until Sunday,
June 3rd (15 days). Take advantage of your enhanced
analytical thinking, logic, learning ability and memory!

```
## Sample 2

```text
> Task :SummaryRunner.main()

Today's Biorhythm Summary Report

Physical       27%
Emotional     -22%
Intellectual   99%

Physical

Your are progressing in a positive cycle for your physical
attributes, and this will last until Saturday, December 11th
(11 days). Take advantage of your enhanced endurance,
strength, toughness and coordination!

Emotional

Your are in a negative emotional cycle, but it coming to an
end on Wednesday, December 1st (tomorrow)! Work on improving
your mood, sensitivity and creativity as you near your next
positive cycle!

Intellectual

Your are in a positive cycle for your intellectual
attributes, which ends on Wednesday, December 8th (8 days).
Take advantage of your enhanced analytical thinking, logic,
learning ability and memory while they are at their peak.
```
## Notes

The lv.id.jc.biorhytm.report uses 4 additional formatters
- [BiorhythmTemplateFormat](/src/main/java/lv.id.jc.biorhytm.report/format/BiorhythmTemplateFormat.java)
- [OrdinalDateFormat](/src/main/java/lv.id.jc.biorhytm.report/format/OrdinalDateFormat.java)
- [DaysFormat](/src/main/java/lv.id.jc.biorhytm.report/format/DaysFormat.java)
- [MultilineTextFormat](/src/main/java/lv.id.jc.biorhytm.report/format/MultilineTextFormat.java) to split long lines to maximum width for a line in 60 symbols