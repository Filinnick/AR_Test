<#import "parts/common.ftl" as c>
<@c.page>
    <div class="form-row mt-5">
        <div class="form-group col-md-6">
            <form method="get" action="/firsttask" class="form-inline">
                <button type="submit" class="btn btn-primary ml-2 mb-3">First task</button>
            </form>
            <form method="get" action="/secondtask" class="form-inline">
                <button type="submit" class="btn btn-primary ml-2 mb-3">Second task</button>
            </form>
        </div>
    </div>
</@c.page>