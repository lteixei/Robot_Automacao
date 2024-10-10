*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${SCREENSHOT_DIR}    screenshots

${URL}           https://www.travessa.com.br/
${EMAIL}         lteixei@gmail.com
${PASSWORD}      leolmt0406
${NEW_EMAIL}     lteixei@hotmail.com
${NEW_PASSWORD}  leolmt0406
${NOME}          Leonardo
${APELIDO}       leo
${CPF}           07158481786
${DIA}           12101976
${CELULAR_DDD}   21
${CELULAR}       964171960
${RES_DDD}       21
${RESIDENCIAL}   34491789
${CEP}           21341370
${ENDERECO}     Rua Comendador Pinto
${NUMERO}       516
${COMPLEMENTO}   bloco 1 apt 401
${BAIRRO}       Campinho

*** Test Cases ***
Novo Usuário na Livraria da Travessa
    [Setup]    Open Browser    ${URL}    chrome
    Busca No Site
    [Teardown]    Close Browser

*** Keywords ***
Busca No Site
    Input Text       xpath=/html/body/form/div[3]/nav/ul/input    Contos Eróticos
    Click Element    xpath=//*[@id="ucCabecalho_menu"]/ul/a[1]
    Click Element     xpath=/html/body/form/div[5]/div[1]/div/div[2]/section[1]/div/div/div[2]/div/div/button
    Click Element     xpath=//*[@id="form1"]/div[4]/a

