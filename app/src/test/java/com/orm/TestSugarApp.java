package com.orm;

import android.app.Application;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.mobilszoft.AboutActivity;
import com.example.mobilszoft.CitiesActivity;
import com.example.mobilszoft.CitiesInteractor;
import com.example.mobilszoft.CitiesPresenter;
import com.example.mobilszoft.CitiesView;
import com.example.mobilszoft.R;
import com.example.mobilszoft.db.City;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.LooperMode;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk=28)
@LooperMode(LooperMode.Mode.PAUSED)
public class TestSugarApp
    extends Application
{
    private CitiesActivity citiesActivity;
    private AboutActivity aboutActivity;

    CitiesInteractor interactor;
    CitiesPresenter citiesPresenter;
    CitiesActivity mockCitiesActivity;

    private MenuItem menuItemAbout = new RoboMenuItem(R.id.about);
    private MenuItem menuItemCities = new RoboMenuItem(R.id.cities);
    private MenuItem menuItemReload = new RoboMenuItem(R.id.refresh);

    @Before
    public void setUp() throws Exception
    {
        citiesActivity = Robolectric.buildActivity(CitiesActivity.class)
                .create().resume().get();

        aboutActivity = Robolectric.buildActivity(AboutActivity.class)
                .create().resume().get();

        interactor = mock(CitiesInteractor.class);
        mockCitiesActivity = mock(CitiesActivity.class);

        citiesPresenter = new CitiesPresenter(mockCitiesActivity, interactor);
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull(citiesActivity);
        assertNotNull(aboutActivity);
    }

    @Test
    public void aboutIntentStarted() throws Exception
    {
        citiesActivity.onOptionsItemSelected(menuItemAbout);
        Intent expectedIntent = new Intent(aboutActivity, AboutActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void listViewUpdated() throws Exception
    {
        List<City> cityList = new ArrayList<City>();
        cityList.add(new City("Debrecen", "Hungary", 60.0, 70.0));
        cityList.add(new City("Szeged", "Hungary", 60.0, 70.0));

        ListView listView = citiesActivity.findViewById(R.id.list_view);
        assertNull(listView.getAdapter());

        citiesActivity.showCities(cityList);

        assertNotNull(listView.getAdapter());
        assertEquals(2, listView.getCount());
    }

    @Test
    public void citiesIntentStarted() throws Exception
    {
        aboutActivity.onOptionsItemSelected(menuItemCities);
        Intent expectedIntent = new Intent(citiesActivity, CitiesActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void citiesDeleteddWhenReloadCalled() throws Exception
    {
        citiesPresenter.reloadCities();
        verify(interactor, atLeastOnce()).clearDatabase();
    }

    @Test
    public void saveCityToDatabaseCalled() throws Exception
    {
        City city = mock(City.class);
        citiesPresenter.saveCity(city);
        verify(interactor, atLeastOnce()).saveCityToDatabase(city);
    }

    @Test
    public void getCitiesFromDatabaseCalled() throws Exception
    {
        citiesPresenter.getCities();
        verify(interactor, atLeastOnce()).getCitiesFromDatabase();
    }
}