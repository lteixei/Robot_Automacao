*** Settings ***
Library    SeleniumLibrary

*** Test Cases ***
Acessar Travessa
    Open Browser    https://www.travessa.com.br/    chrome
    Maximize Browser Window
    Sleep    5  # Espera 5 segundos para visualizar a página
    Close Browser
