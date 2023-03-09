package org.odk.collect.metadata

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.odk.collect.shared.settings.InMemSettings
import org.odk.collect.shared.settings.Settings

@RunWith(AndroidJUnit4::class)
class SharedPreferencesInstallIDProviderTest {
    private val metaPreferences: Settings = InMemSettings()
    private val provider: SharedPreferencesInstallIDProvider = SharedPreferencesInstallIDProvider(metaPreferences, "blah")

    @Test
    fun returnsSameValueEveryTime() {
        val firstValue = provider.installID
        val secondValue = provider.installID

        assertThat(firstValue, equalTo(secondValue))
    }

    @Test
    fun returnsValueWithPrefix() {
        assertThat(provider.installID, startsWith("collect:"))
    }

    @Test
    fun returns24CharacterValue() {
        assertThat(provider.installID.length, equalTo(24))
    }

    @Test
    fun clearingSharedPreferences_resetsInstallID() {
        val firstValue = provider.installID
        metaPreferences.clear()
        val secondValue = provider.installID

        assertThat(secondValue, notNullValue())
        assertThat(firstValue, not(equalTo(secondValue)))
    }
}
