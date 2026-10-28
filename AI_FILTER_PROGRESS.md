# AI Filter prototype

This branch is an experimental fork of SmartTube.

## Current status
- Added a separate Android product flavor, `stslop`, with application ID `dev.migmags.smarttube.aifilter`.
- **No AI-content filtering has been implemented yet.**
- The separate flavor has **not** been build-tested.

## Build experiment
The upstream GitHub Actions workflow currently builds `StbetaRelease`, which retains the upstream app ID. Do **not** install that build expecting a separate AI-filter app.

To experiment with the separate flavor after dependencies are checked:

```sh
./gradlew assembleStslopDebug
```

The project uses Git submodules. Clone with `--recurse-submodules` or run `git submodule update --init --recursive`.

## Planned filtering
Filtering video cards in home, search, subscriptions, and recommendations requires identifying the shared video-card processing layer. A keyword-based classifier can have false positives and cannot reliably identify every AI-generated video. Channel blocklists and an allowlist should be configurable.

This branch is a development prototype, not a ready-to-install APK.
