<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    tools:context="com.example.assignment.ReportActivity">
    <LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="50dp"
        android:orientation="vertical">

    </LinearLayout>

    <TextView
        android:id="@+id/userwelcome"
        android:layout_width="122dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="10dp"
        android:gravity="center_horizontal"
        android:text="REPORT"
        android:textColor="#132BB1"
        android:textSize="25dp"

        android:textStyle="bold" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_weight=""
        android:orientation="horizontal">

        <EditText
            android:id="@+id/moviedatePickerstart"
            android:layout_width="wrap_content"
            android:layout_height="23dp"
            android:layout_marginLeft="20dp"

            android:layout_marginTop="25dp"
            android:background="#ffffff"
            android:clickable="true"
            android:hint="Select Start Date" />

        <EditText
            android:id="@+id/moviedatePickerend"
            android:layout_width="wrap_content"
            android:layout_height="23dp"
            android:layout_marginLeft="10dp"
            android:layout_marginTop="25dp"
            android:background="#ffffff"
            android:calendarViewShown="false"
            android:clickable="true"
            android:hint="Select End Date" />

        <Button
            android:id="@+id/button_register"
            android:layout_width="92dp"
            android:layout_height="62dp"

            android:layout_marginLeft="10dp"
     