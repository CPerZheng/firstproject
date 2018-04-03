from django.db import models

from fenggou.models import ProductSpec, Product
from users.models import UsersShoppingAddress


class Order(models.Model):

    PAYMENT_STATUS=((0, '未付款'), (1, '已付款'))
    PAY_WAY=((0, '其他'), (1, '微信'), (2, '支付宝'))
    ORDER_STATUS=((0, '未处理'), (1, '已下单'))
    LOGISTICS_STATUS=((0, '待发货'), (1, '已发货'), (2, '待收货'), (3, '已收货'), (4, '退货中'), (5, '已退货'))

    order_id = models.CharField('订单编号', max_length=59)
    pro_fee = models.DecimalField('商品价格合计', max_digits=9, decimal_places=2, default=0)
    log_fee = models.DecimalField('运费合计', max_digits=9, decimal_places=2, default=0)
    all_price = models.DecimalField('总合计', max_digits=9, decimal_places=2,default=0)
    should_fee = models.DecimalField('应付', max_digits=9, decimal_places=2, default=0)
    actual_fee = models.DecimalField('实付', max_digits=9, decimal_places=2, default=0)
    pay_way = models.SmallIntegerField('付款方式', choices=PAY_WAY, default=0)
    pay_status = models.SmallIntegerField('付款状态', choices=PAYMENT_STATUS, default=0)
    ord_status = models.SmallIntegerField('订单状态', choices=ORDER_STATUS, default=0)
    log_status = models.SmallIntegerField('物流状态', choices=LOGISTICS_STATUS, default=0)
    logistics_number = models.CharField('物流单号', max_length=19, blank=True, null=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def __str__(self):
        return self.order_id

    class Meta:
        db_table = 'order'
        verbose_name = '疯购订单信息'
        ordering = ['-id']


# 订单中的商品
class OrderProduct(models.Model):
    ORD_STATUS = ((0, '购物车'), (1, '已下单'), (2, '已完成'), (3, '已关闭'))
    PAY_STATUS = ((0, '待支付'), (1, '已支付'))

    order = models.ForeignKey(Order, verbose_name='订单', related_name='op_order', on_delete=True)
    # o_id = models.CharField('订单编号', max_length=59)
    op_spec = models.ForeignKey(ProductSpec, verbose_name='商品规格', related_name='op_orderspec', on_delete=True)
    pro_num = models.SmallIntegerField('商品数量')
    pro_fee = models.DecimalField('商品单价', max_digits=11, decimal_places=2, default=0)
    pro_total_fee = models.DecimalField('商品总价格', max_digits=11, decimal_places=2, default=0)
    ord_status = models.SmallIntegerField('订单状态', choices=ORD_STATUS, default=0)
    pay_status = models.SmallIntegerField('支付状态', choices=PAY_STATUS, default=0)
    should_fee = models.DecimalField('应付', max_digits=11, decimal_places=2, default=0)
    actual_fee = models.DecimalField('实付', max_digits=11, decimal_places=2, default=0)
    log_fee = models.DecimalField('商品运费', max_digits=11, decimal_places=2, default=0)
    log_com = models.CharField('物流公司', blank=True, null=True, max_length=199)
    log_num = models.CharField('物流单号', blank=True, null=True, max_length=199)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def __int__(self):
        return self.order_id

    class Meta:
        db_table = 'order_product'
        verbose_name = '订单商品'
        ordering = ['id']


class OrderCar(models.Model):
    STATUS = ((0, '待激活'), (1, '已激活'))

    product = models.ForeignKey(Product, verbose_name='商品', related_name='oc_product', on_delete=True)
    pro_spec = models.ForeignKey(ProductSpec, verbose_name='商品规格', related_name='oc_prospec', on_delete=True)
    one_price = models.DecimalField('商品单价', max_digits=11, decimal_places=2)
    number = models.IntegerField('商品数量', blank=True, null=True)
    status = models.SmallIntegerField('状态', choices=STATUS, default=0)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def __str__(self):
        return self.product.name

    class Meta:
        db_table = 'order_car'
        verbose_name = '购物车'
        ordering = ['-id']
