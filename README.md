<img src="https://raw.githubusercontent.com/BlackBoxVision/material-calendar-view/master/art/logo.png" width="720px" height="125px">
> Prettier and simpler Material Design CalendarView

[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Material%20Calendar%20View-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2715) [![](https://jitpack.io/v/BlackBoxVision/material-calendar-view.svg)](https://jitpack.io/#BlackBoxVision/material-calendar-view) ![Build Status](https://travis-ci.org/BlackBoxVision/material-calendar-view.svg?branch=master) [![OpenCollective](https://opencollective.com/material-calendar-view/backers/badge.svg)](#backers) 
[![OpenCollective](https://opencollective.com/material-calendar-view/sponsors/badge.svg)](#sponsors)
 

**MaterialCalendarView** is a **prettier** and **simpler**, **material design calendar** that allows full customization and it's backwards compatible with API 19+.

## Screenshots

<div style="align:center; display:inline-block; width:100%;">
	<img src="https://raw.githubusercontent.com/BlackBoxVision/material-calendar-view/master/art/newer.png" height="775" width="49%">
	<img src="https://raw.githubusercontent.com/BlackBoxVision/material-calendar-view/master/art/other.png" height="775" width="49%">
</div>

<img src="https://i.imgur.com/ViolZD2.gif" height="550" width="100%" style="align: center;">

## Quick Start

**Gradle**

- Add it in your root build.gradle at the end of repositories:

```java
repositories {
	maven { 
	    url "https://jitpack.io"
	}
}
```

- Add the dependency:

```java
dependencies {
    implementation 'com.github.LeeBoonKong:Material-CalendarView:1.15'
}
```

In your layout.xml file:

```xml
<com.leeboonkong.materialcalendarview.view.CalendarView
	android:id="@+id/calendar_view"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:background="@color/colorPrimary">
</com.leeboonkong.materialcalendarview.view.CalendarView>
```

This example shows all the possible customization around Material Calendar View:

```xml
<com.leeboonkong.materialcalendarview.view.CalendarView
	android:id="@+id/calendar_view"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	app:calendarIsMultiSelectDayEnabled="false"
	app:calendarIsOverflowDatesVisible="true"
	app:calendarBackgroundColor="@color/colorPrimary"
	app:calendarTitleTextColor="@color/colorAccent"
	app:calendarCurrentDayTextColor="@color/white"
	app:calendarDayOfWeekTextColor="@color/grey"
	app:calendarDayOfMonthTextColor="@android:color/white"
	app:calendarDisabledDayBackgroundColor="@color/colorPrimary"
	app:calendarDisabledDayTextColor="@android:color/darker_gray"
	app:calendarSelectedDayBackgroundColor="@color/colorAccent"
	app:calendarTitleBackgroundColor="@color/colorPrimary"
	app:calendarWeekBackgroundColor="@color/colorPrimary"
	app:calendarCurrentDayBackgroundColor="@color/teal500"
	app:calendarWeekendTextColor="@color/colorAccent"
	app:calendarButtonBackgroundColor="@color/colorAccent">
</com.leeboonkong.materialcalendarview.view.CalendarView>
```
Then, in your Activity.java or Fragment.java initialize the calendar: 

```java
calendarView = (CalendarView) findViewById(R.id.calendar_view);

calendarView.shouldAnimateOnEnter(true)
	.setFirstDayOfWeek(Calendar.MONDAY)	
	.setOnDateClickListener(this::onDateClick)
	.setOnMonthChangeListener(this::onMonthChange)
	.setOnDateLongClickListener(this::onDateLongClick)
	.setOnMonthTitleClickListener(this::onMonthTitleClick);

if (calendarView.isMultiSelectDayEnabled()) {
	calendarView.setOnMultipleDaySelectedListener(this::onMultipleDaySelected);
}

calendarView.update(Calendar.getInstance(Locale.getDefault()));
```
  
Enjoy your new, beautiful, Materially-Designed calendar!

## Issues  
If you found a bug, or questions, you can open an issue at this github repository.  

## Contributing  
Of course, if you see something that you want to upgrade from this library, or a bug that needs to be solved, **PRs are welcome!**  
Currently me(LeeBoonKong) is the only one maintaining this repository and fixing bugs, this is an open source project forked from https://github.com/BlackBoxVision/material-calendar-view, but the original was not maintained anymore.  
If you would like to contribute you can:  
1. Write documentations for this project.  
2. Fix bugs, add new features and maintain this project.  
  
Your Github username will be included in the **Developers and Maintainers** section.  
	
## Developers and Maintainers(Github username)
LeeBoonKong  

## License

Distributed under the **MIT license**. See [LICENSE](https://github.com/LeeBoonKong/Material-CalendarView/blob/master/LICENSE.txt) for more information.

