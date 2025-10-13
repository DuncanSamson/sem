# USE CASE 7: Update an Employee Record
## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to update an employee’s details so that employee’s details are kept up-to-date.

### Scope
Company.

### Level
Primary task.

### Preconditions
Employee exists. HR has authorization to edit. Database reachable.

### Success End Condition
Changes are saved and visible in subsequent views/reports.

### Failed End Condition
No update is made; current state remains.

### Primary Actor
HR Advisor.

### Trigger
Request to edit (e.g., role change, department move, salary change).

## MAIN SUCCESS SCENARIO
1. HR opens the employee record in edit mode.
2. HR modifies required fields (e.g., role/department/salary).
3. System validates changes (e.g., salary format, valid department).
4. HR submits the update.
5. System writes changes and confirms success.
6. System records an audit trail entry.

## EXTENSIONS
- 3a. Validation fails:  
  -> System highlights issues; HR fixes and resubmits.
- 5a. Database unavailable / write error:  
  -> System shows error and keeps old values; HR retries later.
- 1a. No permission:  
  -> System denies edit and logs attempt.

## SUB-VARIATIONS
- Effective-date updates (future-dated role/salary) if policy requires.

## SCHEDULE
DUE DATE: Release 1.0
