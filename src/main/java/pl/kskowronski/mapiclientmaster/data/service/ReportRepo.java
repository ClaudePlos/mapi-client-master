package pl.kskowronski.mapiclientmaster.data.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kskowronski.mapiclientmaster.data.model.Report;

import java.math.BigDecimal;


@RepositoryRestResource(collectionResourceRel = "reports", path = "reports")
public interface ReportRepo extends PagingAndSortingRepository<Report, BigDecimal> {

}
