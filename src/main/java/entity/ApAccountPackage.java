package entity;

import java.util.Date;

public class ApAccountPackage {
    private Integer accountPackageId;

    private Date startDate;

    private Date endDate;

    private Boolean strictOffline;

    private Integer remindAheadDays;

    private String userLevel;

    private Integer isBind;

    private String macs;

    private Date payDate;

    public Integer getAccountPackageId() {
        return accountPackageId;
    }

    public void setAccountPackageId(Integer accountPackageId) {
        this.accountPackageId = accountPackageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getStrictOffline() {
        return strictOffline;
    }

    public void setStrictOffline(Boolean strictOffline) {
        this.strictOffline = strictOffline;
    }

    public Integer getRemindAheadDays() {
        return remindAheadDays;
    }

    public void setRemindAheadDays(Integer remindAheadDays) {
        this.remindAheadDays = remindAheadDays;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel == null ? null : userLevel.trim();
    }

    public Integer getIsBind() {
        return isBind;
    }

    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }

    public String getMacs() {
        return macs;
    }

    public void setMacs(String macs) {
        this.macs = macs == null ? null : macs.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}