package restfulservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import restfulservice.model.Payment;
import restfulservice.model.Result;

import java.util.Date;
import java.util.List;

@Service
public class PaymentListProcessing {

    private List<Payment> paymentList;

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Result getResult(Date date) {
        Result currentResult = new Result();
        for(Payment payment : paymentList){
            if(date.after(payment.getSupplyDate())) {
                if(payment.getPart() == 'д') {
                    currentResult.setBalance(currentResult.getBalance() + payment.getValue());
                    if(payment.getState()){
                        currentResult.setPercent(currentResult.getPercent() + payment.getValue()*0.13F); //0.13 - налог
                    }
                }
                else { currentResult.setBalance(currentResult.getBalance() - payment.getValue()); }
            }
        }

        return currentResult;
    }
}
