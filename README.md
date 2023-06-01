# AuthToken

## Descrição

A aplicação AuthToken tem como objetivo gerar tokens válidos com base na tabela de usuários.

## Endpoint

O endpoint para geração do token é `/authToken/api/auth`.

### Requisição

- Método: POST
- Corpo da requisição: JSON

Exemplo de corpo da requisição:

```JSON
{
  "login": "dantas",
  "password": "123"
}
```

### Resposta
A resposta da requisição é um token no formato de string.

Exemplo de resposta:

```JSON
{
  	"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkRhbntkYW50YXN9cyJ9.EwgWb1GikTCALn6P3brElLqNTnSfC2mQz5W5nCvWBJA"
}
```

O token gerado será necessário para autenticação em outros endpoints da aplicação.~


## Build e Deploy

Para fazer o build da aplicação: `mvn clean package`

O build vai gerar um arquivo: `integracao-raizen.war` no diretório `target/`

Esse arquivo de build deve ser deployado no Tomcat através do **Probe**

## Como contribuir

Se você deseja contribuir com o projeto, siga as etapas abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch com sua contribuição: git checkout -b minha-contribuicao.
3. Faça as alterações desejadas e commit.
4. Envie suas alterações para o seu repositório fork: git push origin minha-contribuicao.
5. Abra um pull request no repositório original.