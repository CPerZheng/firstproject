# Generated by Django 2.0 on 2018-01-05 08:56

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0001_initial'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='usersprofile',
            options={'ordering': ['id'], 'verbose_name': '用户信息', 'verbose_name_plural': '用户信息列表'},
        ),
        migrations.RemoveField(
            model_name='usersprofile',
            name='nickname',
        ),
        migrations.RemoveField(
            model_name='usersprofile',
            name='username',
        ),
        migrations.AddField(
            model_name='usersprofile',
            name='nick_name',
            field=models.CharField(blank=True, max_length=32, null=True, verbose_name='昵称'),
        ),
        migrations.AddField(
            model_name='usersprofile',
            name='user_name',
            field=models.CharField(blank=True, max_length=32, null=True, verbose_name='登录账号'),
        ),
        migrations.AlterField(
            model_name='usersprofile',
            name='update_time',
            field=models.DateTimeField(auto_now=True, verbose_name='更新时间'),
        ),
    ]
