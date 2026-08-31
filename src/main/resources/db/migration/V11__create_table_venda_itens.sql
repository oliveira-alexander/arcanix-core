CREATE TABLE VENDA_ITENS(
    id bigserial primary key,
    venda_id bigserial,
    produto_id bigserial,
    custo_unitario numeric(10,2),
    preco_unitario numeric(10,2),
    quantidade numeric(10,2)
);

CREATE INDEX IDX_VENDA_ITENS ON VENDA_ITENS(ID);