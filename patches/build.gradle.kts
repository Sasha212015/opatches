group = "app.opatches"

patches {
    about {
        name = "opatches"
        description = "Custom patches for various apps"
        source = "https://github.com/Sasha212015/opatches"
        author = "Sasha212015"
        contact = "sasha212015@example.com"
        website = "https://github.com/Sasha212015/opatches"
        license = "GPLv3"
    }
}

val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"
        dependsOn("buildAndroid")
        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    // Run generatePatchesList after build
    tasks {
        val buildTask by existing
        buildTask.finalizedBy("generatePatchesList")
    }

    publish {
        dependsOn("generatePatchesList")
    }
}