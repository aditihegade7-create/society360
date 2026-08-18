package com.society.view;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenSize {

    private static final Rectangle2D SCREEN = Screen.getPrimary().getVisualBounds();

    public static double getWidth() {
        return SCREEN.getWidth();
    }

    public static double getHeight() {
        return SCREEN.getHeight();
    }
}