@echo off
setlocal enabledelayedexpansion

set folders=^
lib\app\routes ^
lib\app\theme ^
lib\core\constants ^
lib\core\utils ^
lib\core\services ^
lib\modules\auth\data ^
lib\modules\auth\domain ^
lib\modules\auth\presentation ^
lib\modules\home\presentation ^
lib\modules\restaurants\data ^
lib\modules\restaurants\domain ^
lib\modules\restaurants\presentation ^
lib\modules\taxi\data ^
lib\modules\taxi\domain ^
lib\modules\taxi\presentation ^
lib\modules\marketplace\data ^
lib\modules\marketplace\domain ^
lib\modules\marketplace\presentation ^
lib\modules\jobs\data ^
lib\modules\jobs\domain ^
lib\modules\jobs\presentation ^
lib\modules\chat ^
lib\shared\widgets ^
lib\shared\dialogs ^
lib\shared\banners ^
lib\generated

for %%f in (%folders%) do (
    if not exist %%f (
        mkdir %%f
        echo Carpeta creada: %%f
    )
)

REM Crear archivos base
echo void main() => runApp(MyApp()); > lib\main.dart
echo class MyApp extends StatelessWidget { @override Widget build(BuildContext context) => Container(); } >> lib\main.dart

echo // Aquí van las rutas de tu app > lib\app\routes\app_routes.dart
echo // Estilos de tu app > lib\app\theme\app_theme.dart
echo // Página de registro > lib\modules\auth\presentation\register_page.dart
echo // Página de login > lib\modules\auth\presentation\login_page.dart
echo // Página principal > lib\modules\home\presentation\home_page.dart
