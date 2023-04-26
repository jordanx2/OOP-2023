package labtest;

import processing.data.TableRow;

public class Task {
    private String task;
    private int start;
    private int end;
    private float startX;
    private float endX;
    private float yPos;

    public Task(TableRow tr) {
        this.task = tr.getString("Task");
        this.start = tr.getInt("Start");
        this.end = tr.getInt("End");
    }


    public float getStartX() {
        return startX;
    }


    public void setStartX(float startX) {
        this.startX = startX;
    }


    public float getEndX() {
        return endX;
    }


    public void setEndX(float endX) {
        this.endX = endX;
    }


    public float getyPos() {
        return yPos;
    }


    public void setyPos(float yPos) {
        this.yPos = yPos;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task [task=" + task + ", start=" + start + ", end=" + end + "]";
    }
    
}
