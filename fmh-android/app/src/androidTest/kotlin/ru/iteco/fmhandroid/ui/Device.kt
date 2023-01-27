package ru.iteco.fmhandroid.ui

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

open class Device {

    val MODEL_PACKAGE = "ru.iteco.fmhandroid"
    val ANDROID_PACKAGE = "android"
    val content = "content"
    val TIMEOUT = 5000L

    val device: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun waitForPackage(packageName: String) {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
    }

    fun device() {
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)
    }

    fun startLauncher() {
        device()
        waitForPackage(MODEL_PACKAGE)
    }
}