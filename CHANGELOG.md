## [1.0.14](https://github.com/Sasha212015/opatches/compare/v1.0.13...v1.0.14) (2026-11-20)

### 🐛 Bug Fixes

* add downloadUrlTemplate to patches-bundle.json for Morphe Manager ([492e94f](https://github.com/Sasha212015/opatches/commit/492e94fdb6f155a015dd51bd4e9cc5bd98a90684))

## [1.0.13](https://github.com/Sasha212015/opatches/compare/v1.0.12...v1.0.13) (2026-11-20)

### 🐛 Bug Fixes

* ensure git push permissions for semantic-release notes ([df76148](https://github.com/Sasha212015/opatches/commit/df761487488fda87f5c13b06e8bfb0e5f6483ddd))

## [1.0.12](https://github.com/Sasha212015/opatches/compare/v1.0.11...v1.0.12) (2026-11-20)

### 🐛 Bug Fixes

* use cp instead of mv to keep original .mpp for attestation ([aa2e2f8](https://github.com/Sasha212015/opatches/commit/aa2e2f8779b8464f84457360d9c803bdf92c2677))

## [1.0.11](https://github.com/Sasha212015/opatches/compare/v1.0.10...v1.0.11) (2026-11-20)

### 🐛 Bug Fixes

* use gh CLI to upload .mpp with versioned filename ([257c101](https://github.com/Sasha212015/opatches/commit/257c1015047eb75e133caaf6cba271b9e9b2a74f))

## [1.0.10](https://github.com/Sasha212015/opatches/compare/v1.0.9...v1.0.10) (2026-11-20)

### 🐛 Bug Fixes

* use tag_name with softprops/action-gh-release to avoid upload_url requirement ([051d615](https://github.com/Sasha212015/opatches/commit/051d615ed33b8fd2a441642b903452165e79b614))

## [1.0.9](https://github.com/Sasha212015/opatches/compare/v1.0.8...v1.0.9) (2026-11-20)

### 🐛 Bug Fixes

* upload .mpp with versioned name (patches-${version}.mpp) to match patches-bundle.json template ([b140489](https://github.com/Sasha212015/opatches/commit/b140489e41c3c08be8821d260c273f6a0a29aedc))

## [1.0.8](https://github.com/Sasha212015/opatches/compare/v1.0.7...v1.0.8) (2026-11-20)

### 🐛 Bug Fixes

* use tag_name with softprops/action-gh-release instead of upload_url ([f3403d6](https://github.com/Sasha212015/opatches/commit/f3403d6f00bf366d039fcdb41a8b5e110c8ada99))

## [1.0.7](https://github.com/Sasha212015/opatches/compare/v1.0.6...v1.0.7) (2026-11-20)

### 🐛 Bug Fixes

* use upload-release-asset with upload_url for reliable asset upload ([5bb895a](https://github.com/Sasha212015/opatches/commit/5bb895a1658553a6d7d03567b1bfb1e173d57307))

## [1.0.6](https://github.com/Sasha212015/opatches/compare/v1.0.5...v1.0.6) (2026-11-20)

### 🐛 Bug Fixes

* use softprops/action-gh-release for reliable asset upload without upload_url ([43f974a](https://github.com/Sasha212015/opatches/commit/43f974a2eeea1b69b71d3a0fc569a859b69316d9))

## [1.0.5](https://github.com/Sasha212015/opatches/compare/v1.0.4...v1.0.5) (2026-11-20)

### 🐛 Bug Fixes

* use upload_url from semantic-release output for asset upload ([d27ebb2](https://github.com/Sasha212015/opatches/commit/d27ebb2ed23ca3bb1159178418c54c493b3bee78))

## [1.0.4](https://github.com/Sasha212015/opatches/compare/v1.0.3...v1.0.4) (2026-11-20)

### 🐛 Bug Fixes

* use softprops/action-gh-release for reliable asset upload ([ca31743](https://github.com/Sasha212015/opatches/commit/ca3174337dec4cfed768e8d7aea378086bbc4cc6))

## [1.0.3](https://github.com/Sasha212015/opatches/compare/v1.0.2...v1.0.3) (2026-11-20)

### 🐛 Bug Fixes

* build patches before semantic-release, upload .mpp manually ([3e6403e](https://github.com/Sasha212015/opatches/commit/3e6403ea46934a69ef74aad745d236b8e09a1656))

## [1.0.2](https://github.com/Sasha212015/opatches/compare/v1.0.1...v1.0.2) (2026-11-20)

### 🐛 Bug Fixes

* add GitHub Packages auth for Gradle in CI ([d99ff53](https://github.com/Sasha212015/opatches/commit/d99ff530d9ef4fc5891f9676affb6668f9909ed2))
* use env vars for GitHub Packages auth, don't write token to gradle.properties ([7af2e3d](https://github.com/Sasha212015/opatches/commit/7af2e3dea23365520177d95d34263be5b41d825a))

## [1.0.1](https://github.com/Sasha212015/opatches/compare/v1.0.0...v1.0.1) (2026-11-20)

### 🐛 Bug Fixes

* appIconColor must be 0xRRGGBB format (no alpha) ([a82b7fb](https://github.com/Sasha212015/opatches/commit/a82b7fbca770600b84e82b7d47562979dd1d0b41))
* run buildAndroid then generatePatchesList in prepareCmd ([8732d3c](https://github.com/Sasha212015/opatches/commit/8732d3c92a6a7c0f882ffb4edc2782bee81c51ec))
* run generatePatchesList after build to populate patches-list.json ([36994ff](https://github.com/Sasha212015/opatches/commit/36994ff2da4013b235fd5a7ff3535bf28ffb42f9))
* use tasks { ... } DSL for finalizedBy ([20c53a0](https://github.com/Sasha212015/opatches/commit/20c53a07b11444a1b75ef3b2ea474475d6a30407))
* use tasks.named(...).configure for finalizedBy ([35b331d](https://github.com/Sasha212015/opatches/commit/35b331db408721fc7f1f30952c686f01ca6caf97))

## 1.0.0 (2026-11-20)

### ✨ New Features

* add Trivoga patch with custom relay URL support ([39a5d13](https://github.com/Sasha212015/opatches/commit/39a5d13feebfc3ed4608a3dc6489759766026efe))

### 🐛 Bug Fixes

* depend generatePatchesList on buildAndroid instead of build ([61b9b15](https://github.com/Sasha212015/opatches/commit/61b9b15b5975b1d0f9a3fe77144207af03168007))
* simplify prepareCmd to just gradle build ([28b143e](https://github.com/Sasha212015/opatches/commit/28b143e7cc154b49bad09a53e592471db8897089))
