package app.opatches.patches.trivoga

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.SupportedAbi

object Constants {
    val COMPATIBILITY_TRIVOGA = Compatibility(
        name = "Trivoga (Повітряна тривога)",
        packageName = "com.ukrainealarm",
        apkFileType = ApkFileType.APK_REQUIRED,
        appIconColor = 0xE53935,
        signatures = setOf(
            // SHA-256 signature of the original Ukraine Alarm APK from Google Play
            "6cfd0e696cf64b85d67ffdaadfc9556f9f8384eb"
        ),
        targets = listOf(
            AppTarget(
                version = "7.2.2",
                minSdk = 21,
                isExperimental = false
            )
        )
    )
}