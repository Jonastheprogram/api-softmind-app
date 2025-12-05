# Softmind API

Esta API RESTful foi desenvolvida como back-end do aplicativo de bem-estar SoftMind, responsável por gerenciar dados dos usuários, como registros de humor, check-ins diários e lembretes organizacionais.
Além disso, integra-se a serviços externos, incluindo IAs generativas para o chatbot de apoio emocional.


## 🏛️ Arquitetura do Sistema
A aplicação segue uma arquitetura **3-tier**, desacoplando as responsabilidades em camadas claras:

### **1. Cliente (Front-End)**
- Aplicativo Android desenvolvido com **Kotlin** e **Jetpack Compose**.
- Comunicação HTTP via **Retrofit**.

### **2. Servidor (Back-End)**
- Desenvolvido em **Java + Spring Boot**.
- Contém regras de negócio, segurança, integração com IA e validações.

### **3. Banco de Dados**
- **MongoDB Atlas (NoSQL)** hospedado em nuvem.
- Acesso via **Spring Data MongoDB**.

---

## 🧩 Estrutura Interna da API

### **Controller (Entrada da Aplicação)**
- Mapeia endpoints como `/humor`, `/lembrete`, `/chat`.
- Recebe requisições HTTP.
- Retorna respostas em JSON.
- Chama a camada de serviço.

### **Service (Regras de Negócio)**
- Implementa lógica da aplicação.
- Exemplo: `GeminiChatService` integra a API ao modelo Gemini.

### **Repository (Persistência)**
- Interfaces que estendem `MongoRepository`.
- Realizam operações CRUD no MongoDB.
- Exemplo: `LembreteRepository` manipula a coleção `lembretes`.

### **Model (Entidades/Documentos)**
- Representam documentos do MongoDB.
- Anotadas com `@Document`.
- Exemplo: `Lembrete.java`.

---

## 🔐 Segurança – API Key
A API utiliza autenticação baseada em **chave de API estática**.

### **Como funciona:**
- Toda requisição deve conter o header:
  ```
  X-API-KEY: sua-chave-configurada
  ```
- A chave é validada em `ApiKeyAuthFilter`.
- Autorização configurada em `SecurityConfig`.
- Sem a chave correta → **401 Unauthorized** ou **403 Forbidden**.

---

## 🔗 Integração com o App Android
Para o app Android se conectar corretamente:

1. Configurar o `RetrofitClient.kt` com o **IP da API**.
2. Adicionar a **API Key** nos headers.
3. Garantir que o dispositivo e a API estejam na **mesma rede**.

---

## 🛠 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Web** (REST)
- **Spring Data MongoDB**
- **Spring Security** (API Key)
- **MongoDB Atlas / Compass**
- **Kotlin (Android)** + **Retrofit** + **Jetpack Compose**

---


## 🚀 Como Executar o Projeto

### **1. Clonar o repositório**
```bash
git clone https://github.com/Jonastheprogram/api-softmind-app
```

### **2. Configurar o banco de dados**
Crie um cluster no MongoDB Atlas ou utilize um local.
No arquivo `application.properties` configure:
```properties
spring.data.mongodb.uri=mongodb+srv://usuario:senha@clusterURL/banco
api.key=sua-chave-secreta
```

### **3. Executar a API**
```bash
mvn spring-boot:run
```
### **4. Baixar e instalar o app**
  - Baixe e instale o arquivo SoftMind.apk, após a instalação e execução da api estará tudo pronto para uso.
---
## 📱 Vídeo demonstração

![demo](https://github.com/user-attachments/assets/3c070105-f387-4b4a-9c15-13d6cec56b0d)


## 🎯 Conclusão
A SoftMind API fornece uma estrutura segura e escalável que integra monitoramento emocional, organização diária e inteligência artificial, oferecendo suporte completo ao aplicativo Android do ecossistema SoftMind.

---
 *Projeto acadêmico denominado "Challenge" solicitado pela Faculdade de Informática e Administração Paulista - FIAP*


 ![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)
