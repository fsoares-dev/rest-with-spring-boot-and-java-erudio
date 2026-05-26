package FirstStepsInJavaSpringBoot_04.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import FirstStepsInJavaSpringBoot_04.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!"; //depois da virgula é como se fosse um placeholder
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/greeting?name=Leandro
    @RequestMapping("/greeting") //aqui eu coloco onde minha requisição sera feita para este end point
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word")//aqui deixamos nosso placeholder com valor default Word e valor eu do path param eu posso variar com nomes
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
