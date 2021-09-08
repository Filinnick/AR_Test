<#import "parts/common.ftl" as c>
<@c.page>
    <div><H5>First test</H5></div>
    <div class="form-row mt-5">
        <div class="form-group col-md-6">
            <form method="post" action="/firsttask" class="form-inline">
                <textarea type="text" name="text" class="form-control mb-3" placeholder="Введите текст сюда"></textarea>
                <button type="submit" class="btn btn-primary ml-2 mb-3">Преобразовать</button>
            </form>
        </div>
    </div>
    <#if outputText??>
    <div class="form-row mt-5">
        <div class="form-group col-md-6">
            <div class="m-2">
                <p><pre>${outputText}</pre></p>
            </div>
        </div>
    </div>
    </#if>
</@c.page>