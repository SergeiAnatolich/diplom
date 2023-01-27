package ru.iteco.fmhandroid.ui.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.iteco.fmhandroid.ui.Device

open class Chrome : Device() {
    val CHROME_PACKAGE = "com.android.chrome"
    private val url = "url_bar"

    fun getUrl(): String {
        return device.findObject(By.res(CHROME_PACKAGE, url)).text
    }

    fun waitChrome() {
        device.wait(Until.hasObject(By.res(CHROME_PACKAGE, url)), TIMEOUT)
    }
}