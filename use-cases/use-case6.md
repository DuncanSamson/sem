# USE CASE 6: HR - I want to view and employee's details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to view an employee’s details so that the employee’s promotion request can be supported.

### Scope
Company.

### Level
Primary task.

### Preconditions
Employee exists in the database. User is authenticated and authorized.

### Success End Condition
Employee details are displayed.

### Failed End Condition
Employee record is not shown.

### Primary Actor
HR Advisor.

### Trigger
User searches for an employee or selects from a list.

## MAIN SUCCESS SCENARIO
* HR Advisor opens the View Employee option.
* HR Advisor enters employee name or ID.
* System finds the employee record.
* System displays details (name, department, role, salary).

## EXTENSIONS
* Employee not found: System informs the user.
* Database error: System shows an error. 
* Access denied: System blocks view and logs attempt.

## SUB-VARIATIONS
None.

## SCHEDULE
DUE DATE: Release 1.0
