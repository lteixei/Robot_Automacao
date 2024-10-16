*** Settings ***
Library           RequestsLibrary

*** Test Cases ***
CT001 Criando um novo Book
    [Tags]    Book
    Add um novo livro
