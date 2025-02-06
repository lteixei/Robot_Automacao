*** Settings ***
Resource        ../Resources/Automacao_Nova.resource

Test Setup        Run Keywords
...                   Abre navegador na pagina do (SICEA)
Test Teardown     Fechar navegador\line

*** Test Cases ***
#-----------------------------------------
Caso de Teste CT01 - Apparels and Shoes - (tela_Apparels_Shoes)
    [Documentation]    Valida a Tela - Apparels and Shoes com sucesso no SICEA .
    [Tags]             EfetuaLoginComSucesso        Regressivo

    Dado eu esteja na pagina Apparels and Shoes (SICEA)
    Quando eu "adiciono os Produtos" no Carrinho (SICEA)
    E depois "Limpo os Produtos" do Carrinho (SICEA)
    Então Visualizo e Limpo a Lista De Produtos Em Falta e retorno para a Home (SICEA)