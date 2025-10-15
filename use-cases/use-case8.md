# USE CASE 8: HR Advisor - I Want to Delete an Employee Record

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to delete an employee’s details so that the company follows data protection rules.

### Scope
Company.

### Level
Primary task.

### Preconditions
Employee record exists and is eligible for deletion. HR has permission to delete. Database is available.

### Success End Condition
Record is deleted.

### Failed End Condition
Record remains; nothing is removed.

### Primary Actor
HR Advisor.

### Trigger
HR receives a request to delete an employee record.

## MAIN SUCCESS SCENARIO
* HR locates the employee record marked eligible for deletion.
* System shows a warning message. 
* HR confirms deletion. 
* System deletes the record. 
* System confirms completion.

## EXTENSIONS
* Not eligible for deletion: System blocks the action.
* Database error: System shows an error.

## SUB-VARIATIONS
None.

## SCHEDULE
DUE DATE: Release 1.0
