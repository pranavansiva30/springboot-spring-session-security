package com.wavesdev.session.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pranavan on 3/20/18.
 */
@MappedSuperclass
public class AuditFields extends BaseObject{


    /**
     *
     */
    private static final long serialVersionUID = 7330054548229543115L;
    protected Date createdOn;
    protected String createdBy;
    protected Date modifiedOn;
    protected String modifiedBy;

    //private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");
    /**
     * @return the Calendar_modified
     */
    AuditFields() {
        Date dNow = new Date();
		/*SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss");*/
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");

        try {
            dNow = ft.parse(ft.format(dNow));
        } catch (ParseException e) {
            dNow = new Date();
        }
        // modifiedOn= dNow;
    }

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
//		try {
//			createdOn = ft.parse(ft.format(createdOn));
//		} catch (ParseException e) {
//			createdOn = new Date();
//		}
        return createdOn;
    }

    @Column(name = "created_by", length = 10, columnDefinition = "CHAR(50)")
    public String getCreatedBy() {
        return createdBy;
    }

    @Column(name = "modified_on", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    @Column(name = "modified_by", columnDefinition = "CHAR(50)", nullable = true)
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }



    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }




}

