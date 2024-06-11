from rest_framework import serializers
from .models import Extension


class ExtensionRequestSerializer(serializers.ModelSerializer):
    class Meta:
        model = Extension
        fields = ['extension', 'is_checked']


class ExtensionResponseSerializer(serializers.ModelSerializer):
    class Meta:
        model = Extension
        fields = ['id', 'extension', 'type', 'is_checked']

    def get_result(self, obj):
        if obj.checked:
            return f"{obj.extension} 고정 확장자가 활성화 되었습니다."
        else:
            return f"{obj.extension} 고정 확장자가 비활성화 되었습니다."
