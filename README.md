# GitHub Repository Setup Guide

## 1. Naming Conventions

### Repositories
- **Individual Repo**:  
  `[firstname-lastname]`  
  _Example:_ `Paul-Baesa`
- **Group Repo**:  
  `group-[dayNumber]-[groupNumber/Team]`  
  _Example:_ `group-Day02 or group-Bary` 

---

## 2. Folder / File Structure

### Individual Repo Example
.
├── day1/
│ ├── day1.md
│ ├── excer1_1/
│ ├── excer1_2/
│ ├── excer2_1/
│ └── assignment/
├── day2/
│ ├── day2.md
│ ├── excer1_1/
│ ├── excer1_2/
│ ├── excer2_1/
│ └── assignment/
├── day3/
│ ├── day3.md
│ ├── excer1_1/
│ ├── excer1_2/
│ ├── excer2_1/
│ └── assignment/


### Group Repo Example
.
├── day01/
│ ├── project1/
│ ├── project2/
│ └── activity/
├── day02/
│ ├── project1/
│ ├── project2/
│ └── activity/
├── day03/
│ ├── project1/
│ ├── project2/
│ └── activity/
└── GROUP_MEMBERS.md
---

## 3. Trainee Instructions

1. **Each trainee has their own personal repository**.  
   - You will **upload your individual work only to your own repo**.  
   - Do **not** push code to the main repository or any other trainee's repository.

2. **For group activities**:  
   - You will work in your assigned **group repository** for that week.  
   - Only the **group leader** will push the group's code to the `main` branch.  
   - Members can send their code to the leader or use pull requests.

3. **Daily workflow**:
   - Pull the latest changes from your own repo:
     ```bash
     git pull origin main
     ```
   - Work inside the correct day's folder (`day1`, `day2`, `day3`, etc.).
   - Save exercises in the `excer1_1`, `excer1_2`, `excer2_1` .... folders.
   - Save assignments in the `assignment` folder.

4. **Committing changes**:
   - Stage and commit your work with a clear message:
     ```bash
     git add .
     git commit -m "Completed excer1_1 for day2"
     ```
   - Push changes to **your own repository**:
     ```bash
     git push origin main
     ```

5. **Never push directly to the teacher's repository**.  
   The teacher's repo is **read-only** for trainee.

---

4. Markdown Template — GROUP_MEMBERS.md
# Group Members

| Name              | Role                | GitHub Username      |
|-------------------|---------------------|----------------------|
| Paul Baesa        | Group Leader        | @paulbaesa           |
| Max Verstappen    | Developer           | @maxverstappen       |
| Charles Leclerc   | Documentation Lead  | @charlesleclerc      |
| Oscar Piastri     | Tester              | @oscarpiastri        |

## Notes
- Only the group leader will push code to the repository.
- All members must contribute to exercises and assignments.