# USE CASE 3:  As an department manager I want to produce a report on the salary of employees in my department so that I can support financial reporting for my department
## CHARACTERISTIC INFORMATION

### Goal in Context
As a department manager I want to produce a report on the salary of employees in my department so that I can support financial reporting for my department
### **Scope**
Company.

### Level
Primary task.

### Preconditions
We know the role. Database contains current employee salary data.

### Success End Condition

A report is available for HR to provide to finance.

### Failed End Condition

No report is produced.

### Primary Actor

Department Manager.

### Trigger

A request for Salary Report is sent to Department Management.

### MAIN SUCCESS SCENARIO
*    Finance request salary report for specified employees.
*    Department Manager captures name of the role to get salary information for.
*    Department Manager extracts current salary information of all employees of the given role.
*    Department Manager provides report to finance.

### EXTENSIONS

* Role does not exist:
* Department Manager informs finance no role exists.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0