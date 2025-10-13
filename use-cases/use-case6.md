# USE CASE 6: View an Employee Record

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to view an employee’s details so that the employee’s promotion request can be supported.
(Department managers may also view for their own staff).
### Scope
Company.
### Level
Primary task.

### Preconditions
Employee exists. User is authenticated and authorized.

### Success End Condition
Employee details are displayed (core data, current department/role/salary).

### Failed End Condition
Record not shown (not found or access denied).

### Primary Actor
HR Advisor (also Department Manager for their department).

### Trigger
User searches by employee ID/name or opens the record from a report.

## MAIN SUCCESS SCENARIO
1. User opens “View Employee”.
2. User enters employee ID (or selects from search results).
3. System retrieves the employee record.
4. System displays core details and current assignment (dept/role/salary).

## EXTENSIONS
- 2a. Employee not found:  
  -> System informs user; user searches again.
- 3a. Database unavailable:  
  -> System shows error; user retries later.
- 4a. Access denied (manager viewing outside dept):  
  -> System blocks view and logs attempt.

## SUB-VARIATIONS
- Search by name -> select exact employee.

## SCHEDULE
DUE DATE: Release 1.0
