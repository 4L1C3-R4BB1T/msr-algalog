[![NPM](https://img.shields.io/npm/l/react)](https://github.com/4L1C3-R4BB1T/msr-algalog/blob/main/LICENSE) 

## Sobre
Desenvolvimento de uma API REST de gerenciamento de entregas durante o evento Mergulho Spring REST da [AlgaWorks](https://www.algaworks.com "Site da AlgaWorks").

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
