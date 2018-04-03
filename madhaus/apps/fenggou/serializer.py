from rest_framework import serializers
from fenggou.models import Product,ProductType, ProductPic, ProductSpec, ProductScroll


class ProductTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = ProductType
        fields = 'url', 'id', 'name', 'parent_type', 'create_time', 'update_time'


class ProductSpecSerializer(serializers.ModelSerializer):
    pro_name = serializers.ReadOnlyField(source='product.name')

    class Meta:
        model = ProductSpec
        fields = 'url', 'id', 'product', 'standard', 'is_default',\
        'fee', 'inventory', 'create_time', 'update_time', 'pro_name'


class ProductSerializer(serializers.ModelSerializer):

    type_name = serializers.ReadOnlyField(source='type.name')
    ps_product = ProductSpecSerializer(many=True, read_only=True)

    class Meta:
        model = Product
        fields = 'url', 'id', 'name', 'fee', 'logic_fee', 'pic', 'buy_user',\
                 'level', 'content', 'type', 'inventory', 'create_time',\
                 'update_time', 'type_name', 'ps_product'


class ProductScrollSerializer(serializers.ModelSerializer):

    class Meta:
        model = ProductScroll
        fields = '__all__'


class ProductPicSerializer(serializers.ModelSerializer):
    class Meta:
        model = ProductPic
        fields = '__all__'


