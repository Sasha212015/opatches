package app.opatches.patches.trivoga

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.patch.patch
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.loadPatchesFromJar
import com.android.tools.smali.dexlib2.AccessFlags

/**
 * Patch to bypass signature verification in Ukraine Alarm (Trivoga) app.
 * The signature verification is in a class with obfuscated name, method that does signature verification.
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
        // Try multiple possible class names for the signature verification class
        // The obfuscation changes between versions, so we try multiple patterns
        val possibleClasses = listOf(
            "LF1/e;",
            "LF1/f;",
            "LF1/d;",
            "LF1/c;",
            "LF1/b;",
            "LF1/a;",
            "LF2/e;",
            "LF2/d;",
            "LF3/e;",
            "LG3/O;",
            "LG3/X1;",
            "LG3/c0;",
            "LG3/y1;",
            "LO/d;",
            "LY4/a;",
            "Le0/c;",
            "Lg3/i;",
            "Lg3/l;",
            "Lx4/j;",
            "Lq5/c;",
            "Lt4/f;",
            "Lt5/h;",
            "Lo4/j;",
            "Lp5/c;",
            "Lq2/f;",
            "Lq2/e;",
            "Lq5/c;",
            "Ls2/d;",
            "Ls2/A;",
            "Ls2/q;",
            "Lt4/f;",
            "Lu2/e;",
            "Lx4/j;",
            "Ly2/c;",
            "Lz2/h;",
            "Lz2/g;",
            "Lz2/i;",
            "Lz2/u;",
            "Lz2/s;"
        )

        // Try the main signature verification class first
        for (className in possibleClasses) {
            try {
                Fingerprint(
                    definingClass = className,
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
                        # Skip the signature verification failure path
                        # Original: if-eqz v2, :cond_1 (jump to failure if signatures don't match)
                        # Replace with: goto :goto_1 (always take success path)
                        goto :goto_1
                    """
                )
            } catch (e: Exception) {
                // Class not found, try next one
            }
        }
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
        // Try multiple possible class names
        val possibleClasses = listOf(
            "LF1/e;",
            "LF1/f;",
            "LF1/d;",
            "LF1/c;",
            "LF1/b;",
            "LF1/a;",
            "LF2/e;",
            "LF2/d;",
            "LF3/e;",
            "LG3/O;",
            "LG3/X1;",
            "LG3/c0;",
            "LG3/y1;",
            "LO/d;",
            "LY4/a;",
            "Le0/c;",
            "Lg3/i;",
            "Lg3/l;",
            "Lx4/j;",
            "Lq5/c;",
            "Lt4/f;",
            "Lt5/h;",
            "Lo4/j;",
            "Lp5/c;",
            "Lq2/f;",
            "Lq2/e;",
            "Lq5/c;",
            "Ls2/d;",
            "Ls2/A;",
            "Ls2/q;",
            "Lt4/f;",
            "Lu2/e;",
            "Lx4/j;",
            "Ly2/c;",
            "Lz2/h;",
            "Lz2/g;",
            "Lz2/i;",
            "Lz2/u;",
            "Lz2/s;"
        )

        for (className in possibleClasses) {
            try {
                Fingerprint(
                    definingClass = className,
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
            } catch (e: Exception) {
                // Class not found, try next one
            }
        }
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
        // Try multiple possible class names
        val possibleClasses = listOf(
            "LF1/e;",
            "LF1/f;",
            "LF1/d;",
            "LF1/c;",
            "LF1/b;",
            "LF1/a;",
            "LF2/e;",
            "LF2/d;",
            "LF3/e;",
            "LG3/O;",
            "LG3/X1;",
            "LG3/c0;",
            "LG3/y1;",
            "LO/d;",
            "LY4/a;",
            "Le0/c;",
            "Lg3/i;",
            "Lg3/l;",
            "Lx4/j;",
            "Lq5/c;",
            "Lt4/f;",
            "Lt5/h;",
            "Lo4/j;",
            "Lp5/c;",
            "Lq2/f;",
            "Lq2/e;",
            "Lq5/c;",
            "Ls2/d;",
            "Ls2/A;",
            "Ls2/q;",
            "Lt4/f;",
            "Lu2/e;",
            "Lx4/j;",
            "Ly2/c;",
            "Lz2/h;",
            "Lz2/g;",
            "Lz2/i;",
            "Lz2/u;",
            "Lz2/s;"
        )

        for (className in possibleClasses) {
            try {
                Fingerprint(
                    definingClass = className,
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
                        # Return the input signature directly, bypassing all verification
                        move-object v0, p1
                        return-object v0
                    """
                )
            } catch (e: Exception) {
                // Class not found, try next one
            }
        }
    }
}