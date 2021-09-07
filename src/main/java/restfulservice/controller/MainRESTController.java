package restfulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restfulservice.dao.PaymentsDAO;
import restfulservice.model.Payment;
import restfulservice.model.Result;
import restfulservice.services.InputTextProcessing;
import restfulservice.services.PaymentService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tests")
public class MainRESTController {

    @Autowired
    private InputTextProcessing inputText;

    @Autowired
    private PaymentsDAO paymentsDAO;


    @PostMapping("/first")
    public void postString(@RequestBody String text) {
        inputText.setInputString(text);
    }

    @GetMapping("/first")
    public String getString() {
        return inputText.getOutputString();
    }

    @PostMapping("/second")
    public void addPayment(@RequestBody Payment payment) {
        paymentsDAO.addPayment(payment);
    }

    @GetMapping("/second")
    public List<Payment> getPayments() {
        return paymentsDAO.getPaymentList();
    }

    @GetMapping("/second/{date}")
    public Result getResult(@RequestBody Date date) {
        List<Payment> payments = paymentsDAO.getPaymentList();
        Result currentResult = new Result();
        for(Payment payment : payments){
            /* if(date > payment.getDate) {
            *       if(payment.getPart == 'д') { currentResult.setBalance = currentResult.getBalance + payment.getValue;
            *               if(payment.getState) currentResult.setPercent = currentResult.getPercent + payment.getValue*0.13 //0.13 - налог
            *       }
            *       else { currentResult.setBalance = currentResult.getBalance - payment.getValue; }
            * }
             */
        }

        return currentResult;
    }

}
