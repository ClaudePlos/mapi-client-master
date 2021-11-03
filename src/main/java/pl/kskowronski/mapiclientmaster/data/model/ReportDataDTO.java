package pl.kskowronski.mapiclientmaster.data.model;

public class ReportDataDTO {

    private String cellName;
    private String jsonData;

    public ReportDataDTO() {
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
