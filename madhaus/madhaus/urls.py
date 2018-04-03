"""madhaus URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.conf.urls import url, include
from rest_framework.routers import DefaultRouter
from fenggou.views import ProductViewSet, ProductPicViewSet, ProductSpecViewSet, ProductTypeViewSet, ProductScrollViewSet
from users.views import UserShoppingAddressViewSet, UsersProfileViewSet
from orders.views import OrderViewSet, OrderProductViewSet, OrderCarViewSet

router = DefaultRouter()

router.register(r'user-profiles', UsersProfileViewSet)
# router.register(r'users/profile', UserProfileViewSet)
router.register(r'users/useraddress',UserShoppingAddressViewSet)
# router.register(r'users', UserViewSet)

router.register(r'fenggou/products/', ProductViewSet)
router.register(r'fenggou/products', ProductViewSet)
router.register(r'fenggou/product/type', ProductTypeViewSet)
router.register(r'fenggou/product/pic', ProductPicViewSet)
router.register(r'fenggou/product/scroll',ProductScrollViewSet)
router.register(r'fenggou/product/spec', ProductSpecViewSet)

router.register(r'orders', OrderViewSet)
router.register(r'order/orderpro', OrderProductViewSet)
router.register(r'order/car', OrderCarViewSet)

urlpatterns = [
    url(r'^', include(router.urls)),
    # url(r'user-profiles/^', include('users.urls'))

]
