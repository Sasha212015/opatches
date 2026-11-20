# opatches

Custom Morphe patches repository.

## Patches

- **Trivoga (Повітряна тривога)** - Replace official API URL with custom relay server
  - Package: `com.ukrainealarm`
  - Version: 7.2.2
  - Replaces `air-save.ops.ajax.systems` → `https://trivoga.oleksandr.pp.ua/`

## Building

```bash
# Requires GitHub token with read:packages for Morphe plugin
export GITHUB_TOKEN=ghp_xxx
./gradlew build
```

Output: `patches/build/libs/*.mpp`

## Adding to Morphe Manager

1. Fork this repo to your GitHub
2. Enable GitHub Pages or use raw GitHub URL
3. In Morphe Manager: Settings → Patch Repositories → Add Repository
4. URL: `https://raw.githubusercontent.com/YOUR_USERNAME/opatches/main/patches-list.json`

## Structure

```
patches/src/main/kotlin/app/opatches/patches/
├── shared/
│   └── Constants.kt          # Shared compatibility definitions
└── trivoga/
    ├── Constants.kt          # Trivoga compatibility
    ├── Fingerprints.kt       # DEX fingerprints for URL locations
    └── TrivogaPatch.kt       # Main patch logic
```

## Patch Details

The Trivoga patch modifies 4 string constants in the DEX:
- `V5/I.d()` - STAGE URL (`air-save-b.ops.ajax.systems/`)
- `V5/I.d()` - PROD URL (`air-save.ops.ajax.systems/`)
- `V5/m.j()` - STAGE URL
- `V5/m.j()` - PROD URL

All replaced with `https://trivoga.oleksandr.pp.ua/`

<!-- PATCHES_START -->
<!-- PATCHES_END -->