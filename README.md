## Sobre
Desenvolvimento de uma API REST de gerenciamento de entregas durante o evento Mergulho Spring REST da [AlgaWorks](https://www.algaworks.com "Site da AlgaWorks").

Link da API no Heroku: 
```
https://algalog-api-lg.herokuapp.com
```
Para as requisições utilize: 
```
# endpoint clientes
https://algalog-api-lg.herokuapp.com/api/v1/clients

# endpoint entregas
https://algalog-api-lg.herokuapp.com/api/v1/deliveries

# endpoint ocorrências
https://algalog-api-lg.herokuapp.com/api/v1/deliveries/{deliveryId}/ocurrences
```

### Como executar o projeto
No terminal, digite o comando:
```shell script
./mvnw spring-boot:run 
```
Após, utilize o link:
```
# endpoint clientes
http://localhost:8080/api/v1/clients

# endpoint entregas
http://localhost:8080/api/v1/deliveries

# endpoint ocorrências
http://localhost:8080/api/v1/deliveries/{deliveryId}/ocurrences
```
