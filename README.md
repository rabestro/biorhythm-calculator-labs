# Biorhythms Calculator

## About

This is a laboratory for creating a [training project](https://github.com/rabestro/biorhythm-calculator-labs/wiki). The goal is to create a tutorial project on working with dates in Java. The idea is to create a biorhythm calculator that allows you to select dates and print reports for different periods of time. We use the laboratory to come up with what the project will look like, what components it will consist of.

## Stages

The project is divided into [eight stages](/src/main/java/lv/id/jc/biorhythm/stage). At each stage, we need to implement certain functionality. After completing the last stage, we should get a fully working program.

## Components 

To achieve the goal, the concept of a system component was invented. The entire training project is broken down into many small sub-tasks. Each of these tasks is a separate class in this repository. To make it easier to manipulate different components, a common interface was created.

Each individual component can be [run, tested](/src/test/java/lv/id/jc/runner), and improved separately. A [special class](/src/test/java/lv/id/jc/runner/AbstractRunner.java) generates a random context for the component and you can see how the module behaves when working with different data. You can then assemble the components into a [working implementation](/src/main/java/lv/id/jc/biorhythm/stage) of each of the steps in the tutorial project.

## Command Processor

One of the main parts of the system is the [command processor](/src/main/java/lv/id/jc/biorhythm/service/CommandProcessor.java). The command processor accepts a list of components, and each component acts as a command. When the user enters a query, [each component is asked if it understands the command](https://github.com/rabestro/biorhythm-calculator-labs/blob/b4b150b12ad2bac32d87c0a3925afee2bfb9831f/src/main/java/lv/id/jc/biorhythm/service/CommandProcessor.java#L42). To do this, the component must [implement the predicate](https://github.com/rabestro/biorhythm-calculator-labs/blob/b4b150b12ad2bac32d87c0a3925afee2bfb9831f/src/main/java/lv/id/jc/biorhythm/command/MoveDate.java#L29), but the [default implementation](https://github.com/rabestro/biorhythm-calculator-labs/blob/b4b150b12ad2bac32d87c0a3925afee2bfb9831f/src/main/java/lv/id/jc/biorhythm/ui/Component.java#L46) is already in the abstract class. If the component understands the user's request, then it fulfills it. If none of the components understand the command, then the command processor prints error messages.
