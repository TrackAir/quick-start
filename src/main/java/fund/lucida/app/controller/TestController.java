package fund.lucida.app.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {
//    @Autowired
//    private TestService testService;

    @Value("${spring.env}")
    String env;
    @GetMapping("/")
    public String t(@RequestParam Map map){
        return env;
    }
}
