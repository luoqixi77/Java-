package test.Fegin;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
@Component
public interface DeptClientService {

    @GetMapping("/dept/queryById/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/queryList")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

}
