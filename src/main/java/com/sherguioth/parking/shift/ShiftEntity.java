package com.sherguioth.parking.shift;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "shifts")
public class ShiftEntity implements Serializable {

    @Id
    @Column(name = "shift_id")
    private long shiftId;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "entry_time")
    @Temporal(TemporalType.TIME)
    private Date entryTime;

    @Column(name = "exit_time")
    @Temporal(TemporalType.TIME)
    private Date exitTime;

    public ShiftEntity() {}

    public ShiftEntity(long shiftId, String description, Date entryTime, Date exitTime) {
        this.shiftId = shiftId;
        this.description = description;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
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
