package restfulservice.dao;

import org.springframework.stereotype.Repository;
import restfulservice.model.Payment;


import java.util.ArrayList;
import java.util.List;


@Repository
public class PaymentsDAO {

/*   | name |   Date   | state | part | value |
     ------------------------------------------
*    |   a  | 20.03.21 | true  | 'к'  | 2000  |
*    |   b  | 20.03.21 | true  | 'к'  | 3000  |
*    |   c  | 20.03.21 | true  | 'к'  | 145   |
*    |   d  | 20.03.21 | false | 'п'  | 500   |
*    |   e  | 20.03.21 | false | 'п'  | 600   |
 */

    private static final List<Payment> paymentList = new ArrayList<Payment>();

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }





    //TODO нужно сделать метод обновления платежа (в случае опечатки)
    public void updatePayment(Payment payment) {
    }

    //TODO удаление платежа
    public void deletePayment(Payment payment) {
    }
}
