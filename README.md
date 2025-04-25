# Conserto API - P2

API REST para gerenciamento de consertos de veículos realizada para a P2 da matéria PRW3/2025.

## Base URL

```
http://localhost:8080/consertos
```

---

## Endpoints

### 📌 Cadastrar Conserto

- **POST** `/consertos`
- **Request body:**
```json
{
  "dtEntrada": "20/04/2024",
  "dtSaida": "25/04/2024",
  "mecanico": {
    "nome": "João",
    "anosExperiencia": 10
  },
  "veiculo": {
    "marca": "Fiat",
    "modelo": "Uno",
    "ano": "2010",
    "cor": "Branco"
  }
}
```
- **Response:** `201 Created` com os dados detalhados do conserto.

---

### 📄 Listar Todos os Consertos

- **GET** `/consertos`
- **Query params opcionais:** `page`, `size`, `sort`
- **Response:** Página com lista de consertos

---

### 🔍 Buscar Conserto por ID

- **GET** `/consertos/{id}`
- **Response:** `200 OK` com dados do conserto ou `404 Not Found`

---

### 🧾 Resumo dos Consertos

- **GET** `/consertos/resumo`
- Retorna uma lista com: data de entrada, data de saída, nome do mecânico, marca e modelo do veículo.
- **Response:** `200 OK` com lista de objetos resumo

---

### ✏️ Atualizar Conserto

- **PUT** `/consertos`
- **Request body:**
```json
{
  "id": 1,
  "dtEntrada": "22/04/2024",
  "dtSaida": "28/04/2024",
  "mecanico": {
    "nome": "Carlos",
    "anosExperiencia": 12
  },
  "veiculo": {
    "marca": "Ford",
    "modelo": "Ka",
    "ano": "2012",
    "cor": "Preto"
  }
}
```
- **Response:** `200 OK` com dados atualizados ou `404 Not Found`

---

### ❌ Excluir Conserto (Lógico)

- **DELETE** `/consertos/{id}`
- Marca o conserto como inativo
- **Response:** `204 No Content` ou `404 Not Found`

 sistema usa soft delete: consertos excluídos não aparecem no resumo.