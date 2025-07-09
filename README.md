# 📚 Sistema de Gestão de Patrimônio por Campus - IFPB

### Este projeto tem como objetivo importar, tratar, organizar e consultar dados de bens patrimoniais do IFPB com foco em separar livros, equipamentos de informática/técnico, e mobília além de calcular informações por campus. Os dados são extraídos de um arquivo CSV utilizando a biblioteca OpenCSV e armazenados em um banco de dados MySQL.

## 🚀 Funcionalidades

- 📥 **Importação de dados patrimoniais a partir de arquivo CSV.**
- 🧹 **Tratamento e normalização dos dados antes de salvar no banco.**
- 📚 **Separação automática de livros, equipamentos de informática/técnico e mobília com base em palavras-chave.**
- 🏫 **Consulta de patrimônio por campus**.
- 💰 **Cálculo do valor líquido contábil total por campus.**
- 🔍 **Busca por descrição de patrimônio**.
- 🗃️ **Armazenamento em banco MySQL com JPA/Hibernate**.

---

## 📁 Estrutura das Entidades

### `Patrimonio`
**Contém dados patrimoniais gerais como número, descrição, situação, estado de conservação, valor inicial, valor líquido total e o campus associado.**

### `Livro` `EquipamentoDeInformatica` `EquipamentoTecnico` `Mobilia`
**Contém apenas patrimônios classificados como livros, equipamentos de informática/técnico e mobília extraídos da tabela `Patrimonio`.**

### `Campus`
**Representa os campus do IFPB, sendo relacionados com os patrimônios.**

---

## 🔧 Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **OpenCSV → para leitura e tratamento do arquivo CSV**
- **Maven → gerenciamento de dependências**

---

## 1- Como executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/levibezerra/projeto-dados-semiestruturados.git

---

## 2- Configure o application.yml: 
- **spring:**
  - **datasource:**
    - **url: jdbc:mysql://localhost:3306/bdteste1?useSSL=false&serverTimezone=UTC**
    - **username: seu_root**
    - **password: sua_senha**
    - **driver-class-name: com.mysql.cj.jdbc.Driver**

---

## 3- Certifique-se de que o arquivo patrimonio-2019.csv esteja na pasta:

- **src/main/resources/**

---

## 4- Execute a aplicação via IDE ou comando:

- **./mvnw spring-boot:run**

---

# 🔌 Endpoints disponíveis

### 📥 Importar Patrimônio:

- **GET /api/patrimonios/importar?campus=NOME_DO_CAMPUS**

---

### 💰 Calcular Valor Líquido por Campus:

- **GET /api/patrimonios/valor-liquido-total?campus=NOME_DO_CAMPUS**

---

### 📚 Separar patrimônios da base:

- **GET /api/livros/separar**
- **GET /api/informatica/separar**
- **GET /api/tecnico/separar**
- **GET /api/mobilia/separar**

---

# 📌 Observação
- **A separação é feita por palavras-chave presentes na descrição.**