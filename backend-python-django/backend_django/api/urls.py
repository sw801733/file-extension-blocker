from django.urls import path
from .views import FixExtensionView

urlpatterns = [
    path('fix-extension', FixExtensionView.as_view(), name='fix-extension-list'),
    path('fix-extension/<str:extension>', FixExtensionView.as_view(), name='fix-extension-detail'),
]