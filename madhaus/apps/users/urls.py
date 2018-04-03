from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
# from users.views import user_login

from users.views import UserShoppingAddressViewSet, UserProfileViewSet



urlpatterns = format_suffix_patterns([
    # url(r'^user-profiles/$', UserProfileViewSet),
    # url(r'^useraddress/$', UserShoppingAddressViewSet)
])