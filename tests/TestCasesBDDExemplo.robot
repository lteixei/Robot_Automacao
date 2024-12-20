*** Settings ***
Resource         ResourceBDD.robot    
Resource         BDDpt-br.robot    
Suite Teardown   Fechar Navegador

*** Test Cases ***
Cenário 01: Pesquisar postagem Season Premiere
    Dado que esteja na tela HOME do blog robotizando testes
    Quando pesquisar pela palavra "introdução"
    Então a postagem "Season Running - Ep. 08: Executando seus testes no Docker" deve ser listada no resultado da pesquisa

Cenário 02: Ler postagem Season Premiere
    Dado que esteja na tela de resultado da pesquisa pela postagem "Season Running - Ep. 08: Executando seus testes no Docker"
    Quando clicar no link da postagem
    Então a tela da postagem "Season Running - Ep. 08: Executando seus testes no Docker" deve ser mostrada