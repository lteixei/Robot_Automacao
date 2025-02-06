*** Settings ***

    Resource        ../Variables/configGlobal.robot
...    
*** Keywords ***    
...    
#------------  Valida "Login" - (tela_Login) ------------------------------
Dado eu esteja na pagina Apparels and Shoes (SICEA)
    #Login

Quando eu "adiciono os Produtos" no Carrinho (SICEA)
    # Adicionar Produtos
    # Adicionar Tenis Verde
    # Adicionar BolsaMochila
    # Adicionar BermudaJeans
    # Adicionar BlusaBranca
    # Adicionar CintoCalca
    # Adicionar CalcaJeans
    # Adicionar Tenis
    # Adicionar Vestido

E depois "Limpo os Produtos" do Carrinho (SICEA)
    #Limpar Carrinho
    # Click Link    .ico-cart > .cart-label
    # Click Element    :nth-child(1) > .remove-from-cart > input
    # Click Element    :nth-child(2) > .remove-from-cart > input
    # Click Element    :nth-child(3) > .remove-from-cart > input
    # Click Element    :nth-child(4) > .remove-from-cart > input
    # Click Button    .update-cart-button

Então Visualizo e Limpo a Lista De Produtos Em Falta e retorno para a Home (SICEA)
# Visualizar Lista De Produtos Em Falta
    # Click Link    .customer-service > ul > :nth-child(5) > a

# Limpar Lista De Produtos Em Falta
    # Click Element    .clear-list

# Ir Para Home
    # Click Element    .header-logo > a > img


    Wait Until Element Is Visible                     $\{CAMPO_USUARIO\}            $\{ESPERA\}
    Input Text                                        $\{CAMPO_USUARIO\}            $\{USUARIO\}
    Input Text                                        $\{CAMPO_SENHA\}              $\{SENHA\}
    Click Element                                     $\{BOTAO_ENTRAR\}
    Element Text Should Be                            $\{VERSAO_SICEA\}             $\{TEXTO_SICEA\}
    Log