<#-- @ftlvariable name="user" type="com.example.simplewebshop.model.MyUser"  -->


<!DOCTYPE html>
<html>
<head>
    <title>Title of the document</title>
</head>

<body>
<#if user??>
This is the basket for the user <b>${user.firstName + " " + user.secondName}</b>

<p>${user.firstName} has the following products in his basket</p>

<ul>
    <#list (user.products)![] as product>
        <li>${product.productName}</li>
    </#list>
</ul>
    <#else >
    404 user not found
</#if>
</body>

</html>