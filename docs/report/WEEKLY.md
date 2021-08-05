# Sample 1

```
> Task :WeeklyRunner.main()

  Weekly Biorhythm Report
  Year: 2022, Week #34:

  Monday      Physical       14 %
  Aug 15      Emotional     -62 %
  2022        Intellectual   95 %

  Tuesday     Physical      -14 %
  Aug 16      Emotional     -43 %
  2022        Intellectual   87 %

  Wednesday   Physical      -40 %
  Aug 17      Emotional     -22 %
  2022        Intellectual   76 %

  Thursday    Physical      -63 %
  Aug 18      Emotional       0 %
  2022        Intellectual   62 %

  Friday      Physical      -82 %
  Aug 19      Emotional      22 %
  2022        Intellectual   46 %

  Saturday    Physical      -94 %
  Aug 20      Emotional      43 %
  2022        Intellectual   28 %

  Sunday      Physical     -100 %
  Aug 21      Emotional      62 %
  2022        Intellectual   10 %
```

### Format
```
format.weekly.top=\
%n  Weekly Biorhythm Report\
%n  Year: %d, Week #%d:%n

format.weekly.day=\
%n  %1$-11tA %2$s\
%n  %1$-4tb%1$-7td %3$s\
%n  %1$-11tY %4$s%n

format.weekly.biorhythm = %-12s %4d %%
```
