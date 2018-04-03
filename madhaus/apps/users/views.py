import json

from common import permissions
from django.contrib.auth.models import User
from rest_framework import viewsets
from rest_framework.decorators import list_route
from rest_framework.response import Response
from django.views.decorators.http import require_POST, require_GET
from users.models import UsersShoppingAddress, UsersProfile
from users.serializer import UserShoppingAddressSerializer, UsersProfileSerializer
from common.helper import JSONResponse, get_data_format
from django.contrib.auth import authenticate, login, logout
from django.views.decorators.csrf import csrf_exempt


class UsersProfileViewSet(viewsets.ModelViewSet):
    queryset = UsersProfile.objects.all()
    serializer_class = UsersProfileSerializer

    # 登录
    @list_route(methods=['post'], url_path='login')
    def login(self, request, *args, **kwargs):

        if 'phone' not in request.data or not request.data['phone']:
            print(request.data)
            return JSONResponse(get_data_format(msg='手机号码不能为空'))

        if 'password' not in request.data or not request.data['password']:
            return JSONResponse(get_data_format(msg='密码不能为空'))

        try:
            phone = request.data['phone']
            password = request.data['password']
            user = authenticate(username=phone, password=password)
        except User.DoesNotExist:
            return JSONResponse(get_data_format(msg='找不到用户'))
        if user:
            login(request, user)
            try:
                user = UsersProfile.objects.get(user=user)
            except UsersProfile.DoesNotExist:
                user = UsersProfile()
                user.user = user
                user.save()
            serializer = UsersProfileSerializer(user, context={'request': request})
            print(serializer.data)
            return JSONResponse(get_data_format(True, None, serializer.data))
        else:
            return JSONResponse(get_data_format(msg='输入的账号密码不正确'))

    @list_route(methods=['get'], url_path='logout')
    def logout(self, request, *args, **kwargs):
        logout(request)
        return JSONResponse({'msg': '退出登录成功'})


# 用户收货地址
class UserShoppingAddressViewSet(viewsets.ModelViewSet):
    queryset = UsersShoppingAddress.objects.all()
    serializer_class = UserShoppingAddressSerializer

    # 查询收货人地址
    @list_route(methods=['get'], url_path='check_address')
    def check_address(self, request):
        """
        @api {get} /users/useraddress/check_address/ 查询收货人地址
        @apiName UserShoppingAddress
        @apiGroup User

        @apiDescription **收货人地址**</br>

        @apiParam {int} a_id 地址编号
        """
        try:
            # queryset = self.filter_queryset(self.get_queryset())
            if 'a_id' not in request.GET or not request.GET['a_id']:
                return Response(get_data_format(msg='无信息'))

            a_id = request.GET['a_id']
            address = UsersShoppingAddress.objects.get(id=a_id)
            a_serializer = self.get_serializer(address)
            return Response(a_serializer.data)
        except UsersShoppingAddress.DoesNotExist:
            return Response(get_data_format(msg='找不到地址'))
        except KeyError:
            return Response(get_data_format(msg='传入的值有误'))
        except ValueError:
            return Response(get_data_format(msg='传入的参数类型不正确'))




