# Copilot Instructions for Git Commits

Whenever generating a git commit message, follow the Conventional Commit format.

Format:
type(scope): short summary

Body:
- Bullet points explaining changes
- Mention important files changed
- Explain why the change was made

Types allowed:
feat     → new feature
fix      → bug fix
refactor → code restructuring
docs     → documentation
test     → tests
chore    → maintenance

Rules:
- Max 72 characters in title
- Use present tense
- Do not include unnecessary text
- Always describe impact of change

Example:

feat(auth): add JWT authentication middleware

- Implement token validation
- Add login endpoint
- Protect API routes

## Completion Verification Policy (Mandatory)

After every requirement completion (whether implemented from prompt-based guidance or manual code change), run project checks automatically before marking the task done.

### Minimum Checks
- `javac com/dds/learn/java/*.java`
- `java -cp . com.dds.learn.java.MissingNumbers`

### Feature/Area Checks
- If API code is changed:
	- `npm run test:integration -w apps/api`
	- `npm run build:api`
- If web code is changed:
	- `npm run build:web`

### Reporting Rule
- Always report check results in the completion update.
- If any check fails, do not mark the requirement complete until fixed or explicitly approved.

### Commit Rule
- Do not create a commit automatically unless requested by the user.
- When a commit is requested, follow the Conventional Commit format defined above.