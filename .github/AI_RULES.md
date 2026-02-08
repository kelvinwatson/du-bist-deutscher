 # AI/Automation Rules

## Discovery and Compliance

- All AI/automation agents (including Copilot, ChatGPT, bots, etc.) must read and check this file before generating, editing, or committing code.
- AI/automation agents must follow all formatting, resource, and documentation rules as described here and in CONTRIBUTING.md.
- AI/automation agents must not introduce code that violates project conventions or best practices.
- **AI/automation agents must print a message to the chat or log before generating or editing code, such as:**
  - "Checking the rules in .github/AI_RULES.md and CONTRIBUTING.md before addressing your query..."
  - This message should be visible to users and reviewers to confirm compliance.
- **All publicly exposed methods, classes, and properties in non-UI code must have KDoc comments generated.**
- **If an interface only contains a single method, always generate it as a fun interface instead of a regular interface. This applies to all new code and refactors.**
- **Always explicitly specify the type for all Kotlin delegation (e.g., by ...collectAsState(), by lazy, by viewModels, etc.) project-wide.**
- **All generated Compose previews must use only @[Preview Generated Composable] (with square brackets, not @Preview or @Composable), and must be declared as internal fun. Do not use @Preview or @Composable for generated previews.**
- **When generating a composable that takes in viewModel properties and callbacks, declare it as internal. Always preserve and place all required annotations (such as @Composable) before the access modifier.**
- **The Modifier parameter should be the first optional parameter in all composable functions.**
- **Always add trailing commas for constructor invocations and function parameters.**
- **Never consume CoreColors directly. Always use semantically named colors from the Theme object (e.g., Theme.adjectiveCategoryColors.quality). If a semantically named color doesn't exist, create it in the appropriate color resources and color class.**
- **Use method references when possible (e.g., viewModel::someMethod instead of { viewModel.someMethod() }).**
- **Always call .asStateFlow() when exposing a MutableStateFlow as a StateFlow.**

## Formatting

- All code must be formatted before being committed.
- Use the project's formatter or linter (see CONTRIBUTING.md).
- Always format code after generating or editing it.

## Documentation

- Document any automated or AI-driven changes in commit messages or PR descriptions.
- Reference this file and CONTRIBUTING.md in all automation scripts or agent configurations.

---

Thank you for helping keep this project high quality!
