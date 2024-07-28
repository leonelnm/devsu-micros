package com.devsu.cuenta_movimientos.cuenta.infra;

import com.devsu.commons.exception.EntidadNoEncontradaException;
import com.devsu.cuenta_movimientos.cuenta.domain.Cuenta;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.cuenta.domain.ReportCuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.adapters.ClientePersonaProxy;
import com.devsu.cuenta_movimientos.cuenta.infra.dto.ClienteDTO;
import com.devsu.cuenta_movimientos.cuenta.infra.dto.ReportCuentaDTO;
import com.devsu.cuenta_movimientos.movimiento.domain.Movimiento;
import com.devsu.cuenta_movimientos.movimiento.infra.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportCuentaServiceImpl implements ReportCuentaService {

    @Autowired
    private ClientePersonaProxy clientePersonaProxy;

    @Autowired
    private CuentaService cuentaService;


    @Override
    public List<ReportCuentaDTO> getReportCuentas(LocalDate fecha, Long clienteid) {
        ClienteDTO cliente = clientePersonaProxy.getCliente(clienteid);
        if (cliente == null) {
            throw new EntidadNoEncontradaException("El cliente no existe");
        }

        List<Cuenta> cuentasCliente = cuentaService.getCuentasByCliente(clienteid);
        List<ReportCuentaDTO> reportCuentas = new ArrayList<>();

        return cuentasCliente.stream()
                .flatMap(cuenta -> cuenta.getMovimientos().stream()
                .filter(movimiento -> movimiento.getFecha().toLocalDate().isEqual(fecha))
                .map(movimiento -> mapToReportCuentaDTO(fecha, cliente, cuenta, movimiento)))
                .collect(Collectors.toList());
    }

    private ReportCuentaDTO mapToReportCuentaDTO(LocalDate fecha, ClienteDTO cliente, Cuenta cuenta, Movimiento movimiento) {
        BigDecimal valorFinal = TipoMovimiento.RETIRO.equals(movimiento.getTipo())
                ? movimiento.getValor().negate()
                : movimiento.getValor();

        return new ReportCuentaDTO(
                fecha,
                cliente.nombre(),
                cuenta.getNumero(),
                cuenta.getTipo(),
                cuenta.getSaldo(),
                cuenta.getSaldo().subtract(movimiento.getValor()),
                cuenta.getEstado(),
                valorFinal
        );
    }

}
