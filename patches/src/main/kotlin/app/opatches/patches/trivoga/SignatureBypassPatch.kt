package app.opatches.patches.trivoga

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.InstructionLocation.MatchAfterImmediately
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.patch
import app.morphe.patcher.patch.loadPatchesFromJar
import app.morphe.patcher.opcode
import app.morphe.patcher.string
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
            parameters = listOf("[LF1/c;", "[B"),
            filters = listOf(
                // Match the first instruction: sget-object v2, LF1/e;->f:[B
                opcode(app.morphe.patcher.Opcode.SGET_OBJECT),
                // Match the next instruction: invoke-static {p1, v2}, Ljava/util/Arrays;->equals([B[B)Z
                app.morphe.patcher.methodCall(
                    definingClass = "Ljava/util/Arrays;",
                    name = "equals",
                    returnType = "Z",
                    parameters = listOf("[B", "[B")
                ),
                // Match the if-eqz check
                opcode(app.morphe.patcher.Opcode.IF_EQZ, MatchAfterImmediately())
            )
        ).method.addInstructions(
            0, // At the beginning of the method
            """
                # Skip the signature verification failure path
                # Original: if-eqz v2, :cond_1 (jump to failure if signatures don't match)
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
            0,
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