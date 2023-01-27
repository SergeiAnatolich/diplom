package ru.iteco.fmhandroid.ui.pages

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import ru.iteco.fmhandroid.ui.Device

open class AppBarAllPage : Device() {

    val mainMenuButton = "main_menu_image_button"
    val authorizationButton = "authorization_image_button"
    val thematicQuotes = "our_mission_image_button"
    val trademark = "trademark_image_view"
    val about = "About"

    fun clickButtonMainMenu(): AppBarAllPage {
        device.findObject(By.res(MODEL_PACKAGE, mainMenuButton)).click()
        return this
    }

    fun waitMenu(): AppBarAllPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, content)), TIMEOUT)
        return this
    }

    fun clickMain(): MainPage {
        device.findObject(By.text(MainPage().main)).click()
        return MainPage()
    }

    fun clickClaims(): ClaimPage {
        device.findObject(By.text(ClaimPage().claims)).click()
        return ClaimPage()
    }

    fun clickNews(): NewsPage {
        device.findObject(By.text(NewsPage().news)).click()
        return NewsPage()
    }

    fun clickAbout(): AppBarAllPage {
        device.findObject(By.text(about)).click()
        return this
    }

    fun waitTrademark() {
        device.wait(Until.hasObject(By.res(MODEL_PACKAGE, trademark)), TIMEOUT)
    }

    fun clickAuthorizationButton(): AppBarAllPage {
        device.findObject(By.res(MODEL_PACKAGE, authorizationButton)).click()
        return this
    }

    fun waitDropMenu(): AppBarAllPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, content)), TIMEOUT)
        return this
    }

    fun clickLogOutButton(): AuthorizationPage {
        device.findObject(By.res(ANDROID_PACKAGE, content)).click()
        return AuthorizationPage()
    }

    fun checkingPage() {
        device.findObject(By.res(MODEL_PACKAGE, MainPage().appBarMain)).isChecked
    }

    fun clickThematicQuotes(): ThematicQuotesPage {
        device.findObject(By.res(MODEL_PACKAGE, thematicQuotes)).click()
        return ThematicQuotesPage()
    }

    fun logOut() {
        clickAuthorizationButton()
        waitDropMenu()
        clickLogOutButton()
        device.findObject(By.res(MODEL_PACKAGE, AuthorizationPage().enterButton)).isChecked
    }
}