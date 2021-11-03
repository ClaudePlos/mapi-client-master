package pl.kskowronski.mapiclientmaster.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kskowronski.mapiclientmaster.data.model.LoginDTO;
import pl.kskowronski.mapiclientmaster.data.model.Operator;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/operators")
@CrossOrigin(origins = "http://localhost:4200")
public class OperatorApi {

    @Autowired
    private OperatorRepo operatorRepo;

    @PostMapping(path = "login")
    public ResponseEntity<Operator> logInWorker(@RequestBody LoginDTO logInOper) {

        Operator operator = operatorRepo.findByLogin(logInOper.getUsername());

        if (operator != null && logInOper.getPassword().equals(operator.getPassword())) {
            return ResponseEntity.ok(operator);
        }

        return ResponseEntity.ok(new Operator());
    }

    @GetMapping(path = "/user-profile/{id}")
    public ResponseEntity<Operator> findUserProfile(@PathVariable("id") Long id) {
        Optional<Operator> operator = operatorRepo.findById(BigDecimal.valueOf(id));
        return ResponseEntity.ok(operator.get());
    }


}
