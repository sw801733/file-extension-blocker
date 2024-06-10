from django.db import models


# Create your models here.

class Extension(models.Model):
    id = models.AutoField(primary_key=True)
    extension = models.CharField(null=False)
    type = models.CharField(null=False)
    is_Checked = models.BooleanField(null=False)

    def __str__(self):
        return self.extension
