from django.shortcuts import render
from rest_framework import status
from rest_framework.response import Response

from .models import Extension
from rest_framework.views import APIView

from .serializers import ExtensionRequestSerializer, ExtensionResponseSerializer


# Create your views here.
class FixExtensionView(APIView):
    from rest_framework import status
    from rest_framework.response import Response

    def post(self, request, extension):
        print(f"Received POST request with extension: {extension}")
        try:
            # 이미 존재하는 extension 객체를 찾는다.
            extension_instance = Extension.objects.get(extension=extension)
            extension_instance.is_checked = True
            extension_instance.save()
            response_serializer = ExtensionResponseSerializer(extension_instance)
            return Response(response_serializer.data, status=status.HTTP_200_OK)
        except Extension.DoesNotExist:
            # 존재하지 않으면 새로운 객체를 생성한다.
            print(f"잘못된 고정 확장자 요청입니다.")
            # 임시 에러 처리
            return Response(response_serializer.data, status=status.HTTP_406_NOT_ACCEPTABLE)
            print(f"Serializer errors: {serializer.errors}")
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, extension):
        try:
            extension_instance = Extension.objects.get(extension=extension)
            extension_instance.is_checked = False
            extension_instance.save()
            response_serializer = ExtensionResponseSerializer(extension_instance)
            return Response(response_serializer.data, status=status.HTTP_200_OK)
        except Extension.DoesNotExist:
            return Response({'error': 'Extension not found'}, status=status.HTTP_404_NOT_FOUND)

    def get(self, request):
        extensions = Extension.objects.filter(is_checked=True)
        serializer = ExtensionResponseSerializer(extensions, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)
