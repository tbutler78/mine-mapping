package com.tbutler78.minemapping.web.command;

import com.tbutler78.minemapping.domain.PropertyFileScan;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by butlert on 4/13/17.
 */

public class MineResponse {

    private static final long serialVersionUID = -5708387226479386241L;

    private String deposit;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String county;



    private List<PropertyFileScan> propertyFileScan;


    public MineResponse(String deposit, BigDecimal latitude, BigDecimal longitude, String county) {
        this.deposit = deposit;
        this.latitude = latitude;
        this.longitude = longitude;
        this.county = county;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public List<PropertyFileScan> getPropertyFileScan() {
        return propertyFileScan;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setPropertyFileScan(List<PropertyFileScan> propertyFileScan) {
        this.propertyFileScan = propertyFileScan;
    }
}
