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
