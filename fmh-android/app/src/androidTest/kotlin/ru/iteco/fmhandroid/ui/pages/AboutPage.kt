package ru.iteco.fmhandroid.ui.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.iteco.fmhandroid.ui.Device

open class AboutPage : Device() {

    val buttonBack = "about_back_image_button"
    val version = "about_version_title_text_view"
    val privacyPolicy = "about_privacy_policy_value_text_view"
    val termsOfUse = "about_terms_of_use_value_text_view"
    val fieldVersion = "Version:"
    val fieldUrlPrivacyPolicy = "https://vhospice.org/#/privacy-policy/"
    val fieldUrlTermsOfUse = "https://vhospice.org/#/terms-of-use"
    val appBarAboutPage = "container_custom_app_bar_include_on_fragment_about"

    fun clickButtonBack(): AboutPage {
        device.findObject(By.res(MODEL_PACKAGE, buttonBack)).click()
        return this
    }

    fun waitPreviousPage(): AppBarAllPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, content)), TIMEOUT)
        return AppBarAllPage()
    }

    fun getVersionApp(): String {
        return device.findObject(By.res(MODEL_PACKAGE, version)).text
    }

    fun getUrlPrivacyPolicy(): String {
        return device.findObject(By.res(MODEL_PACKAGE, privacyPolicy)).text
    }

    fun getUrlTermsOfUse(): String {
        return device.findObject(By.res(MODEL_PACKAGE, termsOfUse)).text

    }

    fun privacyPolicyClick(): Chrome {
        device.findObject(By.res(MODEL_PACKAGE, privacyPolicy)).click()
        return Chrome()
    }

    fun termsOfUseClick(): Chrome {
        device.findObject(By.res(MODEL_PACKAGE, termsOfUse)).click()
        return Chrome()
    }

    fun checkingPage(): AboutPage {
        device.findObject(By.res(MODEL_PACKAGE, appBarAboutPage)).isChecked
        return this
    }
}