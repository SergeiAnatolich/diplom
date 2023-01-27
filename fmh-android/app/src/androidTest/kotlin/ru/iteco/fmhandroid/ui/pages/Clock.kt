package ru.iteco.fmhandroid.ui.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.iteco.fmhandroid.ui.Device

open class Clock : Device() {
    val timePicker = "timePicker"
    val toggleMode = "toggle_mode"
    val hoursSelect = "20"
    val minSelect = "15"
    val inputHour = "input_hour"
    val inputMinute = "input_minute"
    val buttonOk = "button1"

    fun waitTimePicker(): Clock {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, timePicker)), TIMEOUT)
        return this
    }

    fun clickToggleMode(): Clock {
        device.findObject(By.res(ANDROID_PACKAGE, toggleMode)).click()
        return this
    }

    fun inputHour(): Clock {
        device.findObject(By.res(ANDROID_PACKAGE, inputHour)).text = Clock().hoursSelect
        return this
    }

    fun inputMinute(): Clock {
        device.findObject(By.res(ANDROID_PACKAGE, inputMinute)).text = Clock().minSelect
        return this
    }

    fun clickButtonOk() {
        device.findObject(By.res(ANDROID_PACKAGE, buttonOk)).click()
    }

    fun getTime(): String {
        return device.findObject(By.res(MODEL_PACKAGE, ClaimPage().timeInput)).text
    }
}