package com.edencoding.animation;

import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Ed Eden-Rump
 * @created 25/07/2020 - 18:06
 * @project EdenCoding Animation
 **/
public abstract class SimpleAnimationTimer extends AnimationTimer {

    long lastFrameTime = -1L;
    long deltaTimeNano;
    IntegerProperty frameRate = new SimpleIntegerProperty(0);

    public int getFrameRate() {
        return frameRate.get();
    }

    public IntegerProperty frameRateProperty() {
        return frameRate;
    }

    @Override
    public void handle(long currentTimeNano) {
        updateFrameTime(currentTimeNano);
        updateFrameRate();
        tick();
    }

    protected void updateFrameTime(long currentTimeNano) {
        deltaTimeNano = currentTimeNano - lastFrameTime;
        lastFrameTime = currentTimeNano;
    }

    protected void updateFrameRate() {
        frameRate.set((int) Math.round(getFrameRateHertz()));
    }

    public abstract void tick();

    public long getDeltaTimeNano() {
        return deltaTimeNano;
    }

    public double getFrameRateHertz() {
        double frameRate = 1d / deltaTimeNano;
        return frameRate * 1e9;
    }
}
