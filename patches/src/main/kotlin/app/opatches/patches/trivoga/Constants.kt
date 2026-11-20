package app.opatches.patches.trivoga

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.SupportedAbi

object Constants {
    val COMPATIBILITY_TRIVOGA = Compatibility(
        name = "Trivoga (Повітряна тривога)",
        packageName = "com.ukrainealarm",
        apkFileType = ApkFileType.APK,
        appIconColor = 0xE53935, // Red color from app icon (0xRRGGBB format)
        targets = listOf(
            AppTarget(
                version = "7.2.2"
            )
        )
    )
}