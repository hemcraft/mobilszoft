package com.orm;

import android.app.Application;

import com.example.mobilszoft.CitiesActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.LooperMode;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk=28)
@LooperMode(LooperMode.Mode.PAUSED)
public class TestSugarApp
    extends Application
{
    private CitiesActivity activity;

    @Override
    public void onCreate() {}

    @Override
    public void onTerminate() {}

    @Test
    public void startEverTestSugarAppAsFirst() {

    }

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity(CitiesActivity.class)
                .create().resume().get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull(activity);
    }
}