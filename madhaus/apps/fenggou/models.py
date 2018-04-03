from django.db import models
from django.contrib.auth.models import User

#商品类型表
class ProductType(models.Model):
    name = models.CharField('商品类型', unique=True, max_length=19)
    parent_type = models.ForeignKey('self', verbose_name='上级类型', related_name='pt_parent_type', blank=True, null=True, on_delete=True)
    # create_user = models.ForeignKey(User, verbose_name='创建用户', related_name='pt_create_user',blank=True, null=True, on_delete=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def __str__(self):
        return self.name

    class Meta:
        db_table = 'product_type'
        verbose_name = '疯购商品类型表'
        ordering = ['id']


# 商品信息表
class Product(models.Model):
    LEVEL = ((0, '不推荐'), (1, '推荐'))


    name = models.CharField('商品名称', max_length=59)
    fee = models.DecimalField('商品价格', max_digits=11, decimal_places=2, default=0)
    logic_fee = models.DecimalField('运费', max_digits=11, decimal_places=2, default=0)
    pic = models.CharField('图片', max_length=199, blank=True, null=True)
    buy_user = models.SmallIntegerField('已购买人数', default=0)
    level = models.SmallIntegerField('重点推荐', choices=LEVEL, default=0)
    content = models.CharField('商品详情', max_length=299, blank=True, null=True)
    type = models.ForeignKey(ProductType, verbose_name='商品类型', related_name='pro_name', blank=True, null=True, on_delete=True)
    inventory = models.BigIntegerField('库存', default=0)
    # spec = models.ForeignKey(ProductSpec, verbose_name='商品规格', related_name='p_ps',on_delete=True)
    # create_user = models.ForeignKey(User, verbose_name='创建用户', related_name='p_create_user',blank=True, null=True, on_delete=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def save(self, *args, **kwargs):
        if self.level == 1:
            pros = Product.objects.filter(level=1)
            if pros.count() >= 5:
                last_pro = pros.last()
                last_pro.level = 0
                last_pro.save()
        super(Product, self).save(*args, **kwargs)

    def __str__(self):
        return self.name


    class Meta:
        db_table = 'product'
        verbose_name = '疯购商品信息表'
        ordering = ['-id']


# 图片轮播
class ProductScroll(models.Model):
    product = models.ForeignKey(Product, verbose_name='商品', related_name='psc_product', blank=True, null=True,
                                on_delete=True)
    description = models.CharField('商品描述', max_length=199)
    pic = models.CharField('图片', max_length=199, blank=True, null=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def __str__(self):
        return self.product.name

    class Meta:
        db_table = 'product_scroll'
        verbose_name = '疯商品轮播图信息'
        ordering = ['-id']


#商品图片
class ProductPic(models.Model):

    product = models.ForeignKey(Product, verbose_name='商品', on_delete=True,related_name='pp_product', blank=True, null=None)
    pic = models.CharField('图片', max_length=199)
    is_default = models.SmallIntegerField('是否默认', choices=((0, '否'), (1, '是')), default=0)
    create_user = models.ForeignKey(User, verbose_name='创建用户', related_name='pp_create_user', blank=True, null=True, on_delete=True)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('修改时间', auto_now=True)

    def save(self,*args, **kwargs):
        if self.is_default == 1:
            fpps = ProductPic.objects.filter(product=self.product)
            if fpps:
                for fpp in fpps:
                    fpp.is_default = 0
                    fpp.save()
            super(ProductPic, self).save(*args, **kwargs)

    def __str__(self):
        return self.product.name


    class Meta:
        db_table = 'product_pic'
        verbose_name = '商品图片信息'
        ordering = ['id']


#商品属性(规格)
class ProductSpec(models.Model):

    product = models.ForeignKey(Product, verbose_name='商品', related_name='ps_product', blank=True, null=True, on_delete=True)
    standard = models.CharField('商品规格', max_length=199)
    is_default = models.SmallIntegerField('是否默认', choices=((0, '否'), (1, '是')), default=1)
    fee = models.DecimalField('商品价格', max_digits=11, decimal_places=2, blank=True, null=True)
    inventory = models.BigIntegerField('库存', default=0)
    create_time = models.DateTimeField('创建时间', auto_now_add=True)
    update_time = models.DateTimeField('更新时间', auto_now=True)

    def save(self, *args, **kwargs):
        if self.is_default == 1:
            idps = ProductSpec.objects.filter(product=self.product, is_default=1)
            if idps:
                for idp in idps:
                    idp.is_default = 0
                    idp.save()
            super(ProductSpec, self).save(*args, **kwargs)

    def __str__(self):
        return self.standard


    class Meta:
        db_table = 'product_spec'
        verbose_name = '商品属性表'
        ordering = ['-id']