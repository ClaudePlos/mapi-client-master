package pl.kskowronski.mapiclientmaster.data.service.course;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kskowronski.mapiclientmaster.data.model.Course;
import pl.kskowronski.mapiclientmaster.data.model.GenericResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseApi {

    @GetMapping(path = "")
    public GenericResponse<List<Course>> listAllReports() {
        GenericResponse resp = new GenericResponse();
        List<Course> courses = new ArrayList<>();
        Course c01 = new Course(BigDecimal.ONE,"Programowanie","Prog z Klaud");
        Course c02 = new Course(BigDecimal.valueOf(2),"Gotowanie","Gotowanie z Klaud");
        Course c03 = new Course(BigDecimal.valueOf(3),"Angielski","Ang z Klaud");
        courses.add(c01);
        courses.add(c02);
        courses.add(c03);
        resp.setBody(courses);
        return resp;
    }

}
