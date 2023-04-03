/*
 * Copyright (c) 2022 NetEase, Inc. All rights reserved.
 * Use of this source code is governed by a MIT license that can be
 * found in the LICENSE file.
 */

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 31
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.airbnb.android:lottie:5.0.3")
    implementation("com.gyf.immersionbar:immersionbar:3.0.0")
    implementation("com.netease.yunxin.kit.room:roomkit:1.11.0")
    implementation("com.netease.yunxin.kit.common:common-ui:1.1.13")
    implementation("com.netease.yunxin.kit.common:common-network:1.1.7")
    implementation("com.netease.yunxin.kit.common:common-image:1.1.6")
    implementation("com.netease.yunxin.kit.voiceroom:voiceroomkit:1.0.6")
    implementation("com.netease.yunxin.kit.copyrightedmedia:copyrightedmedia:1.5.0")
    implementation("com.netease.yunxin.kit:alog:1.0.9")
    implementation(project(":ordersong"))
    implementation("com.blankj:utilcodex:1.30.6")

}