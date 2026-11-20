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
        appIconColor = 0xFFE53935.toInt(), // Red color from app icon
        targets = listOf(
            AppTarget(
                version = "7.2.2"
            )
        )
    )
}