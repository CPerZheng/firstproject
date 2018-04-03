from rest_framework.urlpatterns import format_suffix_patterns
from django.conf.urls import url
from orders.views import OrderViewSet, OrderProductViewSet, OrderCarViewSet


urlpatterns = format_suffix_patterns([
    url(r'^orders/$', OrderViewSet),
    url(r'orders/(?P<pk>[0-9]+)/$', OrderViewSet),
    url(r'^orders/orderpro/$', OrderProductViewSet),
    url(r'^orders/car/$', OrderCarViewSet)
])