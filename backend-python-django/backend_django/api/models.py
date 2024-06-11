from django.db import models


# Create your models here.

class Extension(models.Model):
    id = models.AutoField(primary_key=True)
    extension = models.CharField(max_length=100, unique=True)
    type = models.CharField(max_length=100)
    is_checked = models.BooleanField(default=False)

    def __str__(self):
        return self.extension
