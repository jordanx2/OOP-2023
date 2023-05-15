package ie.tudublin;

import processing.core.PApplet;

public class StopWatch extends PApplet {

    private boolean isRunning;
    private boolean isPaused;
    private long startTime;
    private long elapsedTime;

    private int startButtonX = 50;
    private int startButtonY = 25;
    private int buttonWidth = 100;
    private int buttonHeight = 50;

    public void settings() {
        size(200, 200);
    }

    public void setup() {
        background(255);
        textAlign(CENTER, CENTER);
        textSize(32);
        isRunning = false;
        isPaused = false;
    }

    public void draw() {
        background(255);
        fill(0);
        text(formatTime(elapsedTime), width / 2, height / 2);

        // Draw Start button
        fill(150);
        rect(startButtonX, startButtonY, buttonWidth, buttonHeight);
        fill(0);
        if (!isRunning)
            text("Start", startButtonX + buttonWidth / 2, startButtonY + buttonHeight / 2);
        else if (isPaused)
            text("Resume", startButtonX + buttonWidth / 2, startButtonY + buttonHeight / 2);
        else
            text("Pause", startButtonX + buttonWidth / 2, startButtonY + buttonHeight / 2);

        // Draw Stop button
        fill(200);
        rect(startButtonX, startButtonY + 100, buttonWidth, buttonHeight);
        fill(0);
        text("Stop", startButtonX + buttonWidth / 2, startButtonY + buttonHeight / 2 + 100);
        updateElapsedTime(); // Added this line to update the elapsed time

    }

    public void mousePressed() {
        if (mouseX > startButtonX && mouseX < startButtonX + buttonWidth &&
                mouseY > startButtonY && mouseY < startButtonY + buttonHeight) {
            if (!isRunning) {
                if (isPaused) {
                    isPaused = false;
                    startTime = millis() - elapsedTime;
                } else {
                    isRunning = true;
                    startTime = millis();
                }
            } else {
                isPaused = !isPaused;
                if (!isPaused) {
                    startTime = millis() - elapsedTime;
                }
            }
        } else if (mouseX > startButtonX && mouseX < startButtonX + buttonWidth &&
                mouseY > startButtonY + 70 && mouseY < startButtonY + 70 + buttonHeight) {
            isRunning = false;
            isPaused = false;
            elapsedTime = 0;
        }
    }

    public void updateElapsedTime() {
        if (isRunning && !isPaused) {
            elapsedTime = millis() - startTime;
        }
    }

    public String formatTime(long time) {
        int milliseconds = (int) (time % 1000);
        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / 1000) / 60);
        return nf(minutes, 2) + ":" + nf(seconds, 2) + "." + nf(milliseconds, 3);
    }

}


