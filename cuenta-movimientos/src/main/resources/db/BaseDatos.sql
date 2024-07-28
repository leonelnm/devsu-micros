CREATE TABLE IF NOT EXISTS `cuenta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `saldo` decimal(38,2) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `tipo` enum('AHORROS','CREDITO') NOT NULL,
  `estado` tinyint(1) DEFAULT '1',
  `clienteid` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_cuenta_numero` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `saldo_disponible` decimal(38,2) NOT NULL,
  `saldo_inicial` decimal(38,2) NOT NULL,
  `valor` decimal(38,2) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `tipo` enum('DEPOSITO','RETIRO') NOT NULL,
  `cuenta_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movimiento_cuenta` (`cuenta_id`),
  CONSTRAINT `fk_movimiento_cuenta` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;