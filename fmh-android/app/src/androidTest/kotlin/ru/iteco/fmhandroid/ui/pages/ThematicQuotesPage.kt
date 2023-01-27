package ru.iteco.fmhandroid.ui.pages

import android.widget.LinearLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.Device

open class ThematicQuotesPage : Device() {
    val listRecyclerView = "our_mission_item_list_recycler_view"
    val button = "our_mission_item_open_card_image_button"

    fun waitThematicQuotesPage(): ThematicQuotesPage {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, listRecyclerView)), TIMEOUT)
        return this
    }

    fun checkingPage() {
        device.findObject(By.res(MODEL_PACKAGE, listRecyclerView)).isChecked
    }

    fun clickButton(): ThematicQuotesPage {
        device.findObject(By.res(MODEL_PACKAGE, button)).click()
        return this
    }

    fun checkingText() {
        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.our_mission_item_description_text_view),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(R.id.our_mission_item_material_card_view))),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun textView(): ViewInteraction {
        return Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.our_mission_item_description_text_view),
                ViewMatchers.withParent(ViewMatchers.withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))),
                ViewMatchers.isDisplayed()
            )
        )
    }
}