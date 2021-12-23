package dependencies

object AnnotationProcessing {
    val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"

    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android_compiler}"
    val hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"
}