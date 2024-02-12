INSERT INTO cliente(id, limite, saldo_inicial)
SELECT 1, 100000, 0
WHERE NOT EXISTS (
    SELECT 1 FROM cliente WHERE id = 1
);

INSERT INTO cliente(id, limite, saldo_inicial)
SELECT 2, 80000, 0
WHERE NOT EXISTS (
    SELECT 1 FROM cliente WHERE id = 2
);

INSERT INTO cliente(id, limite, saldo_inicial)
SELECT 3, 1000000, 0
WHERE NOT EXISTS (
    SELECT 1 FROM cliente WHERE id = 3
);

INSERT INTO cliente(id, limite, saldo_inicial)
SELECT 4, 10000000, 0
WHERE NOT EXISTS (
    SELECT 1 FROM cliente WHERE id = 4
);

INSERT INTO cliente(id, limite, saldo_inicial)
SELECT 5, 500000, 0
WHERE NOT EXISTS (
    SELECT 1 FROM cliente WHERE id = 5
);
