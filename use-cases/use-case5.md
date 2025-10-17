# USE CASE 5: I want to add a new employee's details.

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to add a new employee’s details so that I can ensure the new employee is paid.

### Scope
Company.

### Level
Primary task.

### Preconditions
A hiring decision has been approved. HR has the new employee’s basic information. The database is available.

### Success End Condition
A new employee record is created in the system.

### Failed End Condition
No record is created.

### Primary Actor
HR Advisor.

### Trigger
HR receives a request to add a new employee.

## MAIN SUCCESS SCENARIO
* HR opens the “Add Employee” form. 
* HR enters mandatory data (name, start date, department, role, salary). 
* System validates the information.
* HR submits the form. 
* System saves the new record.
* HR receives confirmation.

## EXTENSIONS
* Missing or invalid data: HR corrects and resubmits.
* Database unavailable: System shows an error; HR retries later.

## SUB-VARIATIONS
None.

## SCHEDULE
DUE DATE: Release 1.0
