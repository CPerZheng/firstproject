from django.test import TestCase, Client


class FenggouProductTestCase(TestCase):

    fixtures = [
        'fixtures/fenggou/fenggou_product.json',
        'fixtures/fenggou/fenggou_product_type.json',
        # 'fixtures/fenggou/fenggou_product_price.json',
        'fixtures/fenggou/fenggou_product_pic.json',
        'fixtures/fenggou/fenggou_product_price'
    ]
    def setUp(self):
        self.c = Client()


    def test_home(self):
        response = self.c.get(
            path='/fenggou/products/home/',
            data={
                'type_id':1
            }
        )
        print('首页测试:')
        print(response.json())
    #     # self.assertEqual(response.json()['success'], True)
    #
    # def test_product_detail(self):
    #     response = self.c.get(
    #         path='/fenggou/products/detail/',
    #         data={
    #             'product_id': 1
    #         }
    #     )
    #     print('商品详情测试:')
    #     print(response.json())
    #     self.assertEqual(response.json()['success'], True)

    # def test_product_spec(self):
    #     response = self.c.get(
    #         path='/fenggou/product/spec/spec/',
    #         data={
    #             'pro_id': 1
    #         }
    #     )
    #     print('商品规格测试:')
    #     print(response.json())
    #     self.assertEqual(response.json()['success'], True)
