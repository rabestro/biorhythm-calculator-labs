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
### Sample 3
```text
Today's Biorhythm Summary Report

Physical       94%
Emotional      62%
Intellectual   69%

Physical

Your are in a positive cycle for your physical attributes,
which ends on Wednesday, January 22nd (5 days). Take
advantage of your enhanced endurance, strength, toughness
and coordination while they are at their peak.
Your next Physical peak is on Saturday, February 8th (22 days)
Your next Physical low is on Monday, January 27th (10 days)

Emotional

Your are progressing in a positive cycle for your emotional
attributes, and this will last until Tuesday, January 28th
(11 days). Take advantage of your enhanced mood, sensitivity
and creativity!
Your next Emotional peak is on Tuesday, January 21st (4 days)
Your next Emotional low is on Tuesday, February 4th (18 days)

Intellectual

Your are progressing in a positive cycle for your
intellectual attributes, and this will last until Thursday,
January 30th (13 days). Take advantage of your enhanced
analytical thinking, logic, learning ability and memory!
Your next Intellectual peak is on Tuesday, January 21st (4 days)
Your next Intellectual low is on Friday, February 7th (21 days)
```

## Notes

The Summary Biorhythms Report uses 4 additional formatters
- [BiorhythmTemplateFormat](/src/main/java/lv/id/jc/biorhythm/format/BiorhythmFormat.java)
- [OrdinalDateFormat](/src/main/java/lv/id/jc/biorhythm/format/OrdinalDateFormat.java)
- [DaysFormat](/src/main/java/lv/id/jc/biorhythm/format/DaysFormat.java)
- [MultilineTextFormat](/src/main/java/lv/id/jc/biorhythm/format/MultilineTextFormat.java) to split long lines to maximum width for a line in 60 symbols
