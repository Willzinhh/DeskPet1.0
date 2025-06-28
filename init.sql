-- Criação da tabela cliente_usuario
CREATE TABLE IF NOT EXISTS cliente_usuario (
                                               id SERIAL PRIMARY KEY,
                                               nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    cnpj VARCHAR(18),
    telefone VARCHAR(20) NOT NULL,
    endereco TEXT,
    plano VARCHAR(50) NOT NULL,
    nome_empresa VARCHAR(100)
    );

-- Criação da tabela usuario
CREATE TABLE IF NOT EXISTS usuario (
                                       id SERIAL PRIMARY KEY,
                                       email VARCHAR(100) UNIQUE NOT NULL,
    senha_hash VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    cliente_usuario_id INTEGER REFERENCES cliente_usuario(id) ON DELETE CASCADE
    );

-- Criação da tabela clientes
CREATE TABLE IF NOT EXISTS clientes (
                                        id SERIAL PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(14),
    endereco TEXT,
    data_criacao TIMESTAMP DEFAULT NOW(),
    cliente_usuario_id INTEGER REFERENCES cliente_usuario(id) ON DELETE CASCADE
    );

-- Criação da tabela pet
CREATE TABLE IF NOT EXISTS pet (
                                   id SERIAL PRIMARY KEY,
                                   nomepet VARCHAR(100) NOT NULL,
    especie VARCHAR(100) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMP DEFAULT NOW(),
    cliente_usuario_id INTEGER REFERENCES cliente_usuario(id) ON DELETE CASCADE,
    tutor_id INTEGER REFERENCES clientes(id) ON DELETE CASCADE
    );

-- Criação da tabela servicos
CREATE TABLE IF NOT EXISTS servicos (
                                        id SERIAL PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMP DEFAULT NOW(),
    pet_id INTEGER REFERENCES pet(id),
    tutor_id INTEGER REFERENCES clientes(id),
    cliente_usuario_id INTEGER REFERENCES cliente_usuario(id) ON DELETE CASCADE
    );
