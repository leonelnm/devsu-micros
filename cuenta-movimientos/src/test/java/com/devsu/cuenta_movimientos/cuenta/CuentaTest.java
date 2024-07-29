package com.devsu.cuenta_movimientos.cuenta;

import com.devsu.cuenta_movimientos.CuentaMovimientosApplicationTests;
import com.intuit.karate.junit5.Karate;

public class CuentaTest extends CuentaMovimientosApplicationTests {

    @Karate.Test
    Karate crearCuenta() {
        return Karate.run("src/test/resources/features/cuenta.feature");
    }

}
