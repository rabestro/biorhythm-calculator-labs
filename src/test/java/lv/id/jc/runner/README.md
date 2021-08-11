# Report Runners

This directory contains biorhythms runners to check and test components. 

`AbstractRunner` class prepare context for the tested component. It generates random birthday and random date. The abstract class has a static variable `runner` that must be set in order to run and test the component in children xxxRunner classes. 

It is possible to test one separate component or multiple components as one. It is possible to configure components before run. 


