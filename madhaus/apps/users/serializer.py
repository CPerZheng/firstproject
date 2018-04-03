from django.contrib.auth.models import User

from users.models import UsersProfile, UsersShoppingAddress
from rest_framework import serializers



class UsersProfileSerializer(serializers.ModelSerializer):

    class Meta:
        model = UsersProfile
        fields = ('url', 'id', 'user', 'phone', 'nickname', 'username', 'today_check')


class UserShoppingAddressSerializer(serializers.ModelSerializer):

    class Meta:
        model = UsersShoppingAddress
        fields = ('url', 'id', 'user', 'receive_name', 'address', 'phone',
                  'area', 'detail_address', 'default_address', 'create_time', 'update_time')


