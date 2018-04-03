from django.test import TestCase, Client
from django.contrib.auth.models import User

class UsersTestCase(TestCase):
    fixtures = [
        'fixtures/user/users.json',
        'fixtures/user/users_profile.json',
        # 'fixtures/user/users_address.json',
        # 'fixtures/user/users_check.json',
        # 'fixtures/user/users_feeback.json',
    ]

    def setUp(self):
        self.c = Client()


    def test_login(self):
        reesponse = self.c.post(
            path='/user-profiles/login/',
            data={
                'phone': '13900000001',
                'password': '123456'
            }
        )
        print('登录测试:')
        print(reesponse.json())



    # def test_check_address(self):
    #     response = self.c.get(
    #         path='/users/useraddress/check_address/',
    #         data={
    #             'a_id': 1
    #         }
    #     )
    #     print('收件人地址测试:')
    #     print(response.json())
        # self.assertEqual(response.json()['success'], True)


    # def test_add(self):
    #     response = self.c.get(
    #         path='',
    #         data={
    #
    #         }
    #     )