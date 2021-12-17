package com.sherguioth.parking.shift;

import java.util.Date;

public class Shift {
    private long shiftId;
    private String description;
    private Date entryTime;
    private Date exitTime;

    public Shift() {}

    public Shift(long shiftId, String description, Date entryDate, Date exitDate) {
        this.shiftId = shiftId;
        this.description = description;
        this.entryTime = entryDate;
        this.exitTime = exitDate;
    }

    public long getShiftId() {
        return shiftId;
    }

    public void setShiftId(long shiftId) {
        this.shiftId = shiftId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
