@echo off
REM Run this script as Administrator to install Maven

echo Installing Maven via Chocolatey...
choco install maven -y

if %ERRORLEVEL% EQU 0 (
    echo Maven installed successfully!
    echo Refreshing environment variables...
    refreshenv
    echo Testing Maven installation...
    mvn --version
) else (
    echo Maven installation failed. Please ensure you are running as Administrator.
    pause
    exit /b 1
)

echo.
echo Maven is ready! You can now run: mvn test
pause
