# USE CASE 7: HR Advisor - Update an Employee Record

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to update an employee’s details so that employee’s details are kept up-to-date.

### Scope
Company.

### Level
Primary task.

### Preconditions
Employee exists. HR has edit permissions. Database is available.

### Success End Condition
Updated information is saved.

### Failed End Condition
No update is made; current state remains.

### Primary Actor
HR Advisor.

### Trigger
HR selects an employee to update.

## MAIN SUCCESS SCENARIO
* HR opens the employee record in edit mode. 
* HR changes necessary information (role, department, salary). 
* System validates changes. 
* HR submits the update. 
* System saves changes and confirms success.

## EXTENSIONS
* Invalid data: System asks for correction.
* No permission: Edit is blocked.
* Database error: System shows an error.

## SUB-VARIATIONS
None.

## SCHEDULE
DUE DATE: Release 1.0
