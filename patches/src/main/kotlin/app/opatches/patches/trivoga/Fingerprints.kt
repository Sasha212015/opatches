package app.opatches.patches.trivoga

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.InstructionLocation.MatchAfterImmediately
import app.morphe.patcher.literal
import app.morphe.patcher.methodCall
import app.morphe.patcher.opcode
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Fingerprints for V5/I class - contains the base URL switching logic
 * Method: d(Lz6/o;LR6/c;)Ljava/lang/Object;
 * Contains two const-string instructions for STAGE and PROD URLs
 */
object BaseUrlFingerprint : Fingerprint(
    definingClass = "LV5/I;",
    name = "d",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Lz6/o;", "LR6/c;"),
    filters = listOf(
        // Find the STAGE check: sget-object p2, Lz6/o;->STAGE:Lz6/o;
        opcode(Opcode.SGET_OBJECT),

        // Match immediately after: if-ne p1, p2, :cond_9
        opcode(Opcode.IF_NE, MatchAfterImmediately()),

        // Match the const-string for air-save-b (STAGE URL)
        string("https://air-save-b.ops.ajax.systems/"),
    )
)

/**
 * Fingerprint for the PROD URL in V5/I
 * Same method, second const-string
 */
object ProdUrlFingerprint : Fingerprint(
    definingClass = "LV5/I;",
    name = "d",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Lz6/o;", "LR6/c;"),
    filters = listOf(
        // Find the second STAGE check branch
        opcode(Opcode.SGET_OBJECT),

        // Match the const-string for air-save (PROD URL)
        string("https://air-save.ops.ajax.systems/"),
    )
)

/**
 * Fingerprint for V5/m class - contains additional URL references
 * Method: j(Ljava/lang/Object;LP6/d;)Ljava/lang/Object;
 */
object V5mUrlFingerprint : Fingerprint(
    definingClass = "LV5/m;",
    name = "j",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Ljava/lang/Object;", "LP6/d;"),
    filters = listOf(
        // Find the STAGE check
        opcode(Opcode.SGET_OBJECT),

        // Match the const-string for air-save-b
        string("https://air-save-b.ops.ajax.systems/"),
    )
)

/**
 * Fingerprint for the PROD URL in V5/m
 */
object V5mProdUrlFingerprint : Fingerprint(
    definingClass = "LV5/m;",
    name = "j",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    returnType = "Ljava/lang/Object;",
    parameters = listOf("Ljava/lang/Object;", "LP6/d;"),
    filters = listOf(
        // Find the const-string for air-save (PROD URL)
        string("https://air-save.ops.ajax.systems/"),
    )
)