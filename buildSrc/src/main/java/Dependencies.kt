object Versions {
    const val compose_bom_version = "2023.08.00"
    const val compose_navigation_version = "2.7.6"
    const val hilt_version = "2.46.1"
    const val hilt_compose_version = "1.0.0"
    const val hilt_compiler_version = "1.0.0"
    const val retrofit2_version = "2.9.0"
    const val landscapist_version = "2.2.1"
    const val junit_version = "4.13.2"
    const val mockito_version = "4.1.0"
}

object Libs {

    const val composeBOM = "androidx.compose:compose-bom:${Versions.compose_bom_version}"
    const val composeUI = "androidx.compose.ui:ui"
    const val composeActivities = "androidx.activity:activity-compose"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeMaterial = "androidx.compose.material:material:1.5.4"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.compose_navigation_version}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hilt_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_compose_version}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_version}"
    const val hilt_kapt = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler_version}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    const val retrofit2_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_version}"

    const val landscapist_glide = "com.github.skydoves:landscapist-glide:${Versions.landscapist_version}"
    const val landscapist_animation = "com.github.skydoves:landscapist-animation:${Versions.landscapist_version}"
    const val landscapist_placeholder = "com.github.skydoves:landscapist-placeholder:${Versions.landscapist_version}"

    const val junit = "junit:junit:${Versions.junit_version}"
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito_version}"
    const val kotlin_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test"
}