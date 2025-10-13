# USE CASE 8: Delete an Employee Record

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to delete an employee’s details so that the company is compliant with data retention legislation.

### Scope
Company.

### Level
Primary task.

### Preconditions
Employee is eligible for deletion per policy (e.g., left company + retention window passed). HR has delete permission. Database reachable.

### Success End Condition
Record is deleted (or anonymised if policy requires), no longer visible in standard views/reports.

### Failed End Condition
Record remains; nothing is removed.

### Primary Actor
HR Advisor.

### Trigger
HR receives a verified request to remove data (e.g., policy-driven cleanup).

## MAIN SUCCESS SCENARIO
1. HR locates the employee record marked eligible for deletion.
2. System displays a clear warning and policy note.
3. HR confirms deletion.
4. System deletes (or anonymises) the record and related personal data.
5. System logs an audit entry and shows confirmation.

## EXTENSIONS
- 1a. Not eligible by policy:  
  -> System blocks action and explains reason.
- 4a. Referential constraints prevent deletion:  
  -> System suggests anonymisation or flags related records to clean first.
- 4b. Database error:  
  -> System shows error; HR retries later.

## SUB-VARIATIONS
- Hard delete vs. anonymisation according to compliance policy.

## SCHEDULE
DUE DATE: Release 1.0
