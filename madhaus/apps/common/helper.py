import time
import random
import datetime
from django.http import HttpResponse
from rest_framework.renderers import JSONRenderer
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from django.utils import timezone
import re
import xml.etree.ElementTree as Et

def generate_order_id():
    #随机产生订单编号
    return '{0}{1}{2}'.format(
        generate_role_number(),
        str(int(time.time() * 1000000))[::-1][:6],
        generate_role_number()
    )

def generate_role_number():
    #随机产生6位数权限码
    return str(random.randint(100000, 999999))

def get_data_format(success=False, msg=None, content=None):
    data = {
        'success': success,
        'msg': msg,
        'content': content,
    }
    return data


class JSONResponse(HttpResponse):
    """响应内容为json格式"""

    def __init__(self, data, **kwargs):
        content = JSONRenderer().render(data)
        kwargs['content_type'] = 'application/json'
        super(JSONResponse, self).__init__(content, **kwargs)
        self["Access-Control-Allow-Origin"] = "*"
        self["Access-Control-Allow-Methods"] = "POST, GET, OPTIONS"
        self["Access-Control-Max-Age"] = "1000"
        self["Access-Control-Allow-Headers"] = "*"
