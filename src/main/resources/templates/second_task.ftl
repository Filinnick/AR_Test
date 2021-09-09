<#import "parts/common.ftl" as c>
<@c.page>
    <div><H5>Second test</H5></div>
    <div class="row ma-6 flex-content">
        <div class="col-sm">
            <div class="card">
                <div class="form-group flex-content">
                    <form method="post" action="/secondtask_payment" class="form-inline">
                        <H6>Введите данные о платеже</H6>
                        <input type="text" required name="name" class="form-control mb-3" placeholder="Имя платежа">
                        <label>Дата проведения платежа</label>
                        <input type="date" required name="supplyDate" class="form-control mb-3">
                        <select type="text" name="part" class="form-control mb-3">
                            <option value="д">Дебет</option>
                            <option value="к">Кредит</option>
                        </select>
                        <input type="number" required name="value" class="form-control mb-3" placeholder="Сумма платежа">
                        <div>
                            <input type="checkbox" name="state" value="true">
                            <label>Передавать в налоговую</label>
                        </div>
                        <button type="submit" class="btn btn-primary ml-2">Отправить</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm">
            <div class="card">
                <div class="form-group">
                    <form method="post" action="/secondtask_date" class="form-inline">
                        <label>Расчетная дата</label>
                        <input type="date" name="inputDate" class="form-control mb-3">
                        <button type="submit" class="btn btn-primary ml-2 mb-3">Отправить</button>
                    </form>
                    <#if result??>
                        <p>Баланс в указанную дату: ${result.balance}</p>
                        <p>Процент налога на доход: ${result.percent}</p>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</@c.page>