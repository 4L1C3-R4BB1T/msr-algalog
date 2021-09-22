## Sobre
Desenvolvimento de uma API REST de gerenciamento de entregas durante o evento Mergulho Spring REST da [AlgaWorks](https://www.algaworks.com "Site da AlgaWorks").

Link da API no Heroku: 
```bash
https://algalog-api-lg.herokuapp.com
```
Para as requisições utilize: 
```bash
# endpoint clientes
https://algalog-api-lg.herokuapp.com/api/v1/clients

# endpoint entregas
https://algalog-api-lg.herokuapp.com/api/v1/deliveries

# endpoint ocorrências
https://algalog-api-lg.herokuapp.com/api/v1/deliveries/{deliveryId}/ocurrences
```

### Como executar o projeto
* Necessário ter o WAMP 

No terminal, digite o comando:
```bash
./mvnw spring-boot:run 
```
Após, utilize os links:
```bash
# endpoint clientes
http://localhost:8080/api/v1/clients

# endpoint entregas
http://localhost:8080/api/v1/deliveries

# endpoint ocorrências
http://localhost:8080/api/v1/deliveries/{deliveryId}/ocurrences
```
