import json

from rest_framework import viewsets
from rest_framework.decorators import list_route
from rest_framework.response import Response
from fenggou.models import ProductSpec
from orders.models import Order,OrderProduct, OrderCar
from orders.serializer import OrderSerializer,OrderProductSerializer, OrderCarSerializer
from common.helper import get_data_format, JSONResponse, generate_order_id


# 总订单
class OrderViewSet(viewsets.ModelViewSet):
    queryset = Order.objects.all()
    serializer_class = OrderSerializer

    # 查询指定状态的订单
    @list_route(methods=['get'], url_path='check_status')
    def check_status(self, request, *args, **kwargs):
        """
        @api {post} /orders/check_status/ 我的订单接口
        @apiName OrderCheckStatus
        @apiGroup Order

        @apiDescription **订单状态**</br>

        @apiParam {int} pay_status 支付状态
        @apiParam {int} log_status 物流状态
        """
        queryset = self.filter_queryset(self.get_queryset())
        try:
            if 'pay_status' in request.query_params and request.query_params['pay_status']:
                queryset = queryset.filter(pay_status=int(request.query_params['pay_status']))

            if 'log_status' in request.query_params and request.query_params['log_status']:
                queryset = queryset.filter(log_status=int(request.query_params['log_status']))
            print(queryset)

            page = self.paginate_queryset(queryset)
            if page is not None:
                serializer = self.get_serializer(page, many=True)
                return self.get_paginated_response(serializer.data)

            serializer = self.get_serializer(queryset, many=True)
            return JSONResponse(get_data_format(True, None, serializer.data))
        except ValueError:
            return JSONResponse(get_data_format(msg='传入的参数有误'))


    #添加订单
    @list_route(methods=['post'], url_path='add')
    def add(self, request, *args, **kwargs):
        """
        @api {get} /orders/add/ 添加订单接口
        @apiName OrderAdd
        @apiGroup Order

        @apiDescription **订单状态**</br>

        @apiParam {double} pro_price 商品总价
        @apiParam {double} fare_price 运费
        @apiParam {double} should_pay 应付
        @apiParam {int} pss 商品规格
        @apiParam {double} order_pro_price 商品总价
        @apiParam {double} order_fare_price 运费
        @apiParam {double} order_should_pay 应付
        @apiParam {int} ps_id 商品规格编号
        @apiParam {int} ps_num 商品规格数量
        @apiParam {int} ps_price 商品规格单价
        @apiParam {double} total_price 商品规格小计
        """
        if 'pro_price' not in request.data:
            return Response(get_data_format(msg='商品价格合计不能为空'))

        if 'fare_price' not in request.data:
            return Response(get_data_format(msg='运费合计不能为空'))

        if 'should_pay' not in request.data:
            return Response(get_data_format(msg='应付合计不能为空'))

        if 'pss' not in request.data or not request.data['pss']:
            return Response(get_data_format(msg='商品规格不能为空'))

        try:
            order_pro_price = float(request.data['pro_price'])
            order_fare_price = float(request.data['fare_price'])
            order_should_pay = float(request.data['should_pay'])
            order_pss = request.data['pss']
            if order_should_pay != (order_fare_price + order_pro_price):
                return Response(get_data_format(msg='价格计算有误'))

            # 创建订单
            order = Order()
            order.order_id = generate_order_id()
            order.pro_fee = order_pro_price
            order.log_fee = order_fare_price
            order.all_price = order_pro_price + order_fare_price
            order.should_fee = order_should_pay
            order.actual_fee = order_should_pay
            order.pay_way = 0
            order.pay_status = 0
            order.ord_status = 1
            order.log_status = 0
            order.logistics_number = 0

            order.save()

            # 商品小计 = 商品单价 * 商品数量
            ps_price = request.data['ps_price']
            ps_num = request.data['ps_num']
            ps_total = int(ps_price)*int(ps_num)
            print(ps_total)

            # 添加订单商品
            op = OrderProduct()
            op.order = order
            op.op_spec = order_pss
            op.pro_num = ps_num
            op.pro_total_fee = ps_price
            op.should_fee = ps_total
            op.ord_status = order.ord_status
            op.pro_fee = order_fare_price
            op.log_com = '中通'
            op.log_num = 0

            op.save()
            serializer = OrderSerializer(order, context={'request': request})
            return JSONResponse(get_data_format(serializer.data))
        except KeyError:
            return JSONResponse(get_data_format(msg='传入的值不正确'))
        # except ValueError:
        #     return JSONResponse(get_data_format(msg='传入的参数格式不正确'))
        except Order.DoesNotExist:
            return JSONResponse(get_data_format(msg='找不到该订单的数据'))
        except OrderProduct.DoesNotExist:
            return JSONResponse(get_data_format(msg='找不到该订单商品'))


# 订单商品
class OrderProductViewSet(viewsets.ModelViewSet):
    queryset = OrderProduct.objects.all()
    serializer_class = OrderProductSerializer


# 购物车
class OrderCarViewSet(viewsets.ModelViewSet):
    queryset = OrderCar.objects.all()
    serializer_class = OrderCarSerializer

    # def center(self, request):
    #     if not hasattr(request, 'user') or not request