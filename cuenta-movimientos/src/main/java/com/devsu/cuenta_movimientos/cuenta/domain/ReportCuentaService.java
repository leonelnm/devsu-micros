package com.devsu.cuenta_movimientos.cuenta.domain;

import com.devsu.cuenta_movimientos.cuenta.infra.dto.ReportCuentaDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReportCuentaService {
    List<ReportCuentaDTO> getReportCuentas(LocalDate fecha, Long clienteid);
}
