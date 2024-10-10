*** Keywords ***
Open Test Application
    [Documentation]    Open the mobile application
    Open Application    http://127.0.0.1:4723/wd/hub    {"platformName": "Android", "platformVersion": "10.0", "deviceName": "emulator-5554", "app": "path/to/your/app.apk"}

*** Settings ***
Documentation  Teste para validar interação com alertas
Resource    ../page_objects/appium/base.robot
Resource    ../page_objects/appium/menu.robot
Resource    ../page_objects/appium/alertas.robot
Library    AppiumLibrary

Suite Setup     Open Test Application
Test Setup      Run Keywords
...             Launch Application      AND
...             Valida se a tela principal está visível
Test Teardown   Quit Application
Suite Teardown  Run Keywords
...             Stop Gif Recording
...             Close Application

*** Test Cases ***
Confirmar um alerta
    Acessar menu    Alertas
    Clicar em alerta confirm
    Valida título do alerta         Info
    Valida mensagem do alerta       Confirma a operação?
    Clicar em confirmar
    Valida mensagem do alerta       Confirmado
    Clicar em sair

Fechar um alerta clicando fora do alerta
    Acessar menu    Alertas
    Clicar em alerta simples
    Run Keyword And Ignore Error        Tocar na tela pelas coordenadas        100     150
    Valida se o texto não está visível       Pode clicar no OK ou fora da caixa para sair

Tentar fechar um alerta clicando fora do alerta
    Acessar menu    Alertas
    Clicar em alerta restritivo
    Run Keyword And Ignore Error        Tocar na tela pelas coordenadas        100     150
    Valida se o texto está visível       Não pode clicar fora, apenas no SAIR