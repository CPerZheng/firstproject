from rest_framework.urlpatterns import format_suffix_patterns
from django.conf.urls import url, include
from apps.fenggou.views import ProductViewSet, ProductPicViewSet, ProductSpecViewSet, ProductTypeViewSet, ProductScrollViewSet

urlpatterns = format_suffix_patterns([

    url(r'product/(?P<pk>[0-9]+)/$', ProductTypeViewSet),
    url(r'^product/$', ProductViewSet),
    url(r'product/(?P<pk>[0-9]+)/$', ProductViewSet),
    url(r'product/(?P<pk>[0-9]+)/$', ProductPicViewSet),
    url(r'^product/(?P<pk>[0-9]+)/$', ProductScrollViewSet),
    url(r'^product/spec/$', ProductSpecViewSet)
])