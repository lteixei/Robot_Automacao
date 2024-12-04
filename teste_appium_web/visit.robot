*** Settings ***
Library    AppiumLibrary

*** Variables ***
${BROWSER}    Chrome
${URL}        http://example.com

*** Test Cases ***
Visit :: Teste para validar visita no chrome
    Open Application    ${URL}    browser=${BROWSER}
    Capture Page Screenshot
    Close Application
