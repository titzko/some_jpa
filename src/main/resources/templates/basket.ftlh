<#-- @ftlvariable name="basket" type="com.example.simplewebshop.model.Basket"  -->


<!DOCTYPE html>
<html>
<head>
    <title>Title of the document</title>
</head>

<body style="display: flex; justify-content: center; align-items: center; margin-top: 35px; font-size: 22px;">
<#if basket??>
    <div>
        <h2>This is the basket for the user ${basket.user.firstName + " " + basket.user.secondName}</h2>

        <p>${basket.user.firstName} has the following products in his basket</p>
        <div><b>Status:</b> ${basket.status}</div>

        <ul>
            <#list basket.basketItems![] as basketItem>
                <li>${basketItem.quantity}x ${basketItem.product.productName}</li>
            </#list>
        </ul>
    </div>
<#else >
    404 user not found
</#if>
</body>

</html>