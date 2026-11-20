package app.opatches.patches.trivoga

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.InstructionLocation.MatchAfterImmediately
import app.morphe.patcher.patch.patch
import app.morphe.patcher.patch.loadPatchesFromJar
import com.android.tools.smali.dexlib2.AccessFlags

/**
 * Patch to bypass signature verification in Ukraine Alarm (Trivoga) app.
 * The signature verification is in class F1.e (obfuscated), method b.
 * It compares the computed signature against a hardcoded expected signature.
 * This patch makes the verification always pass by skipping the failure path.
 */
@Suppress("UNUSED_PARAMETER")
val signatureBypassPatch = patch(
    name = "Bypass Signature Verification",
    description = "Removes signature verification to allow repackaged APK to run",
    default = true
) {
    compatibleWith(Constants.COMPATIBILITY_TRIVOGA)

    execute {
        // Patch the signature verification in F1.e method b
        // The method compares computed signature against hardcoded expected signature
        // We skip the failure path by making the comparison always succeed
        Fingerprint(
            definingClass = "LF1/e;",
            name = "b",
            accessFlags = listOf(
                AccessFlags.PUBLIC,
                AccessFlags.STATIC
            ),
            returnType = "[B",
            parameters = listOf("[LF1/c;", "[B")
        ).method.addInstructions(
            // Add instructions at the point where the comparison result is checked
            // Original: if-eqz v2, :cond_1 (jump to failure if signatures don't match)
            // We replace this with a goto to the success path
            MatchAfterImmediately(),
            """
                # Skip the signature verification failure path
                # Original: if-eqz v2, :cond_1
                # Replace with: goto :goto_1 (always take success path)
                goto :goto_1
            """
        )
    }
}

/**
 * Alternative patch: Replace the Arrays.equals call to always return true
 */
val signatureBypassPatchAlt = patch(
    name = "Bypass Signature Verification (Alternative)",
    description = "Alternative approach: make Arrays.equals always return true",
    default = false
) {
    compatibleWith(Constants.COMPATIBILITY_TRIVOGA)

    execute {
        Fingerprint(
            definingClass = "LF1/e;",
            name = "b",
            accessFlags = listOf(
                AccessFlags.PUBLIC,
                AccessFlags.STATIC
            ),
            returnType = "[B",
            parameters = listOf("[LF1/c;", "[B")
        ).method.addInstructions(
            MatchAfterImmediately(),
            """
                # Make Arrays.equals always return true (0x1)
                const/4 v2, 0x1
                # Skip the original Arrays.equals call and the if-eqz check
                goto :goto_1
            """
        )
    }
}

/**
 * More aggressive patch: make the verification method always return the input signature
 * This completely bypasses the verification logic
 */
val signatureBypassPatchAggressive = patch(
    name = "Bypass Signature Verification (Aggressive)",
    description = "Make the verification method return input signature directly",
    default = false
) {
    compatibleWith(Constants.COMPATIBILITY_TRIVOGA)

    execute {
        Fingerprint(
            definingClass = "LF1/e;",
            name = "b",
            accessFlags = listOf(
                AccessFlags.PUBLIC,
                AccessFlags.STATIC
            ),
            returnType = "[B",
            parameters = listOf("[LF1/c;", "[B")
        ).method.addInstructions(
            0, // At the very beginning of the method
            """
                # Return the input signature directly, bypassing all verification
                move-object v0, p1
                return-object v0
            """
        )
    }
}

/**
 * Patch to also bypass the signature check in O/d class (font provider signature check)
 */
val fontProviderSignatureBypass = patch(
    name = "Bypass Font Provider Signature Check",
    description = "Bypass signature check in font provider (O/d class)",
    default = true
) {
    compatibleWith(Constants.COMPATIBILITY_TRIVOGA)

    execute {
        Fingerprint(
            definingClass = "LO/d;",
            name = "b",
            accessFlags = listOf(
                AccessFlags.PUBLIC,
                AccessFlags.STATIC
            ),
            returnType = "Landroid/content/pm/ProviderInfo;",
            parameters = listOf(
                "Landroid/content/pm/PackageManager;",
                "LO/e;",
                "Landroid/content/res/Resources;"
            )
        ).method.addInstructions(
            MatchAfterImmediately(),
            """
                # Skip the signature comparison in font provider
                # The method compares signatures at lines 153-155
                goto :cond_3
            """
        )
    }
}