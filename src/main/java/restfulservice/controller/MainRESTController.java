package restfulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restfulservice.model.InputTextProcessing;

@RestController
@RequestMapping("/tests")
public class MainRESTController {

    @Autowired
    private InputTextProcessing inputText;

    @PostMapping("/first")
    public void postString(@RequestBody String text) throws Exception {
        inputText.setInputString(text);
    }

    @GetMapping("/first")
    public String getString() {
        return inputText.getOutputString();
    }

}
