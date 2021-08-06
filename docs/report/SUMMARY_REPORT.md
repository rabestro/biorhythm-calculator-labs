# Summary Biorhythms Report

## Sample 

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

## Notes

The report uses 4 additional formatters
- [BiorhythmTemplateFormat](/src/main/java/report/format/BiorhythmTemplateFormat.java)
- OrdinalDateFormat
- DaysFormat
- MultilineTextFormat to split long lines to maximum width for a line 60 symbols