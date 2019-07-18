package com.leeboonkong.materialcalendarview.sample.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.leeboonkong.materialcalendarview.sample.R;
import com.leeboonkong.materialcalendarview.sample.logic.presenter.MainPresenter;
import com.leeboonkong.materialcalendarview.sample.logic.presenter_view.MainView;
import com.leeboonkong.materialcalendarview.view.CalendarView;
import com.leeboonkong.materialcalendarview.view.SpecialDayOfWeek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.leeboonkong.materialcalendarview.sample.utils.AnimationUtils.animate;


public final class MainActivity extends AppCompatActivity implements MainView {
    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String MONTH_TEMPLATE = "MMMM yyyy";

    private final MainPresenter presenter = new MainPresenter(this);

    @BindView(R.id.textview)
    TextView textView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.calendar_view)
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        presenter.addNavigationDrawer();
        presenter.addCalendarView();
        presenter.addTextView();
        presenter.animate();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void prepareTextView() {
        textView.setText(String.format("Today is %s", formatDate(DATE_TEMPLATE, new Date(System.currentTimeMillis()))));
    }

    @Override
    public void prepareCalendarView() {
        Calendar disabledCal = Calendar.getInstance();
        disabledCal.set(Calendar.DATE, disabledCal.get(Calendar.DATE) - 1);

        ArrayList<SpecialDayOfWeek> specialDayOfWeeks = new ArrayList<>();
        //Create a list of days to be special days
        ArrayList<Integer> specialDays = new ArrayList<>();
        specialDays.add(Calendar.THURSDAY);
        specialDays.add(Calendar.TUESDAY);

        ArrayList<Integer> specialDays2 = new ArrayList<>();
        specialDays2.add(Calendar.SATURDAY);
        specialDays2.add(Calendar.SUNDAY);

        specialDayOfWeeks.add(new SpecialDayOfWeek(specialDays, R.color.orange, false));
        specialDayOfWeeks.add(new SpecialDayOfWeek(specialDays2, R.color.red, true));

        calendarView.setFirstDayOfWeek(Calendar.MONDAY)
                .setOnDateClickListener(this::onDateClick)
                .setOnMonthChangeListener(this::onMonthChange)
                .setOnDateLongClickListener(this::onDateLongClick)
                .setOnMonthTitleClickListener(this::onMonthTitleClick)
                .setSpecialDaysOfWeek(specialDayOfWeeks)
                .setLocale(new Locale("en"))
                .setIsOverflowDateVisible(false)
                .setMinDate(new Date());

        calendarView.setDisabledDates(getDisabledDates());

        if (calendarView.isMultiSelectDayEnabled()) {
            calendarView.setOnMultipleDaySelectedListener((month, dates) -> {
                //Do something with your current selection
            });
        }

        calendarView.update(Calendar.getInstance(Locale.getDefault()));
    }

    @Override
    public void prepareNavigationDrawer() {
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    public void animateViews() {
        calendarView.shouldAnimateOnEnter(true);
        animate(fab, getApplicationContext());
        animate(textView, getApplicationContext());
    }

    private void onDateLongClick(@NonNull final Date date) {
        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onDateClick(@NonNull final Date date) {
        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onMonthTitleClick(@NonNull final Date date) {
        //Do something after month selection
    }

    private void onMonthChange(@NonNull final Date date) {
        final ActionBar actionBar = getSupportActionBar();

        if (null != actionBar) {
            String dateStr = formatDate(MONTH_TEMPLATE, date);
            dateStr = dateStr.substring(0, 1).toUpperCase() + dateStr.substring(1, dateStr.length());

            actionBar.setTitle(dateStr);
        }
    }

    private String formatDate(@NonNull String dateTemplate, @NonNull Date date) {
        return new SimpleDateFormat(dateTemplate, Locale.getDefault()).format(date);
    }

    private ArrayList<Date> getDisabledDates(){
        ArrayList<Date> disabledDates = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            disabledDates.add(sdf.parse("25-07-2019"));
            disabledDates.add(sdf.parse("28-07-2019"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return disabledDates;
    }
}
