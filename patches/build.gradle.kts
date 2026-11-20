group = "app.opatches"

patches {
    about {
        name = "opatches"
        description = "Custom patches for various apps"
        source = "https://github.com/USERNAME/opatches"
        author = "Your Name"
        contact = "your@email.com"
        website = "https://github.com/USERNAME/opatches"
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
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    publish {
        dependsOn("generatePatchesList")
    }
}
