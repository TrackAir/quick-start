package fund.lucida.app.controller;


import fund.lucida.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/ss")
    public String newMethod(@RequestParam Map map){
        String st = testService.getByName("aave");
        System.out.println(st);
        String name = map.get("name").toString();
        System.out.println("你的地址是 ： " + name);
        return name;
    }

    @GetMapping("/")
    public String t(@RequestParam Map map){
        return "asdasd";
    }
}
