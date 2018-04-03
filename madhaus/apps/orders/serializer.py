from rest_framework import serializers
from orders.models import Order, OrderProduct, OrderCar
from users.serializer import UserShoppingAddressSerializer


class OrderProductSerializer(serializers.ModelSerializer):
    order_id = serializers.ReadOnlyField(source='order.order_id')
    spec = serializers.ReadOnlyField(source='op_spec.standard')
    pro_pic = serializers.ReadOnlyField(source='op_spec.product.pic')
    pro_id = serializers.ReadOnlyField(source='op_spec.product.id')
    pro_name = serializers.ReadOnlyField(source='op_spec.product.name')

    class Meta:
        model = OrderProduct
        fields = 'url', 'id', 'order', 'order_id', 'op_spec', 'pro_num', 'pro_fee', 'pro_total_fee',\
                 'ord_status', 'pay_status', 'should_fee', 'actual_fee', 'log_fee', 'log_com', 'log_num', 'create_time',\
                 'update_time',  'spec', 'pro_pic', 'pro_id', 'pro_name'


class OrderSerializer(serializers.ModelSerializer):
    op_order = OrderProductSerializer(many=True, read_only=True)
    receive_address = UserShoppingAddressSerializer(many=True, read_only=True)

    class Meta:
        model = Order
        fields = 'url', 'id', 'order_id', 'pro_fee', 'log_fee', 'all_price','should_fee',\
                 'actual_fee', 'pay_way', 'pay_status', 'order_status', 'log_status','ord_status',\
                 'logistics_number', 'create_time', 'update_time', 'op_order', 'receive_address'


class OrderCarSerializer(serializers.ModelSerializer):
    pro_name = serializers.ReadOnlyField(source='pro_spec.product.name')
    pro_pic = serializers.ReadOnlyField(source='pro_spec.product.pic')
    pro_id = serializers.ReadOnlyField(source='pro_spec.product.id')
    logic_fee = serializers.ReadOnlyField(source='pro_spec.product.logic_fee')
    ps_standard = serializers.ReadOnlyField(source='pro_spec.standard')
    ps_fee = serializers.ReadOnlyField(source='pro_spec.fee')

    class Meta:
        model = OrderCar
        fields = 'url', 'id', 'product', 'pro_spec', 'one_price', 'number', 'create_time',\
                 'update_time', 'pro_name', 'pro_pic', 'pro_id', 'logic_fee', 'ps_standard', 'ps_fee'


