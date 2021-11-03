package pl.kskowronski.mapiclientmaster.data.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kskowronski.mapiclientmaster.data.model.GenericResponse;
import pl.kskowronski.mapiclientmaster.data.model.Report;
import pl.kskowronski.mapiclientmaster.data.model.ReportDataDTO;
import pl.kskowronski.mapiclientmaster.data.model.request.ReportRequest;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportApi {

    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private ReportService reportService;

    @GetMapping(path = "{id}")
    public GenericResponse<Report> getTender(@PathVariable("id") BigDecimal id) {
        GenericResponse resp = new GenericResponse();
        Optional<Report> report = reportRepo.findById(id);
        resp.setBody(report.get());
        return resp;
    }

    @GetMapping(path = "/user-reports/{id}")
    public ResponseEntity<List<Report>> listReportsForOperator(@PathVariable("id") Long id) {
        List<Report> reports = (List<Report>) reportRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return ResponseEntity.ok(reports);
    }

    @GetMapping(path = "/reports")
    public GenericResponse<List<Report>> listAllReports() {
        GenericResponse resp = new GenericResponse();
        List<Report> reports = (List<Report>) reportRepo.findAll();
        resp.setBody(reports);
        return resp;
    }

    @PostMapping
    public GenericResponse<List<Report>> addReport(@RequestBody ReportRequest request) {
        GenericResponse resp = new GenericResponse();
        Report report = new Report();
        List<Report> reports = (List<Report>) reportRepo.findAll();
        report.setId(reports.stream().max(Comparator.comparing(Report::getId))
                .orElseThrow(NoSuchElementException::new).getId().add(BigDecimal.ONE)
        );
        report.setRapName(request.getRapName());
        report.setRapDesc(request.getRapDesc());
        report.setRapSql(request.getRapSql());
        reportRepo.save(report);
        reports = (List<Report>) reportRepo.findAll();
        resp.setBody(reports);
        return resp;
    }

    @PostMapping(path = "/report") // todo mapper
    public GenericResponse<Report> saveReport(@RequestBody ReportRequest request) {
        GenericResponse resp = new GenericResponse();
        Report report = new Report();
        report.setId(request.getId());
        report.setRapName(request.getRapName());
        report.setRapDesc(request.getRapDesc());
        report.setRapSql(request.getRapSql());
        reportRepo.save(report);
        resp.setBody(report);
        return resp;
    }

    @GetMapping(path = "/delete/{reportId}")
    public GenericResponse<List<Report>> listAllReports(@PathVariable("reportId") BigDecimal reportId) {
        GenericResponse resp = new GenericResponse();
        Optional<Report> report = reportRepo.findById(reportId);
        reportRepo.delete(report.get());
        List<Report> reports = (List<Report>) reportRepo.findAll();
        resp.setBody(reports);
        return resp;
    }

    @PostMapping(path = "/run-sql") // todo mapper
    public GenericResponse<String> runSql(@RequestBody String sqlQuery) {
        GenericResponse resp = new GenericResponse();
        String response = reportService.getDataFromSqlQuery(sqlQuery);
        resp.setBody(response);
        return resp;
    }
}