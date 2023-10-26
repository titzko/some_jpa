select userTable.id, userTable.first_name, userTable.second_name from my_user userTable where userTable.id=?

select basket.user_id,product.id,product.product_name
from basket basket
    join product product on product.id = basket.product_id where basket.user_id=?
