# Git Workflow for Team Projects

This guide outlines a simple Git workflow for team projects, separating instructions for team leaders and team members.

---

## For Each Team Leader

1.  **Clone the repository** (if you haven't already):
    
    ```bash
    git clone <REPO_URL>
    cd <REPO_NAME>
    ```
2.  **Create a new branch** named after your team (e.g., `team-pol`):
    
    ```bash
    git checkout -b team-pol
    ```
3.  **Push the new branch** to the remote repository:
    
    ```bash
    git push origin team-pol
    ```
4.  **Share the branch name** with your team members (e.g., `team-pol`).

---

## For Each Team Member

1.  **Clone the repository** (if you haven't already):
    
    ```bash
    git clone <REPO_URL>
    cd <REPO_NAME>
    ```
2.  **Fetch all branches** from the remote repository:
    
    ```bash
    git fetch
    ```
3.  **Switch to your team's branch** (replace `team-pol` with your actual branch name):
    
    ```bash
    git checkout team-pol
    ```
4.  **(Optional) Set it to track the remote branch**: This makes future `git push` and `git pull` commands simpler.
    
    ```bash
    git branch --set-upstream-to=origin/team-pol
    ```