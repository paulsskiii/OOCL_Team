# GitHub Branch Setup Guide

## 1. Naming Conventions

### Branch
- **Individual Branch**:  
  `[firstname-lastname]`  
  _Example:_ `Paul-Baesa`
- **Group Branch**:  
  `group-[group-Number-week(1,2,3....)/Team]`  
  _Example:_ `group-1-week2 or group-Bary` 

---

## 2. Folder / File Structure

### Individual Branch Example

```
.
├── day1/
│   ├── day1.md
│   ├── excer1_1/
│   ├── excer1_2/
│   ├── excer2_1/
│   └── assignment/
├── day2/
│   ├── day2.md
│   ├── excer1_1/
│   ├── excer1_2/
│   ├── excer2_1/
│   └── assignment/
└── day3/
    ├── day3.md
    ├── excer1_1/
    ├── excer1_2/
    ├── excer2_1/
    └── assignment/

```

### Group Branch Example

```
.
├── day01/
│ ├── project1
│ ├── project2
│ └── activity
├── day02/
│ ├── project1
│ ├── project2
│ └── activity
├── day03/
│ ├── project1
│ ├── project2
│ └── activity
└── GROUP_MEMBERS.md
```

---

## 3. Trainee Instructions

1. **Each trainee has their own personal Branch'**.  
   - You will **upload your individual work only to your own Branch**.  
   - Do **not** push code to the main Branch or any other trainee's Branch.

2. **For group activities**:  
   - You will work in your assigned **group Branch** for that week.  
   - Only the **group leader** will push the group's code to the `main` branch.  
   - Members can send their code to the leader or use pull requests.

3. **Daily workflow**:
   - Pull the latest changes from your own Branch:
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
   - Push changes to **your own Branch**:
     ```bash
     git push origin main
     ```

5. **Never push directly to the main Branch**.  
   Yes.

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
- Only the group leader will push code to the Branch.
- All members must contribute to exercises and assignments.