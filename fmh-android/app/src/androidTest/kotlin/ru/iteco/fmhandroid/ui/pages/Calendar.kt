package ru.iteco.fmhandroid.ui.pages

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import ru.iteco.fmhandroid.ui.Device

open class Calendar : Device() {
    val day = "25"
    val year = "2026"
    val currentMonth = "01"
    val nextMonth = "Next month"
    val previousMonth = "Previous month"
    val headerYear = "date_picker_header_year"
    val buttonOk = "button1"
    val widgetYearPicker = "android.widget.YearPickerView"
    val widgetDayPicker = "android.widget.DayPickerView"
    val widgetDialogViewAnimator = "com.android.internal.widget.DialogViewAnimator"
    val appCompatImageButton = "androidx.appcompat.widget.AppCompatImageButton"
    val animator = "animator"

    fun waitAnimator(): Calendar {
        device.wait(Until.hasObject(By.res(ANDROID_PACKAGE, animator)), TIMEOUT)
        return this
    }

    fun headerYearClick(): Calendar {
        device.findObject(By.res(ANDROID_PACKAGE, headerYear)).click()
        return this
    }

    fun nextMonth(): Calendar {
        val appCompatImageButton2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withClassName(Matchers.`is`(appCompatImageButton)),
                ViewMatchers.withContentDescription(nextMonth),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withClassName(Matchers.`is`(widgetDayPicker)),
                        childAtPosition(
                            ViewMatchers.withClassName(Matchers.`is`(widgetDialogViewAnimator)),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton2.perform(ViewActions.scrollTo(), ViewActions.click())
        return this
    }

    fun prevMonth(): Calendar {
        val appCompatImageButton3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withClassName(Matchers.`is`(appCompatImageButton)),
                ViewMatchers.withContentDescription(previousMonth),
                childAtPosition(
                    Matchers.allOf(
                        ViewMatchers.withClassName(Matchers.`is`(widgetDayPicker)),
                        childAtPosition(
                            ViewMatchers.withClassName(Matchers.`is`(widgetDialogViewAnimator)),
                            0
                        )
                    ),
                    1
                )
            )
        )
        appCompatImageButton3.perform(ViewActions.scrollTo(), ViewActions.click())
        return this
    }

    fun selectDay(): Calendar {
        device.findObject(By.text(day)).click()
        return this
    }

    fun selectYear(): Calendar {
        val materialTextView2 = Espresso.onData(Matchers.anything())
            .inAdapterView(
                Matchers.allOf(
                    ViewMatchers.withClassName(Matchers.`is`(widgetYearPicker)),
                    childAtPosition(
                        ViewMatchers.withClassName(Matchers.`is`(widgetDialogViewAnimator)),
                        1
                    )
                )
            )
            .atPosition(3)
        materialTextView2.perform(ViewActions.scrollTo(), ViewActions.click())
        return this
    }

    fun clickButtonOk() {
        device.findObject(By.res(ANDROID_PACKAGE, buttonOk)).click()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}