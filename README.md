# Trabalho Extra

Garanta que tenha previamente instalado o docker e o maven

## Como rodar o projeto sem o docker hub

- Entre na raiz do projeto
- execute o comando ```mvn clean package``` para buildar o jar do projeto
- execute o comando ```docker build -t trabalho-extra-bernardo:1.0 .``` para buildar o trabalho no docker
- execute o comando```docker run -p 8080:8080 --name trabalho-extra-bernardo trabalho-extra-bernardo:1.0``` para executar o projeto via docker

## Como rodar o projeto com o docker hub

-  Execute o comando ```docker run -p 8080:8080 --name trabalho-extra-bernardo bernardovsantos02/trabalho-extra:1.0```