package app.opatches.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    // Placeholder compatibility - replace with your own
    val COMPATIBILITY_EXAMPLE = Compatibility(
        name = "Example App",
        packageName = "com.example.app",
        apkFileType = ApkFileType.APK,
        appIconColor = 0xFF0045,
        targets = listOf(
            AppTarget(version = "1.0.0")
        )
    )
}
