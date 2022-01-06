package dependencies.dependencies

import dependencies.Versions

object Compose{

    val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    val ui= "androidx.compose.ui:ui:${Versions.compose}"
    val foundation="androidx.compose.foundation:foundation:${Versions.compose}"
    val foundation_layout= "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    val material= "androidx.compose.material:material:${Versions.compose}"
    val material_icons_core= "androidx.compose.material:material-icons-core:${Versions.compose}"
    val runtime_livedata= "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    val ui_tooling= "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val navigation_compose="androidx.navigation:navigation-compose:${Versions.navigation_compose}"
    val material_icons_extended= "androidx.compose.material:material-icons-extended:${Versions.compose}"
    val runtime_rxjava2= "androidx.compose.runtime:runtime-rxjava2:${Versions.compose}"
    val compose_theme_adapter= "com.google.android.material:compose-theme-adapter:${Versions.compose}"


    val lifecycle_viewmode_compose= "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_viewmode_compose}"
    val activity_compose= "androidx.activity:activity-compose:${Versions.activity_compose}"
    val hilt_navigation_compose= "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"

}