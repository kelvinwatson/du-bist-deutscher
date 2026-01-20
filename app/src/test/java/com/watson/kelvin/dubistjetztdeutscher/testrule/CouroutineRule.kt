package com.watson.kelvin.dubistjetztdeutscher.testrule

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineRule(
    val dispatcher: TestDispatcher = StandardTestDispatcher(),
    val scheduler: TestCoroutineScheduler = TestCoroutineScheduler(),
) : TestWatcher() {
    val scope = TestScope(dispatcher)


    override fun starting(description: Description) {
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }

    fun runTest(
        testBody: suspend TestScope.() -> Unit
    ) = scope.runTest(testBody = testBody)
}
