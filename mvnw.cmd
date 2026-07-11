@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@echo off
setlocal enabledelayedexpansion

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
setlocal enabledelayedexpansion

set MAVEN_PROJECTBASEDIR=%DIRNAME%
cd /d "%MAVEN_PROJECTBASEDIR%"

if not "%MAVEN_HOME%"=="" goto haveMavenHome

for %%i in (mvn.cmd) do set MAVEN_HOME=%%~$PATH:i
if "%MAVEN_HOME%"=="" (
  set MAVEN_HOME=%~dp0.mvn\wrapper\maven-bin
)
if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
  echo.
  echo Error: MAVEN_HOME is not properly set.
  echo.
  echo Please either set the environment variable MAVEN_HOME
  echo or download Maven from https://maven.apache.org/download.cgi
  echo.
  exit /b 1
)

:haveMavenHome
if "%MAVEN_HOME%"=="" goto error

set MAVEN_CMD="%MAVEN_HOME%\bin\mvn.cmd"

if not exist %MAVEN_CMD% (
  echo Downloading Maven...
  powershell -NoProfile -ExecutionPolicy Bypass -Command "& {$ProgressPreference='SilentlyContinue'; [Net.ServicePointManager]::SecurityProtocol=[Net.SecurityProtocolType]::Tls12; $url='https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip'; $dest='%TEMP%\maven.zip'; (New-Object System.Net.WebClient).DownloadFile($url, $dest); Expand-Archive -Path $dest -DestinationPath '%TEMP%'; Move-Item -Path '%TEMP%\apache-maven-3.9.6' -Destination '%MAVEN_HOME%' -Force; Remove-Item $dest -Force}"
)

if not exist %MAVEN_CMD% (
  echo.
  echo Error: Unable to locate Maven.
  echo Try setting MAVEN_HOME environment variable or install Maven manually.
  echo.
  exit /b 1
)

%MAVEN_CMD% %*
endlocal
