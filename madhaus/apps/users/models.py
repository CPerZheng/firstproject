from django.db import models
from django.contrib.auth.models import User

# 用户资料
class UsersProfile(models.Model):
    PERMISSION = ((0, '无'), (1001, '所有管理'))

    user = models.OneToOneField(User, verbose_name='用户', related_name='up_user',on_delete=True)
    phone = models.CharField('手机号', max_length=19, blank=True, null=True)
    nickname = models.CharField('昵称', max_length=50, blank=True, null=True)
    username = models.CharField('用户登录账号', max_length=50, blank=True, null=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('修改时间', auto_now=True)

    def __str__(self):
        return self.nickname or self.user.username

    # def check_counts(self):
    #     # 连签次数
    #     return 0
    #
    def today_check(self):
        # 今天是否签到
        return 0

    class Meta:
        db_table = 'user_profile'
        verbose_name = '用户资料表'
        verbose_name_plural = '用户信息列表'
        ordering = ['-id']

# 用户收货地址
class UsersShoppingAddress(models.Model):
    DEFAULT_ADDRESS = ((0, '不默认'), (1, '默认'))

    # user = models.ForeignKey(UsersProfile, verbose_name='用户', related_name='usa_user', on_delete=True)
    receive_name = models.CharField('收件人姓名', max_length=199, blank=True, null=True)
    address = models.CharField('收件地址', max_length=199, blank=True, null=True)
    phone = models.CharField('联系电话', max_length=199, blank=True, null=True)
    area = models.CharField('收件地区', max_length=199, blank=True, null=True)
    detail_address = models.CharField('详细地址', max_length=199, blank=True, null=True)
    default_address = models.SmallIntegerField('默认地址', choices=DEFAULT_ADDRESS, default=0)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def save(self, *args, **kwargs):
        if self.default_address == 1:
            usa = UsersShoppingAddress.objects.filter(default_address=1)
            for us in usa:
                us.default_address = 0
                us.save()
        super(UsersShoppingAddress, self).save(*args, **kwargs)

    def __str__(self):
        return self.receive_name

    class Meta:
        db_table = 'users_shopping_address'
        verbose_name = '用户收货地址'
        ordering = ['-id']


# class UserCheck(models.Model):
#     user = models.ForeignKey(User, verbose_name='用户信息', related_name='uc_user', on_delete=True)
#     continuities = models.SmallIntegerField('连签数', default=0)
#     status = models.SmallIntegerField('签到', choices=((0, '未签到'), (1, '已签到')), default=0)
#     time = models.DateField('创建日期', auto_now_add=True)
#
#     def save(self, *args, **kwargs):
#         super(UserCheck, self).save(args, kwargs)
#
#     def check_counts(self):
#         return UserCheck.objects.filter(user=self.user).count()
#
#     def own_top(self):
#         return UserCheck.objects.filter(user=self.user).order_by('continuities').first().continuities
#
#     def ranges(self):
#         check_counts = UserCheck.objects.filter(user=self.user).count()
#         all_users = User.objects.all()
#         ranges = User.objects.all().count()
#         for everyone in all_users:
#             if UserCheck.objects.filter(user=everyone).count() < check_counts:
#                 ranges -= 1
#         return ranges
#
#     class Meta:
#         db_table = 'user_check'
#         unique_together = (('user', 'time'),)
#         ordering = ['-time']