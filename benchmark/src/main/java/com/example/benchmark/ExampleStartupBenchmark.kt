package com.example.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startUpCompilationModeNon() = startup(CompilationMode.None())

    @Test
    fun startUpCompilationModePartial() = startup(CompilationMode.Partial())

    @Test
    fun scrollAndNavigateModeNone() = scrollAndNavigate(CompilationMode.None())

    @Test
    fun scrollAndNavigateModePartial() = scrollAndNavigate(CompilationMode.Partial())

    private fun startup(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = "com.example.composecodechallenge",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = mode
    ) {
        pressHome()
        startActivityAndWait()

        fillTextFieldAndScrollAndClickOnRandomItem()
    }

    private fun scrollAndNavigate(mode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = "com.example.composecodechallenge",
        metrics = listOf(FrameTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = mode
    ) {
        pressHome()
        startActivityAndWait()

        fillTextFieldAndScrollAndClickOnRandomItem()
        navigateBackFromDetailScreen()
    }
}

fun MacrobenchmarkScope.fillTextFieldAndScrollAndClickOnRandomItem() {
    val textField = device.findObject(By.res("search_users"))
    val list = device.findObject(By.res("list_item"))

    textField.click()

    device.performActionAndWait({
        textField.text = "sa"
    }, Until.newWindow(), 3000L)

    device.performActionAndWait({
        textField.text = "sar"
    }, Until.newWindow(), 1000L)

    device.waitForIdle()

    /**
     * The below margin is considered for preventing wrong clicks on the keyboard instead of
     * the list.
     */
    list.setGestureMargins(device.displayWidth / 5
        , device.displayWidth / 5,
        device.displayWidth/5,
        device.displayHeight/2 + device.displayWidth/2
    )

    list.fling(Direction.DOWN)

    list.fling(Direction.UP)

    device.findObject(By.textContains("sara")).click()
}

fun MacrobenchmarkScope.navigateBackFromDetailScreen() {
    val backIcon = device.findObject(By.res("back"))

    backIcon.click()
}