# FIAP-2-JAVA-CP1
**OBS GERAL:** `rmXXXXXX` deve ser substituído pelos dados de sua matrícula.

## Descrição do cenário

Estamos aqui modelando o backend de um mini uber.

O fluxo começa com a criação da corrida, onde devem ser informados todos os dados necessários:

- data da solicitação
- cpf do cliente
- nome do cliente
- latitude e longitude de origem - onde o motorista deve buscar o cliente
- latitude e longitude de destino - onde o motorista deve chegar
- latitude e longitude atuais - onde o carro que vai fazer a corrida se encontra no momento
- Situação da corrida -> inicia como Aguardando
- placa do veículo que vai realizar a corrida
- nome do motorista
- descrição do veículo
- cor do veículo

Após criada a corrida, quando o motorista chega para buscar o cliente, sua situação é atualizada para 'Em andamento'. Alternativamente, enquanto a corrida não está em andamento, é possível realizar o cancelamento da corrida.

Durante a corrida, a latitude e longitude atuais são atualizadas de tempos em tempos, refletindo a localização do carro.

Finalmente, a qualquer tempo durante a corrida em andamento, é possível sua atualização para Concluída.

## Tabela que deve ser mapeada na aplicação (Criar no seu banco de dados):

-- Obs: trocar xxxxxx pelo número de sua matrícula
```sql
CREATE TABLE tb_corrida_xxxxxx(
    id NUMBER(19, 0) PRIMARY KEY,
    dt_solicitacao TIMESTAMP NOT NULL,
    dt_finalizacao TIMESTAMP,
    nr_cpf_cliente varchar(11) NOT NULL,
    ds_nome_cliente varchar(255) NOT NULL,
    nr_latitude_origem NUMBER(5,5) NOT NULL,
    nr_longitude_origem NUMBER(5,5) NOT NULL,
    nr_latitude_destino NUMBER(5,5) NOT NULL,
    nr_longitute_destino NUMBER(5,5) NOT NULL,
    nr_latitude_atual NUMBER(5,5) NOT NULL,
    nr_longitude_atual NUMBER(5,5) NOT NULL,
    cd_situacao_corrida char(1) NOT NULL,
    nr_placa_veiculo varchar(10) NOT NULL,
    ds_nome_motorista varchar(255) NOT NULL,
    ds_veiculo varchar(255) NOT NULL,
    ds_cor_veiculo varchar(255) NOT NULL
);

-- Obs: trocar xxxxxx pelo número de sua matrícula
-- A - Aguardando
-- E - Em andamento
-- C - Concluída
-- X - Cancelada
ALTER TABLE tb_corrida_xxxxxx
    ADD CONSTRAINT check_situacao_corrida
    CHECK (cd_situacao_corrida IN ('A', 'E', 'C', 'X'));

-- Obs: trocar xxxxxx pelo número de sua matrícula
CREATE SEQUENCE sq_tb_corrida_xxxxxx MINVALUE 1;

## Requisitos funcionais

- Criar uma api REST que deve atender no endereço http://localhost:xxxx/rmXXXXXX/corridas.
  - xxxx são os 4 últimos dígitos da sua matrícula.
  - rmXXXXXX é a sua matrícula.
  - Pesquisar como alterar a porta e o contexto da aplicação com spring boot.
  - Operações
    - POST http://localhost:xxxx/rmXXXXXX/corridas - Deve receber um json com os dados necessários para criar um registro na tabela acima. Deve retornar um JSON com a corrida criada, incluindo o ID gerado.
      - Regras:
        - O par latitude e longitude de origem não podem ser iguais ao par latitute e longitude de destino
        - Não é permitida a criação de uma corrida para um cliente se ele já possuir uma corrida em andamento
        - A situação inicial da corrida ao ser criada é 'A' - Aguardando
        - Ao ser criada, a data da solicitação da corrida assume a data e hora do momento da criação.
    - PUT http://localhost:xxxx/rmXXXXXX/corridas/{id}/situacao - Deve receber a situação no Body da requisição e atualizar a situação da corrida enviada no id.
      - Regras:
        - Se não existir corrida com o id passado, devolver um erro.
        - Os fluxos possíveis das situações são:
          - Aguardando -> Em andamento -> Concluída
          - Aguardando -> Cancelada
        - Só devem ser permitidas atualizações que atendam a um dos fluxos acima. Em caso negativo, deve retornar um erro
        - Se o status recebido for Cancelada ou Concluída, a data de finalização deve ser atualizada para a data e hora do momento da chamada
        - Se o status recebido for Em andamento, deve ser verificado se a latitude e longitude atuais são iguais às latitudes e longitudes de origem. Caso contrário, deve lançar um erro.
    - PUT http://localhost:xxxx/rmXXXXXX/corridas/{id}/posicao-atual - Deve receber no corpo da requisição um json com a latitude e longitude atual para atualização dos dados na tabela da corrida com o id recebido
      - Regras:
        - Se não existir corrida com o id recebido, retornar erro
        - nenhum dos valores pode ser nulo

## Requisitos não funcionais:

- Pilha tecnológica a ser utilizada: Spring Boot + Spring Web + Spring Data JPA + Lombok + Validation + Banco Oracle
- Não expor as entidades na API. Utilizar DTO para entrada e saída de dados
- Utilizar validação nos DTOs e customizar as mensagens de erro
- Regras de negócio não devem estar na classe de API. Utilizar Services
- Criar uma exceção não checada própria para lançar erros de negócio
- Utilizar lombok para reduzir a verbosidade das classes, evitando getters e setters
- Utilizar Records para criar os DTOs
- As situações da corrida no código sempre devem ser representadas por enum. Pesquisar:
  - como converter enum para json e vice-versa
  - como converter um valor para um enum no JPA. Dica: pesquisar a anotação @Converter e a classe AttributeConverter
- O id da corrida deve ser gerado pelo banco de dados através da sequence sq_tb_corrida_xxxxxx.

- Dados do projeto a ser entregue:
  - group: br.com.fiap.jadv
  - artifactId: rmXXXXXX-checkpoint
  - nome do projeto: rmXXXXXX-checkpoint
  - package name
