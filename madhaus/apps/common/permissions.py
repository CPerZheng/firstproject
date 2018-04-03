from rest_framework import permissions


class IsModuleAdmin(permissions.BasePermission):
    """模块管理员"""
    def has_permission(self, request, view):
        up = request.user.up_user if hasattr(request.user, 'up_user') else None
        if up.permission == 1001:
            return True
        data = request.query_params if request.method == 'GET' else request.data
        if 'permission' not in data or not isinstance(data['permission'], int):
            return False
        status = data['permission']
        if status in [1002, 2002, 3002] and up.permission == 1002:
            return True
        if status in [1003, 2003, 3003] and up.permission == 1003:
            return True
        if status in [1004, 2004, 3004] and up.permission == 1004:
            return True
        if status in [1005, 2005, 3005] and up.permission == 1005:
            return True
        return False