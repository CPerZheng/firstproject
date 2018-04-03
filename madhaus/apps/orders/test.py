from django.test import TestCase, Client



class OrderTestCase(TestCase):
    fixtures = [
        'fixtures/fenggou/fenggou_orders.json',
        'fixtures/fenggou/fenggou_product_type.json',
        'fixtures/fenggou/fenggou_product.json',
        'fixtures/fenggou/fenggou_product_price.json',
        'fixtures/fenggou/fenggou_order_product.json'

    ]

    def setUp(self):
        self.c = Client()


    # def test_check_status(self):
    #     response = self.c.get(
    #         path='/orders/check_status/',
    #         data={
    #           # 'pay_status': 1,
    #           'log_status': 0
    #         }
    #     )
    #     print('我的订单接口测试:')
    #     print(response.json())
    #     self.assertEqual(response.json()['success'], True)

    def test_add(self):
        response = self.c.post(
            path='/orders/add/',
            data={
                'pro_price' : 15,
                'fare_price' : 10,
                'should_pay': 25,
                'pss': 1,
                'ps_price': 10,
                'ps_num': 2
            }
        )
        print('添加订单接口测试:')
        print(response.json())
        # self.assertEqual(response.json()['success'], True)