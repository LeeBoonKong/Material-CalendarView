package com.leeboonkong.materialcalendarview.view;

import java.util.ArrayList;

public class SpecialDayOfWeek {
    private ArrayList<Integer> specialDays;
    private int color;
    private boolean highlightDays;

    public SpecialDayOfWeek(ArrayList<Integer> specialDays, int color, boolean highlightDays) {
        this.specialDays = new ArrayList<>(specialDays);
        this.color = color;
        this.highlightDays = highlightDays;
    }

    public ArrayList<Integer> getSpecialDays() {
        return specialDays;
    }

    public void setSpecialDays(ArrayList<Integer> specialDays) {
        this.specialDays = specialDays;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isHighlightDays() {
        return highlightDays;
    }

    public void setHighlightDays(boolean highlightDays) {
        this.highlightDays = highlightDays;
    }
}
