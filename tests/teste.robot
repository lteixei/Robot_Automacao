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
    Execute JavaScript    document.querySelector('.fa.fa-whatsapp.my-float').style.display='none';
    Log    Verificando se o campo de pesquisa está visível.
    Wait Until Element Is Visible    xpath=//input[@placeholder='Pesquisar']    timeout=30
    Log    Campo de pesquisa está visível.
    Input Text    xpath=//input[@placeholder='Pesquisar']    Contos Eróticos
    Click Element    xpath=//*[@id="ucCabecalho_menu"]/ul/a[1]
    Click Element    xpath=/html/body/form/div[5]/div[1]/div/div[2]/section[1]/div/div/div[2]/div/div/button
    Wait Until Element Is Visible    xpath=//*[@id="form1"]/div[4]/a    timeout=10
    Click Element    xpath=//*[@id="form1"]/div[4]/a
    [Teardown]    Close Browser

*** Keywords ***
Busca No Site
    Input Text    css=input[type='text']    Contos Eróticos
    Click Element    xpath=//*[@id="ucCabecalho_menu"]/ul/a[1]
    
    # Aumentar o tempo de espera
    Wait Until Element Is Visible    xpath=/html/body/form/div[5]/div[1]/div/div[2]/section[1]/div/div/div[2]/div/div/button    timeout=15
    
    # Tentar esconder o ícone do WhatsApp
    Execute JavaScript    var element = document.querySelector('.fa.fa-whatsapp.my-float'); if (element) { element.style.display = 'none'; }
    
    # Clicar no botão de comprar
    Click Element    xpath=/html/body/form/div[5]/div[1]/div/div[2]/section[1]/div/div/div[2]/div/div/button
    
    Wait Until Element Is Visible    xpath=//*[@id="form1"]/div[4]/a    timeout=10
    Click Element     xpath=//*[@id="form1"]/div[4]/a
