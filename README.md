# Github User Activity
This is an java application to check the user activities fo github changes with CLI.

#Project Url
https://roadmap.sh/projects/github-user-activity

# Features
User will get the last commits printed in console.

# How to use 
Clone the project
```bash
git clone https://github.com/Sharky0007/GithubUserActivity-CLI.git
```
Change the path to project path
```bash
cd GithubUserActivity-CLI
```
Place the jar file in classpath and compile the code 
```bash
javac -cp ".;lib/json-20250107.jar" .\UserActivityCLI.java <github-username>
```
Run java command
```bash
java -cp ".;lib/json-20250107.jar" .\UserActivityCLI.java <github-username>
```
