package pl.kskowronski.mapiclientmaster.data.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kskowronski.mapiclientmaster.data.model.Operator;

import java.math.BigDecimal;

@RepositoryRestResource(collectionResourceRel = "operators", path = "operators")
public interface OperatorRepo extends PagingAndSortingRepository<Operator, BigDecimal> {

    Operator findByLogin(@Param("login") String login);

}
