package app.opatches.patches.trivoga

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.patch
import app.opatches.patches.shared.Constants.COMPATIBILITY_EXAMPLE
import app.opatches.patches.trivoga.Constants.COMPATIBILITY_TRIVOGA

@Suppress("unused")
val trivogaPatch = patch(
    name = "Custom API Relay URL",
    description = "Replace air-save.ops.ajax.systems with custom relay server URL",
    default = true,
    category = "Network"
) {
    compatibleWith(COMPATIBILITY_TRIVOGA)

    execute {
        // Patch V5/I STAGE URL (air-save-b)
        BaseUrlFingerprint.method.addInstructions(
            0,
            """
                const-string p1, "https://trivoga.oleksandr.pp.ua/"
            """
        )

        // Patch V5/I PROD URL (air-save)
        ProdUrlFingerprint.method.addInstructions(
            0,
            """
                const-string p1, "https://trivoga.oleksandr.pp.ua/"
            """
        )

        // Patch V5/m STAGE URL
        V5mUrlFingerprint.method.addInstructions(
            0,
            """
                const-string v1, "https://trivoga.oleksandr.pp.ua/"
            """
        )

        // Patch V5/m PROD URL
        V5mProdUrlFingerprint.method.addInstructions(
            0,
            """
                const-string v1, "https://trivoga.oleksandr.pp.ua/"
            """
        )
    }
}
