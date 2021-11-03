package pl.kskowronski.mapiclientmaster.data.model.request;

import java.math.BigDecimal;

public class ReportRequest {
    private BigDecimal id;
    private String rapName;
    private String rapDesc;
    private BigDecimal rapOpId;
    private String rapSql;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRapName() {
        return rapName;
    }

    public void setRapName(String rapName) {
        this.rapName = rapName;
    }

    public String getRapDesc() {
        return rapDesc;
    }

    public void setRapDesc(String rapDesc) {
        this.rapDesc = rapDesc;
    }

    public BigDecimal getRapOpId() {
        return rapOpId;
    }

    public void setRapOpId(BigDecimal rapOpId) {
        this.rapOpId = rapOpId;
    }

    public String getRapSql() {
        return rapSql;
    }

    public void setRapSql(String rapSql) {
        this.rapSql = rapSql;
    }
}