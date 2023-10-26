-- sql which got generated by hibernate, just renamed the tables

-- first get Basket
select basketTable.id, basketTable.user_id
    from basket basketTable
    where basketTable.user_id = ?;

-- then join userTable on basketTable
select userTable.id, basketTable.id, userTable.first_name, userTable.second_name
    from my_user userTable
         left join basket basketTable on userTable.id = basketTable.user_id
where userTable.id = ?;

-- select basketItems from your basketTable
select basketItemTable.basket_id,
       basketItemTable.id,
       productTable.id,
       productTable.product_name,
       basketItemTable.quantity
from basket_item basketItemTable
         left join product productTable on productTable.id = basketItemTable.product_id
where basketItemTable.basket_id = ?;