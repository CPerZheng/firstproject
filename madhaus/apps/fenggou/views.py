from rest_framework import viewsets
from rest_framework.decorators import list_route
from rest_framework.response import Response

from fenggou.models import Product,ProductType, ProductPic, ProductSpec, ProductScroll
from fenggou.serializer import ProductSerializer, ProductTypeSerializer, ProductPicSerializer, ProductSpecSerializer, ProductScrollSerializer
from common.helper import JSONResponse,get_data_format

class ProductTypeViewSet(viewsets.ModelViewSet):
    queryset = ProductType.objects.filter().delete()
    serializer_class = ProductTypeSerializer


class ProductViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer

    # 商城首页
    @list_route(methods=['get'], url_path='home')
    def home(self, request):
        """
        @api {get} /fenggou/products/home/ 商城首页
        @apiName FenggouProductsHome
        @apiGroup FenggouProducts

        @apiDescription **疯购首页**</br>

        @apiParam {int} type_id 商品类型编号

        """
        # 判断是否有这个商品类型编号
        if 'type_id' not in request.query_params or not request.query_params['type_id']:
            return JSONResponse(get_data_format(msg='商品类型编号不能为空'))
        try:
            type_id = int(request.query_params['type_id'])
            pt = ProductType.objects.get(id=type_id)
        except ProductType.DoesNotExist:
            #Response != JSONResponse
            return Response(get_data_format(msg='无该编号的商品类型'))
        except ValueError:
            return Response(get_data_format(msg='传入的参数有误'))

        #创建查询集
        queryset = self.filter_queryset(self.get_queryset())
        queryset = queryset.filter(type=pt)

        pss = Product.objects.filter(level=1)
        pss_serializer = ProductSerializer(pss, many=True, context={'request': request})

        data = {'pro_scroll_list': pss_serializer.data}
        page = self.paginate_queryset(queryset)
        if page is not None:
            serializer = self.get_serializer(page, many=True)
            data['pro_list'] = serializer.data
            return self.get_paginated_response(data)

        serializer = self.get_serializer(queryset, many=True)
        data['pro_list'] = serializer.data
        return Response(data)


    #商品详情接口
    @list_route(methods=['get'], url_path='detail')
    def product_detail(self, request):
        """
        @api {get} /fenggou/products/detail/ 商品详情接口
        @apiName FenggouProductsDetail
        @apiGroup FenggouProducts

        @apiDescription **商品详情**</br>

        @apiParam {int} product_id 商品编号
        """
        if 'product_id' not in request.GET or not request.GET['product_id']:
            return JSONResponse(get_data_format(msg='商品编号不能为空'))

        try:
            product_id = request.GET['product_id']
            product = Product.objects.get(id=product_id)
            p_serializer = ProductSerializer(product, context={'request': request})

            # filter(**kwargs)返回一个包含对象的集合, 它们满足参数中所给的条件
            pic_list = ProductPic.objects.filter(product=product)
            product_list_serializer = ProductPicSerializer(pic_list, many=True, context={'request': request})

            data = {
                'product': p_serializer.data,
                'pic_list': product_list_serializer.data
            }
            return JSONResponse(get_data_format(True, None, data))
        except Product.DoesNotExist:
            return JSONResponse(get_data_format(msg='无该商品'))
        except KeyError:
            return JSONResponse(get_data_format(msg='传入的值有误'))
        except ValueError:
            return JSONResponse(get_data_format(msg='传入的商品格式有误'))


class ProductPicViewSet(viewsets.ModelViewSet):
    queryset = ProductPic.objects.all()
    serializer_class = ProductPicSerializer


class ProductScrollViewSet(viewsets.ModelViewSet):
    queryset = ProductScroll.objects.all()
    serializer_class = ProductScrollSerializer


class ProductSpecViewSet(viewsets.ModelViewSet):
    queryset = ProductSpec.objects.all()
    serializer_class = ProductSpecSerializer

    @list_route(methods=['get'], url_path='spec')
    def product_spec(self, request):
        """
        @api {get} /fenggou/products/spec/ 商品属性规格接口
        @apiName FenggouProductsSpec
        @apiGroup FenggouProducts

        @apiDescription **商品属性规格**</br>

        @apiParam {int} pro_id 商品编号
        """
        queryset = self.filter_queryset(self.get_queryset())
        try:
            if 'pro_id' in request.query_params:
                pro_id = int(request.query_params['pro_id'])
                pro = Product.objects.get(id=pro_id)
                queryset = queryset.filter(product=pro)
        except Product.DoesNotExist:
            return Response(get_data_format(msg='找不到该商品'))
        except ValueError:
            return Response(get_data_format(msg='传入的格式有误'))

        serializer = self.get_serializer(queryset, many=True)
        return Response(get_data_format(True, None, serializer.data))

