*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${URL}                https://demowebshop.tricentis.com/
${EMAIL}              LLTEI@GMAIL.COM
${PASSWORD}           123456

*** Test Cases ***
Adicionar Apparel E Shoes No Carrinho E Na Lista
    [Setup]    Open Browser    ${URL}    chrome
    Capture Page Screenshot

    Login
    Adicionar Produtos
    Limpar Carrinho
    Visualizar Lista De Produtos Em Falta
    Limpar Lista De Produtos Em Falta
    Ir Para Home

*** Keywords ***
Login
    Click Link    .ico-login
    Input Text    #Email    ${EMAIL}
    Input Text    #Password    ${PASSWORD}
    Click Element    #RememberMe
    Click Button    form > .buttons > .button-1
    Element Should Be Visible    //*[contains(text(), '${EMAIL}')]

Adicionar Produtos
    Adicionar Tenis Verde
    Adicionar BolsaMochila
    Adicionar BermudaJeans
    Adicionar BlusaBranca
    Adicionar CintoCalca
    Adicionar CalcaJeans
    Adicionar Tenis
    Adicionar Vestido

Adicionar Tenis Verde
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(8) > .product-item > .picture > a > img
    Wait    2s
    Click Element    .compare-products > .button-2
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar BolsaMochila
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(7) > .product-item > .picture > a > img
    Wait    2s
    Click Button    #add-to-cart-button-29
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar BermudaJeans
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(6) > .product-item > .picture > a > img
    Wait    2s
    Click Element    .compare-products > .button-2
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar BlusaBranca
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(5) > .product-item > .picture > a > img
    Click Element    .compare-products > .button-2
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar CintoCalca
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(4) > .product-item > .picture > a > img
    Click Button    #add-to-cart-button-40
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar CalcaJeans
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(3) > .product-item > .picture > a > img
    Wait    2s
    Click Button    #add-to-cart-button-36
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar Tenis
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(2) > .product-item > .picture > a > img
    Click Element    .selected-value > label > .color-container > .color
    Wait    2s
    Click Button    #add-to-cart-button-28
    Wait    2s
    Element Should Be Visible    //*[contains(text(), 'Apparel & Shoes')]
    Wait    2s

Adicionar Vestido
    Click Link    .top-menu > :nth-child(4) > a
    Click Element    :nth-child(1) > .product-item > .picture > a > img
    Wait    2s
    Click Button    #add-to-cart-button-5
    Wait    2s
    Click Link    .ico-cart > .cart-label
    Wait    2s

Limpar Carrinho
    Click Link    .ico-cart > .cart-label
    Click Element    :nth-child(1) > .remove-from-cart > input
    Click Element    :nth-child(2) > .remove-from-cart > input
    Click Element    :nth-child(3) > .remove-from-cart > input
    Click Element    :nth-child(4) > .remove-from-cart > input
    Click Button    .update-cart-button

Visualizar Lista De Produtos Em Falta
    Click Link    .customer-service > ul > :nth-child(5) > a

Limpar Lista De Produtos Em Falta
    Click Element    .clear-list

Ir Para Home
    Click Element    .header-logo > a > img
