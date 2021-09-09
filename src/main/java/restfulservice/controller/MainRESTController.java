package restfulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restfulservice.dao.PaymentsDAO;
import restfulservice.model.Payment;
import restfulservice.model.Result;
import restfulservice.services.InputTextProcessing;
import restfulservice.services.PaymentListProcessing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class MainRESTController {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private InputTextProcessing inputText;

    @Autowired
    private PaymentListProcessing paymentListProcessing;

    @Autowired
    private PaymentsDAO paymentsDAO;

    @GetMapping("/main")
    public String mainPage() { return "main_page"; }

    @GetMapping("/firsttask")
    public String firstTaskPage() { return "first_task"; }

    @PostMapping("/firsttask")
    public String postString(@RequestParam String text, Map<String, Object> model) {
        inputText.setInputString(text);
        model.put("outputText",inputText.getOutputString());
        return "first_task";
    }

    @GetMapping("/secondtask")
    public String secondTaskPage() { return "second_task"; }

    @PostMapping("/secondtask_payment")
    public String addPayment(
            @RequestParam String name,
            @RequestParam String supplyDate,
            @RequestParam(required = false) boolean state,
            @RequestParam char part,
            @RequestParam long value) throws ParseException {

        Payment payment = new Payment();

        payment.setName(name);
        payment.setSupplyDate(formatter.parse(supplyDate));
        if(!state) {
            state = false;
        }
        payment.setState(state);
        payment.setPart(part);
        payment.setValue(value);

        paymentsDAO.addPayment(payment);

        return "second_task";
    }

    @PostMapping("/secondtask_date")
    public String getDateresult(@RequestParam String inputDate, Map<String, Object> model) throws ParseException {
        paymentListProcessing.setPaymentList(paymentsDAO.getPaymentList());
        Result result = paymentListProcessing.getResult(formatter.parse(inputDate));
        model.put("result", result);
        return "second_task";
    }


}
