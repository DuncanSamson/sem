# USE CASE 5: Add a New Employee

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to add a new employee’s details so that I can ensure the new employee is paid.

### Scope
Company.

### Level
Primary task.

### Preconditions
A hiring decision has been approved. HR has the new employee’s required data (name, start date, role, department, salary). Database is reachable.

### Success End Condition
The new employee exists in the system and appears in relevant reports (payroll, department, role).

### Failed End Condition
No record is created and payroll cannot process the employee.

### Primary Actor
HR Advisor.

### Trigger
HR receives a confirmed new-starter request from recruitment/manager.

## MAIN SUCCESS SCENARIO
1. HR opens the “Add Employee” form.
2. HR enters mandatory data (name, start date, department, role, salary).
3. System validates fields and calculates any defaults (e.g., employee number).
4. HR submits the form.
5. System stores the employee and returns the new employee ID.
6. System confirms creation to HR.

## EXTENSIONS
- 3a. Validation fails (missing/invalid fields):  
  -> System highlights errors, HR corrects and retries.
- 5a. Database unavailable:  
  -> System shows error and logs incident; HR retries later.

## SUB-VARIATIONS
- Optional fields (middle name, supervisor) may be provided now or later.

## SCHEDULE
DUE DATE: Release 1.0
