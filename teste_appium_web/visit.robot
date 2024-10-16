*** Settings ***
Documentation  Teste para validar visita no chrome
Library    AppiumLibrary
Resource    ../page_objects/appium-web/base.robot
Resource    ../page_objects/appium-web/visit.robot

Suite Setup     Open Test Application
Test Setup      Run Keywords
...             Launch Application
Test Teardown   Quit Application
Suite Teardown  Run Keywords
...             Stop Gif Recording
...             Close Application

*** Variables ***
${REMOTE_URL}    http://127.0.0.1:4723/wd/hub
${CAPABILITIES}  {"platformName": "Android", "deviceName": "Android Emulator", "browserName": "Chrome"}

*** Test Cases ***
Valida a visita na pagina
    Acessar página do google
