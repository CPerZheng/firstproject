# Generated by Django 2.0 on 2018-01-05 08:38

from django.conf import settings
from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='UsersProfile',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('phone', models.CharField(blank=True, max_length=19, null=True, verbose_name='手机号')),
                ('nickname', models.CharField(blank=True, max_length=50, null=True, verbose_name='昵称')),
                ('username', models.CharField(blank=True, max_length=50, null=True, verbose_name='用户登录账号')),
                ('create_time', models.DateTimeField(auto_now_add=True, verbose_name='创建时间')),
                ('update_time', models.DateTimeField(auto_now=True, verbose_name='修改时间')),
                ('user', models.OneToOneField(on_delete=True, related_name='up_user', to=settings.AUTH_USER_MODEL, verbose_name='用户')),
            ],
            options={
                'verbose_name': '用户资料表',
                'db_table': 'user_profile',
                'ordering': ['-id'],
                'verbose_name_plural': '用户信息列表',
            },
        ),
        migrations.CreateModel(
            name='UsersShoppingAddress',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('receive_name', models.CharField(blank=True, max_length=199, null=True, verbose_name='收件人姓名')),
                ('address', models.CharField(blank=True, max_length=199, null=True, verbose_name='收件地址')),
                ('phone', models.CharField(blank=True, max_length=199, null=True, verbose_name='联系电话')),
                ('area', models.CharField(blank=True, max_length=199, null=True, verbose_name='收件地区')),
                ('detail_address', models.CharField(blank=True, max_length=199, null=True, verbose_name='详细地址')),
                ('default_address', models.SmallIntegerField(choices=[(0, '不默认'), (1, '默认')], default=0, verbose_name='默认地址')),
                ('create_time', models.DateTimeField(auto_now_add=True, verbose_name='创建时间')),
                ('update_time', models.DateTimeField(auto_now=True, verbose_name='更新时间')),
            ],
            options={
                'verbose_name': '用户收货地址',
                'db_table': 'users_shopping_address',
                'ordering': ['-id'],
            },
        ),
    ]