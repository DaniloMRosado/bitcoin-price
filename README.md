# 💰 Bitcoin Price Live - Spring Boot + Thymeleaf

[![CI - Build Spring Boot App](https://github.com/DaniloMRosado/bitcoin-price/actions/workflows/ci.yml/badge.svg)](https://github.com/DaniloMRosado/bitcoin-price/actions/workflows/ci.yml)

Um projeto web desenvolvido com **Spring Boot** e **Thymeleaf** que exibe, em tempo real, o **preço atual do Bitcoin** e sua **variação nas últimas 24h** usando a API pública do [CoinGecko](https://www.coingecko.com/).

> 💡 Projeto 100% local, sem dependência de serviços em nuvem.

---

## 🖼️ Preview

![Bitcoin Price UI](https://i.imgur.com/5w2Sz04.png)  
*Interface moderna com design responsivo e visual em tempo real.*

---

## ⚙️ Tecnologias utilizadas

- ✅ **Java 17**
- ✅ **Spring Boot 3**
- ✅ **Thymeleaf**
- ✅ **Bootstrap 5**
- ✅ **Font Awesome & Google Fonts**
- ✅ **REST API (CoinGecko)**
- ✅ **Atualização automática a cada 30s (JavaScript)**

---

## 📦 Funcionalidades

- 🔁 Consulta em tempo real do valor do **Bitcoin em dólares (USD)**
- 📉 Mostra a **variação percentual das últimas 24 horas**
- 🟢 Indicadores visuais com **setas e cores** (verde para alta, vermelho para queda)
- 🔄 Botão e script de **atualização automática** a cada 30 segundos
- 🎨 Layout bonito, responsivo e pronto para dispositivos móveis

---

## 🧪 Como rodar localmente

### Pré-requisitos

- Java 17+
- Maven

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/bitcoin-price-live.git

# Acesse o diretório
cd bitcoin-price-live

# Rode a aplicação
./mvnw spring-boot:run
